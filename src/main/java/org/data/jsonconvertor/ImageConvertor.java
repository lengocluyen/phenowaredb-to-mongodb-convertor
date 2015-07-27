package org.data.jsonconvertor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.bson.Document;
import org.data.connection.CameraProfileDaoMongo;
import org.data.connection.ImageDao;
import org.data.connection.ImageDaoMongo;
import org.data.connection.PlantDao;
import org.data.connection.PlantDaoSesame;
import org.data.connection.StationProfileDaoMongo;
import org.data.form.Image;
import org.data.form.Plant;
import org.data.handle.TechnicalPlateau;
import org.data.handle.Utils;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;

import com.mongodb.BasicDBObject;

public class ImageConvertor {
	private static String prefixe = "m3p:";
	private static String m3p = "http://www.phenome-fppn.fr/m3p/";
	private static String serverPath = "http://stck-lespe.supagro.inra.fr/";
	private static String webPath = "http://lps-phis.supagro.inra.fr/phis/data/";

	public static void ImagesConvertToJson(String filename, boolean formated) throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		//List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImageDao id = new ImageDao(null);
		//List<Image> imgs = id.all(false);

		try {
		
			ImageDaoMongo imgDaoMongo = new ImageDaoMongo();
			//imgid maximum des images deja presentes dans la base mongodb
			//Rq : les docs images ne sont p-e pas inseres dans l'ordre dans mongodb,
			//par consequent, l'imgid max ne correspond pas forcement au dernier doc insere
			int imgidMax = imgDaoMongo.getImgidMax();
			System.out.println("ImgidMax dans mongodb " + imgidMax);

			//num incremental de l'uri du dernier document image insere dans la base mongodb
			int numIncrUriImg = imgDaoMongo.getImageUriNumIncrLastInserted();   
			CameraProfileDaoMongo camProfDaoMongo = new CameraProfileDaoMongo();
			StationProfileDaoMongo statProfDaoMongo = new StationProfileDaoMongo();
			
			String query = " select * from images where imgid > " + imgidMax + " order by imgid;";
			ResultSet rs = id.resultSet(query);
			FileWriter file = new FileWriter(filename);
			
			PlantDaoSesame pds = new PlantDaoSesame();
			
			while(rs.next())
			{
				numIncrUriImg ++;
				Image img = id.get(rs);
				LinkedHashMap<String, Object> image = new LinkedHashMap<String, Object>();
				PlantDao pld = new PlantDao(id.getConnect());
				Plant pl = pld.single(img.getStudyid(),img.getPlantid());

				image.put("uri", ImageConvertor.createUriImage(img.getTechnicalPlateau(), img.getAcquisitiondate(), numIncrUriImg));

				Map<String, Object> context = new LinkedHashMap<String, Object>();

				if(pl!=null){
					context.put("plant", pds.getURIFromAlias(pl.getPlantCode()));
					context.put("plantAlias", pl.getPlantCode());
				}
				else{
					System.out.println("Erreur  : pas de plante pr l'image "+ img.getImgid());
					context.put("plant", "");
					context.put("plantAlias", "");
				}

				context.put("genotype", "");
				context.put("genotypeAlias",  "");
				if(img.getStudy() != null)
					context.put("experiment", m3p + img.getStudy().getName());
				else
					context.put("experiment", "");
				context.put("experimentAlias", img.getStudy().getName());
				context.put("study", "");
				context.put("studyAlias", "");
				context.put("platform", m3p);
				context.put("technicalPlateau",
						m3p + "phenoarch");
				image.put("context", context);

				image.put("timestamp", img.getTimestamps());
				image.put("date", img.getAcquisitiondate());
				image.put("imageCameraProfile", camProfDaoMongo.getCameraProfileUri(img.getImgacqprofileid())); //URI trouvee dans base mongo
				image.put("imageStationProfile", statProfDaoMongo.getStationProfileUri(img.getImgacqprofileid()));//URI trouvee dans base mongo					

				Map<String, Object> configuration = new LinkedHashMap<String, Object>();
				configuration.put("provider", "phenowaredb");
				configuration.put("imgid", img.getImgid());
				configuration.put("plantid", img.getPlantid());
				configuration.put("studyname", img.getStudy().getName());  //pas tres utile (cf experiment et surtout experimentAlias)
				configuration.put("taskid", img.getTaskid());
				configuration.put("stationid", img.getStationid());
				configuration.put("imgacqprofileid", img.getImgacqprofileid());
				if(img.getRootPath() != null)
					configuration.put("rootpath",  img.getRootPath().getDirpath());
				else
					configuration.put("rootpath",  "");				
				configuration.put("subfolder", img.getSubfolder());

				Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
				nextLocation.put("lane", img.getLane());
				nextLocation.put("rank", img.getRank());
				nextLocation.put("level", img.getLevel());

				configuration.put("nextLocation", nextLocation);

				image.put("configuration", configuration);
				image.put("userValidation", img.isValid());
				image.put("isReferenceImage", img.isRefimage());
				if( img.getViewType()!=null)
					image.put("viewType", img.getViewType().getViewtypelabel());
				else
					image.put("viewType","");

				image.put("cameraAngle", img.getImgangle());
				image.put("fileName", img.getImgguid());

				image.put("serverPath", serverPath);	
				image.put("imageServerPath", serverPath + "phenoarch/raw/"+img.getStudy().getName()+"/"+img.getTaskid()+"/"+img.getImgguid()+img.getFileFormat());
				image.put("imageWebPath", webPath + "phenoarch/raw/"+img.getStudy().getName()+"/"+img.getTaskid()+"/"+img.getImgguid()+img.getFileFormat());
				image.put("thumbServerPath", serverPath + "phenoarch/thumbs/"+img.getStudy().getName()+"/"+img.getTaskid()+"/"+img.getImgguid()); 
				image.put("thumbWebPath", webPath + "phenoarch/thumbs/"+img.getStudy().getName()+"/"+img.getTaskid()+"/"+img.getImgguid()); 
				image.put("binaryServerPath", "unspecified");
				image.put("binaryWebPath", "unspecified");
				image.put("md5", "unspecified");

				// jsons.add(image);

				String jsonString = new org.json.JSONObject(image)
				.toString();
				// file.write("Document json "+i+"\n");

				if (formated)
					file.write(Utils.prettyJsonFormat(jsonString) + "\n");
				else
					file.write(jsonString + "\n");
				// System.out.println("Writing the document " + i+": " +
				// jsonString);

				file.flush();

				//Insertion du document JSON dans Mongodb
				imgDaoMongo.getCollection().insertOne(new Document(image));
			}

			System.out.println("Finish");
			pds.getConnection().close();
			file.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		// return jsons;
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	private static String createUriImage(TechnicalPlateau tp, String date, int numIncr) {
		String uri ;
		String annee = date.substring(0, 4);
		switch (tp) {
        case Phenoarch:  uri = prefixe + "arch/" + annee + "/ic" + annee.substring(2) + String.format("%09d", numIncr) ;
                 break;
        case Phenopsis:  uri = prefixe + "psis/" +annee + "/ib" + annee.substring(2) + String.format("%09d", numIncr) ;
                 break;
        case Phenodyn:  uri = prefixe + "dyn/" +annee + "/ia" + annee.substring(2) + String.format("%09d", numIncr) ;
                 break;
        default: uri = "";
                 break;
		}
		
		return uri;
	}

	public static void ExportToFile(String filename) {
		//List<LinkedHashMap<String, Object>> jsons3 = ImagesConvertToJson();
		//JsonReadWrite jrw3 = new JsonReadWrite();
		//jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		//ExportToFile("Data/Image.json");
		try {
			ImagesConvertToJson("Data/Image2.json", true);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryEvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
		
	}
}
