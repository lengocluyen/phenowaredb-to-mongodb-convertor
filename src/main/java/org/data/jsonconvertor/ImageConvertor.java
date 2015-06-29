package org.data.jsonconvertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.ImageDao;
import org.data.form.Image;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImageConvertor {

	public static List<LinkedHashMap<String, Object>> ImagesConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImageDao id = new ImageDao(null);
		List<Image> imgs = id.all(true);

		for (Image img : imgs) {
			LinkedHashMap<String, Object> image = new LinkedHashMap<String, Object>();
			image.put("platform", "http://www.phenome-fppn.fr/m3p/");
			image.put("technicalPlateau",
					"http://www.phenome-fppn.fr/m3p/phenoarch");
			image.put("experiment", "");
			image.put("experimentAlias", "");
			image.put("study", "");
			image.put("studyAlias", "");
			image.put("plant",
					"http://www.phenome-fppn.fr/m3p/arch/2013/c13006199");
			image.put("plantAlias",
					"1605/22H3/ZM3597/MYB/WW/1/2745/ARCH2013-09-12");

			image.put("date", img.getAcquisitiondate());
			image.put("timestamp", img.getTimestamps());

			Map<String, Object> configurations = new LinkedHashMap<String, Object>();
			configurations.put("provider", "phenowaredb");
			configurations.put("imageid", img.getImgid());
			configurations.put("plantid", img.getPlantid());
			configurations.put("taskid", img.getTaskid());
			configurations.put("stationid", img.getStationid());
			configurations.put("imgangle", img.getImgangle());
			configurations.put("subfolder", img.getSubfolder());

			Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
			nextLocation.put("lane", img.getLane());
			nextLocation.put("rank", img.getRank());
			nextLocation.put("level", img.getLevel());

			configurations.put("nextLocation", nextLocation);

			image.put("configurations", configurations);
			image.put("userValidation", img.isValid());
			image.put("refimage", img.isRefimage());

			Map<String, Object> viewtypes = new LinkedHashMap<String, Object>();
			viewtypes.put("label", img.getViewType().getViewtypelabel());
			image.put("setpoints", viewtypes);

			Map<String, Object> directorypaths = new LinkedHashMap<String, Object>();
			directorypaths.put("pathid", img.getRootPath().getPathid());
			directorypaths.put("dirpath", img.getRootPath().getDirpath());
			image.put("directorypaths", directorypaths);

			image.put("imgacqprofile", img.getImgacqprofileid());
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
		Date start = new Date();
		ExportToFile("Data/Image.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
