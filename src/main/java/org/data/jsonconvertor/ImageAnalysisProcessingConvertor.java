package org.data.jsonconvertor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.data.connection.ImageDao;
import org.data.connection.ImgProcProfileDao;
import org.data.connection.ImgProcProfileDaoMongo;
import org.data.connection.ImgProcResultDao;
import org.data.form.Image;
import org.data.form.ImgProcProfile;
import org.data.form.ImgProcResult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImageAnalysisProcessingConvertor {
	public static void ImageAnalysisProcessingConvertToJson(String filename, boolean writeInFile, boolean formated) {
		//List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImgProcProfileDao ippd = new ImgProcProfileDao(null);
		//List<ImgProcProfile> ipps = ippd.all();
		
		try{
			ImgProcProfileDaoMongo procProfDaoMongo = new ImgProcProfileDaoMongo();
			//imgprocprofileid maximum des profils analyse deja presents dans la base mongodb
			//Rq : les docs ne sont p-e pas inseres dans l'ordre dans mongodb,
			//par consequent, l'imgprocprofileid max ne correspond pas forcement au dernier doc insere
			int idMax = procProfDaoMongo.getImgprocprofileidMax();
			System.out.println("IdMax ImageAnalysisProcessing dans mongodb " + idMax);
			
			String query = " select * from imgprocprofiles where imgprocprofileid > " + idMax + " order by imgprocprofileid;";
			ResultSet rs = ippd.resultSet(query);
						
			while(rs.next()){
				
				ImgProcProfile ipp = ippd.get(rs);
			LinkedHashMap<String, Object> imageAnalysProcessing = new LinkedHashMap<String, Object>();
			Map<String, Object> configuration = new LinkedHashMap<String, Object>();
			configuration.put("provider", "phenowaredb");
			configuration.put("imgprocprofileid", ipp.getImgProcProfileId());
			configuration.put("imgprocprofilename", ipp.getImgProcProfileName());
			imageAnalysProcessing.put("configuration",configuration);
			
			imageAnalysProcessing.put("validatedProcess", ipp.isValidated());
			imageAnalysProcessing.put("deletedProcess", ipp.isDeleted());
			imageAnalysProcessing.put("description", ipp.getDescription());
			imageAnalysProcessing.put("processingScript", ipp.getImgProcScript());
			//jsons.add(imageAnalysProcessing);
			
			if (writeInFile){
				FileWriter file = new FileWriter(filename);
				String jsonString = new org.json.JSONObject(imageAnalysProcessing)
				.toString();
				if (formated)
					file.write(Utils.prettyJsonFormat(jsonString) + "\n");
				else
					file.write(jsonString + "\n");
				file.flush();
				file.close();
			}
			
			//Insertion du document JSON dans Mongodb
			procProfDaoMongo.getCollection().insertOne(new Document (imageAnalysProcessing));
		}
		
		//return jsons;
			System.out.println("Finish");
		
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		// return jsons;
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ippd.getConnect().close();
				System.out.println("Fermeture connexion ImgProcProfileDAO.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void ExportToFile(String filename) {
//		List<LinkedHashMap<String, Object>> jsons3 = ImageAnalysisProcessingConvertToJson();
//		JsonReadWrite jrw3 = new JsonReadWrite();
//		jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		//ExportToFile("Data/ImageAnalysisProcessing.json");
		ImageAnalysisProcessingConvertToJson("Data/ImageAnalysisProcessing.json", true, true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
