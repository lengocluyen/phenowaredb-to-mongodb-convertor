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

import org.data.connection.ImgAcqCameraProfileDao;
import org.data.form.ImgAcqCameraProfile;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImgAcqCameraProfileConvertor {

	public static void ImgAcqCameraProfileConvertToJson(String filename,
			boolean formated) {
		ImgAcqCameraProfileDao iacpd = new ImgAcqCameraProfileDao(null);
		try {
			ResultSet rs = iacpd.resultSet();
			FileWriter file = new FileWriter(filename);
			while (rs.next()) {
				ImgAcqCameraProfile iacp = iacpd.get(rs);
				LinkedHashMap<String, Object> cameraProfile = new LinkedHashMap<String, Object>();
				LinkedHashMap<String, Object> configuration = new LinkedHashMap<String, Object>();
				configuration.put("provider", "phenowaredb");
				configuration.put("stationid", iacp.getStationid());
				configuration.put("imgacqcameraprofileid",
						iacp.getImgacqcameraprofileid());
				configuration.put("imgacqcameraprofilename",
						iacp.getImgacqcameraprofilename());
				configuration.put("validatedProfile", iacp.isValidated());
				configuration.put("deletedProfile", iacp.isDeleted());
				configuration
						.put("intefaceacqtype", iacp.getInterfaceacqtype());
				cameraProfile.put("configuration", configuration);
				cameraProfile.put("description", iacp.getDescription());

				Map<String, Object> settings = new LinkedHashMap<String, Object>();
				settings.put("viewcount", iacp.getViewcount());
				settings.put("viewType", iacp.getImageViewType()
						.getViewtypelabel());
				settings.put("width", iacp.getWidth());
				settings.put("height", iacp.getHeight());
				settings.put("triggermode", iacp.getTriggermode());
				settings.put("shutter", iacp.getShutter());
				settings.put("gain", iacp.getGain());
				settings.put("brightness", iacp.getBrightness());
				settings.put("hue", iacp.getHue());
				settings.put("gamma", iacp.getGamma());
				settings.put("saturation", iacp.getSaturation());
				settings.put("sharpness", iacp.getSharpness());
				settings.put("whitebalance", iacp.getWhitebalance());
				settings.put("pixeformat", iacp.getPixelformat());
				cameraProfile.put("settings", settings);
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

			}

			System.out.println("Finish");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ExportToFile(String filename) {
		// List<LinkedHashMap<String, Object>> jsons3 =
		// ImgAcqCameraProfileConvertToJson();
		// JsonReadWrite jrw3 = new JsonReadWrite();
		// jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ImgAcqCameraProfileConvertToJson("Data/ImgCameraProfile.json", true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}

}
