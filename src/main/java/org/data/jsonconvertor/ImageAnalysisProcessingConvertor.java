package org.data.jsonconvertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.ImageDao;
import org.data.connection.ImgProcProfileDao;
import org.data.connection.ImgProcResultDao;
import org.data.form.Image;
import org.data.form.ImgProcProfile;
import org.data.form.ImgProcResult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class ImageAnalysisProcessingConvertor {
	public static List<LinkedHashMap<String, Object>> ImageAnalysisProcessingConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImgProcProfileDao ippd = new ImgProcProfileDao(null);
		List<ImgProcProfile> ipps = ippd.all();

		for (ImgProcProfile ipp : ipps) {
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
			jsons.add(imageAnalysProcessing);
		}
		return jsons;
	}

	public static void ExportToFile(String filename) {
		List<LinkedHashMap<String, Object>> jsons3 = ImageAnalysisProcessingConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ExportToFile("Data/ImageAnalysisProcessing.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
