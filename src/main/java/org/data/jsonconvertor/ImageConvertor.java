package org.data.jsonconvertor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.ImageDao;
import org.data.connection.PlantDao;
import org.data.form.Image;
import org.data.form.Plant;
import org.data.handle.JsonReadWrite;

public class ImageConvertor {

	public static List<LinkedHashMap<String, Object>> ImagesConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImageDao id = new ImageDao(null);
		List<Image> imgs = id.all();

		for (Image img : imgs) {
			LinkedHashMap<String, Object> image = new LinkedHashMap<String, Object>();
			PlantDao pld = new PlantDao(id.getConnect());
			Plant pl = pld.single(img.getStudyid(),img.getPlantid());
			
			image.put("plant",
					"http://www.phenome-fppn.fr/m3p/arch/2013/c13006199");
			image.put("plantAlias",
					pl.getPlantCode());
			image.put("genotype", "");
			image.put("genotypeAlias",  "");
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
			configuration.put("subfolder", img.getSubfolder());

			Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
			nextLocation.put("lane", img.getLane());
			nextLocation.put("rank", img.getRank());
			nextLocation.put("level", img.getLevel());

			configuration.put("nextLocation", nextLocation);

			image.put("configuration", configuration);
			image.put("userValidation", img.isValid());
			image.put("isReferenceImage", img.isRefimage());
			image.put("viewType", img.getViewType().getViewtypelabel());
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
			    	
			jsons.add(image);
		}
		return jsons;
	}

	public static void ExportToFile(String filename) {
		List<LinkedHashMap<String, Object>> jsons3 = ImagesConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		ExportToFile("Data/Image.json");
	}
}
