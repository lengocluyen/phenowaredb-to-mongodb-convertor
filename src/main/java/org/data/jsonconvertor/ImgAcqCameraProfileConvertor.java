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
import org.data.connection.CameraProfileDaoMongo;
import org.data.connection.ImgAcqCameraProfileDao;
import org.data.form.ImgAcqCameraProfile;
import org.data.handle.JsonReadWrite;
import org.data.handle.TechnicalPlateau;
import org.data.handle.Utils;

public class ImgAcqCameraProfileConvertor {
	private static String prefixe = "m3p:";

	public static void ImgAcqCameraProfileConvertToJson(String filename,
			boolean writeInFile, boolean formated) {
	
		ImgAcqCameraProfileDao iacpd = new ImgAcqCameraProfileDao(null);
	
		
		try {
			CameraProfileDaoMongo camProfDaoMongo = new CameraProfileDaoMongo();
			
			//imgacqcameraprofileid maximum des profils camera deja presents dans la base mongodb
			//Rq : les docs ne sont p-e pas inseres dans l'ordre dans mongodb,
			//par consequent, l'imgacqcameraprofileid max ne correspond pas forcement au dernier doc insere
			int idMax = camProfDaoMongo.getImgacqcameraprofileidMax();
			
			//num incremental de l'uri du dernier document profil camera insere dans la base mongodb
			int numIncrUriCamProf = camProfDaoMongo.getCameraProfileUriNumIncrLastInserted();
			
			String query = " select * from imgacqcameraprofiles where imgacqcameraprofileid > " + idMax + " order by imgacqcameraprofileid;";
			ResultSet rs = iacpd.resultSet(query);
						
			while (rs.next()) {
				numIncrUriCamProf ++;
				ImgAcqCameraProfile iacp = iacpd.get(rs);
				LinkedHashMap<String, Object> cameraProfile = new LinkedHashMap<String, Object>();
				cameraProfile.put("uri", ImgAcqCameraProfileConvertor.createUriCameraProfile(
						iacp.getTechnicalPlateau(), numIncrUriCamProf));
				LinkedHashMap<String, Object> configuration = new LinkedHashMap<String, Object>();
				configuration.put("provider", "phenowaredb");
				configuration.put("stationid", iacp.getStationid());
				configuration.put("imgacqcameraprofileid",
						iacp.getImgacqcameraprofileid());
				configuration.put("imgacqcameraprofilename",
						iacp.getImgacqcameraprofilename());
				configuration
						.put("interfaceacqtype", iacp.getInterfaceacqtype());
				cameraProfile.put("configuration", configuration);
				cameraProfile.put("validatedProfile", iacp.isValidated());
				cameraProfile.put("deletedProfile", iacp.isDeleted());
				cameraProfile.put("description", iacp.getDescription());

				Map<String, Object> settings = new LinkedHashMap<String, Object>();
				settings.put("viewCount", iacp.getViewcount());
				settings.put("viewType", iacp.getImageViewType()
						.getViewtypelabel());
				settings.put("width", iacp.getWidth());
				settings.put("height", iacp.getHeight());
				settings.put("triggerMode", iacp.getTriggermode());
				settings.put("shutter", iacp.getShutter());
				settings.put("gain", iacp.getGain());
				settings.put("brightness", iacp.getBrightness());
				settings.put("hue", iacp.getHue());
				settings.put("gamma", iacp.getGamma());
				settings.put("saturation", iacp.getSaturation());
				settings.put("sharpness", iacp.getSharpness());
				settings.put("whiteBalance", iacp.getWhitebalance());
				settings.put("pixelFormat", iacp.getPixelformat());
				cameraProfile.put("settings", settings);
				
				if (writeInFile){
					FileWriter file = new FileWriter(filename);
					String jsonString = new org.json.JSONObject(cameraProfile)
					.toString();
					// file.write("Document json "+i+"\n");

					if (formated)
						file.write(Utils.prettyJsonFormat(jsonString) + "\n");
					else
						file.write(jsonString + "\n");
					// System.out.println("Writing the document " + i+": " +
					// jsonString);

					file.flush();
					file.close();
				}

				//Insertion du document JSON dans Mongodb
				camProfDaoMongo.getCollection().insertOne(new Document(cameraProfile));
			}

			System.out.println("Finish");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				iacpd.getConnect().close();
				System.out.println("Fermeture connexion ImgAcqCameraProfileDAO.");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static String createUriCameraProfile(TechnicalPlateau tp, int numIncr) {
		String uri ;
		Calendar c = new GregorianCalendar();
		int annee = c.get(Calendar.YEAR);  //l'annee ou on insere ce nveau profil (ie : l'annee en cours)
		switch (tp) {
        case Phenoarch:  uri = prefixe + "arch/" + annee + "/pcc" + (annee-2000) + String.format("%03d", numIncr) ;
                 break;
        case Phenopsis:  uri = prefixe + "psis/" +annee + "/pcb" + (annee-2000) + String.format("%03d", numIncr) ;
                 break;
        case Phenodyn:  uri = prefixe + "dyn/" +annee + "/pca" + (annee-2000) + String.format("%03d", numIncr) ;
                 break;
        default: uri = "";
                 break;
		}
		
		return uri;
	}

	public static void ExportToFile(String filename) {
		// List<LinkedHashMap<String, Object>> jsons3 =
		// ImgAcqCameraProfileConvertToJson();
		// JsonReadWrite jrw3 = new JsonReadWrite();
		// jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ImgAcqCameraProfileConvertToJson("Data/ImgCameraProfile.json", true, true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
		
		
	}

}
