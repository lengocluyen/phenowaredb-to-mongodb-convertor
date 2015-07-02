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

import org.data.connection.ImgAcqStationProfileDao;
import org.data.form.ImgAcqStationProfile;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImgAcqStationProfileConvertor {
	public static void ImgAcqStationProfileConvertToJson(String filename,
			boolean formated) {
		// List<LinkedHashMap<String, Object>> jsons = new
		// ArrayList<LinkedHashMap<String, Object>>();
		ImgAcqStationProfileDao iaspd = new ImgAcqStationProfileDao(null);
		try {
			ResultSet rs = iaspd.resultSet();
			FileWriter file = new FileWriter(filename);
			while (rs.next()) {
				ImgAcqStationProfile iasp = iaspd.get(rs);
				LinkedHashMap<String, Object> stationProfile = new LinkedHashMap<String, Object>();
				LinkedHashMap<String, Object> configuration = new LinkedHashMap<String, Object>();
				configuration.put("provider", "phenowaredb");
				configuration.put("stationid", iasp.getStationid());
				configuration.put("imgacqstationprofileid",
						iasp.getImgacqstationprofileid());
				configuration.put("imgacqstationprofilename",
						iasp.getImgacqstationprofilename());
				configuration.put("validatedProfile", iasp.isValidated());
				configuration.put("deletedProfile", iasp.isDeleted());
				stationProfile.put("configuration", configuration);
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
		//List<LinkedHashMap<String, Object>> jsons3 = ImgAcqStationProfileConvertToJson();
		//JsonReadWrite jrw3 = new JsonReadWrite();
		//jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ImgAcqStationProfileConvertToJson("Data/ImgStationProfile.json",true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
