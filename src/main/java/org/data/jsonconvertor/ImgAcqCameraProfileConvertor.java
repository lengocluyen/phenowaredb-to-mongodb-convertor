package org.data.jsonconvertor;

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

	public static List<LinkedHashMap<String, Object>> ImgAcqCameraProfileConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImgAcqCameraProfileDao iacpd = new ImgAcqCameraProfileDao(null);
		List<ImgAcqCameraProfile> iacps = iacpd.all();

		for (ImgAcqCameraProfile iacp : iacps) {
			LinkedHashMap<String, Object> cameraProfile = new LinkedHashMap<String, Object>();
			cameraProfile.put("imgacqcameraprofileid", iacp.getImgacqcameraprofileid());
			cameraProfile.put("imgacqcameraprofilename", iacp.getImgacqcameraprofilename());
			cameraProfile.put("validated", iacp.isValidated());
			cameraProfile.put("deleted", iacp.isDeleted());
			Map<String, Object> profileType = new LinkedHashMap<String, Object>();
			profileType.put("id", iacp.getProfileTypeObject().getProfiletypeid());
			profileType.put("name", iacp.getProfileTypeObject().getProfiletypename());
			cameraProfile.put("profiletype", profileType);
			cameraProfile.put("description", iacp.getDescription());
			cameraProfile.put("imageryusertype", iacp.getImageryusertype());
			cameraProfile.put("intefaceacqtype", iacp.getInterfaceacqtype());

			Map<String, Object> viewType = new LinkedHashMap<String, Object>();
			viewType.put("id", iacp.getImageViewType().getViewtypeid());
			viewType.put("label", iacp.getImageViewType().getViewtypelabel());
			cameraProfile.put("viewType", viewType);

			cameraProfile.put("stationid", iacp.getStationid());
			cameraProfile.put("width", iacp.getWidth());
			cameraProfile.put("height", iacp.getHeight());
			cameraProfile.put("triggermode", iacp.getTriggermode());
			cameraProfile.put("shutter", iacp.getShutter());
			cameraProfile.put("gain", iacp.getGain());
			cameraProfile.put("brightness", iacp.getBrightness());
			cameraProfile.put("hue", iacp.getHue());
			cameraProfile.put("gamma", iacp.getGamma());
			cameraProfile.put("saturation", iacp.getSaturation());
			cameraProfile.put("sharpness", iacp.getSharpness());
			cameraProfile.put("whitebalance", iacp.getWhitebalance());
			cameraProfile.put("viewcount",iacp.getViewcount());
			cameraProfile.put("pixeformat", iacp.getPixelformat());
			jsons.add(cameraProfile);
		}
		return jsons;
	}

	public static void ExportToFile(String filename) {
		List<LinkedHashMap<String, Object>> jsons3 = ImgAcqCameraProfileConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ExportToFile("Data/ImgCameraProfile.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}

}
