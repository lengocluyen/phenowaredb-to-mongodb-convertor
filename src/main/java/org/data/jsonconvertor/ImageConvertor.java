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

import org.data.connection.ImageDao;
import org.data.connection.PlantDao;
import org.data.form.Image;
import org.data.form.Plant;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImageConvertor {

	public static void ImagesConvertToJson(String filename, boolean formated) {
		//List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImageDao id = new ImageDao(null);
		//List<Image> imgs = id.all(false);
		
		try {
			ResultSet rs = id.resultSet();
		
			FileWriter file = new FileWriter(filename);while(rs.next()){
			Image img = id.get(rs);
			LinkedHashMap<String, Object> image = new LinkedHashMap<String, Object>();
			PlantDao pld = new PlantDao(id.getConnect());
			Plant pl = pld.single(img.getStudyid(),img.getPlantid());
			
			image.put("plant", "");
			if(pl!=null)
				image.put("plantAlias", pl.getPlantCode());
			else
				image.put("plantAlias", "");
			image.put("genotype", "");
			image.put("genotypeAlias",  "");
			if(img.getStudy() != null)
				image.put("experiment", "http://www.phenome-fppn.fr/m3p/" + img.getStudy().getName());
			else
				image.put("experiment", "");
			image.put("experimentAlias", "");
			image.put("study", "");
			image.put("studyAlias", "");
			image.put("platform", "http://www.phenome-fppn.fr/m3p/");
			image.put("technicalPlateau",
					"http://www.phenome-fppn.fr/m3p/phenoarch");
			image.put("timestamp", img.getTimestamps());
			image.put("date", img.getAcquisitiondate());
			
			Map<String, Object> configuration = new LinkedHashMap<String, Object>();
			configuration.put("provider", "phenowaredb");
			configuration.put("imgid", img.getImgid());
			configuration.put("plantid", img.getPlantid());
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
			
			image.put("serverPath", "http://stck-lespe.supagro.inra.fr/");	
			image.put("imageServerPath", "");
			image.put("imageWebPath","");
			image.put("thumbServerPath", ""); 
			image.put("thumbWebPath", ""); 
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

		}

		System.out.println("Finish");
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

	public static void ExportToFile(String filename) {
		//List<LinkedHashMap<String, Object>> jsons3 = ImagesConvertToJson();
		//JsonReadWrite jrw3 = new JsonReadWrite();
		//jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		//ExportToFile("Data/Image.json");
		ImagesConvertToJson("Data/ImageTest.json", true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
