package org.data.jsonconvertor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.data.connection.ImgAcqStationProfileDao;
import org.data.connection.StationProfileDaoMongo;
import org.data.form.ImgAcqStationProfile;
import org.data.handle.JsonReadWrite;
import org.data.handle.TechnicalPlateau;
import org.data.handle.Utils;

public class ImgAcqStationProfileConvertor {
	private static String prefixe = "m3p:";
	
	public static void ImgAcqStationProfileConvertToJson(String filename,
			boolean writeInFile, boolean formated) {
		// List<LinkedHashMap<String, Object>> jsons = new
		// ArrayList<LinkedHashMap<String, Object>>();
		
		ImgAcqStationProfileDao iaspd = new ImgAcqStationProfileDao(null);
		
		try {
			StationProfileDaoMongo statProfDaoMongo = new StationProfileDaoMongo();
			
			//imgacqstationprofileid maximum des profils station deja presents dans la base mongodb
			//Rq : les docs ne sont p-e pas inseres dans l'ordre dans mongodb,
			//par consequent, l'imgacqstationprofileid max ne correspond pas forcement au dernier doc insere
			int idMax = statProfDaoMongo.getImgacqstationprofileidMax();
			
			//num incremental de l'uri du dernier document profil station insere dans la base mongodb
			int numIncrUriStatProf = statProfDaoMongo.getStationProfileUriNumIncrLastInserted();
			
			String query = " select * from imgacqstationprofiles where imgacqstationprofileid > " + idMax +  " order by imgacqstationprofileid;";
			ResultSet rs = iaspd.resultSet(query);
			FileWriter file = new FileWriter(filename);
			
			while (rs.next()) {
				numIncrUriStatProf ++;
				ImgAcqStationProfile iasp = iaspd.get(rs);
				LinkedHashMap<String, Object> stationProfile = new LinkedHashMap<String, Object>();
				stationProfile.put("uri",  ImgAcqStationProfileConvertor.createUriStationProfile(
						iasp.getTechnicalPlateau(), numIncrUriStatProf));
				LinkedHashMap<String, Object> configuration = new LinkedHashMap<String, Object>();
				configuration.put("provider", "phenowaredb");
				configuration.put("stationid", iasp.getStationid());
				configuration.put("imgacqstationprofileid",
						iasp.getImgacqstationprofileid());
				configuration.put("imgacqstationprofilename",
						iasp.getImgacqstationprofilename());
				stationProfile.put("configuration", configuration);
				stationProfile.put("validatedProfile", iasp.isValidated());
				stationProfile.put("deletedProfile", iasp.isDeleted());
				stationProfile.put("description", iasp.getDescription());
				LinkedHashMap<String, Object> settings = new LinkedHashMap<String, Object>();
				settings.put("verticalPosition", iasp.getIndexer());
				settings.put("topLight", iasp.getToplight());
				settings.put("sideLight", iasp.getSidelight());
				settings.put("zoom", iasp.getZoom());
				settings.put("focus", iasp.getFocus());
				settings.put("aperture", iasp.getAperture());
				settings.put("rotationSpeed", iasp.getRotationspeed());
				settings.put("topViewCount", iasp.getTopviewcount());
				settings.put("sideViewCount", iasp.getSideviewcount());
				stationProfile.put("settings", settings);
				
				if (writeInFile){
					String jsonString = new org.json.JSONObject(stationProfile)
					.toString();
					// file.write("Document json "+i+"\n");

					if (formated)
						file.write(Utils.prettyJsonFormat(jsonString) + "\n");
					else
						file.write(jsonString + "\n");
					// System.out.println("Writing the document " + i+": " +
					// jsonString);

					file.flush();
				}
				
				//Insertion du document JSON dans Mongodb
				statProfDaoMongo.getCollection().insertOne(new Document(stationProfile));

			}

			System.out.println("Finish");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			iaspd.getConnect().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private static String createUriStationProfile(TechnicalPlateau tp, int numIncr) {
		String uri ;
		Calendar c = new GregorianCalendar();
		int annee = c.get(Calendar.YEAR);  //l'annee ou on insere ce nveau profil (ie : l'annee en cours)
		switch (tp) {
        case Phenoarch:  uri = prefixe + "arch/" + annee + "/psc" + (annee-2000) + String.format("%03d", numIncr) ;
                 break;
        case Phenopsis:  uri = prefixe + "psis/" +annee + "/psb" + (annee-2000) + String.format("%03d", numIncr) ;
                 break;
        case Phenodyn:  uri = prefixe + "dyn/" +annee + "/psa" + (annee-2000) + String.format("%03d", numIncr) ;
                 break;
        default: uri = "";
                 break;
		}
		
		return uri;
	}

	public static void ExportToFile(String filename) {
		//List<LinkedHashMap<String, Object>> jsons3 = ImgAcqStationProfileConvertToJson();
		//JsonReadWrite jrw3 = new JsonReadWrite();
		//jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ImgAcqStationProfileConvertToJson("Data/ImgStationProfile.json", true, true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
