package org.data.jsonconvertor;

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
	public static List<LinkedHashMap<String, Object>> ImgAcqStationProfileConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		ImgAcqStationProfileDao iaspd = new ImgAcqStationProfileDao(null);
		List<ImgAcqStationProfile> iasps = iaspd.all();

		for (ImgAcqStationProfile iasp : iasps) {
			LinkedHashMap<String, Object> stationProfile = new LinkedHashMap<String, Object>();
			stationProfile.put("imgacqstationprofileid", iasp.getImgacqstationprofileid());
			stationProfile.put("imgacqstationprofilename", iasp.getImgacqstationprofilename());
			stationProfile.put("validated", iasp.isValidated());
			stationProfile.put("deleted", iasp.isDeleted());
			Map<String, Object> profileType = new LinkedHashMap<String, Object>();
			profileType.put("id", iasp.getProfileTypeObject()==null?"":iasp.getProfileTypeObject().getProfiletypeid());
			profileType.put("name", iasp.getProfileTypeObject()==null?"":iasp.getProfileTypeObject().getProfiletypename());
			stationProfile.put("profiletype", profileType);
			stationProfile.put("description", iasp.getDescription());
			stationProfile.put("imageryusertype", iasp.getImageryusertype());

			stationProfile.put("stationid", iasp.getStationid());
			stationProfile.put("indexer", iasp.getIndexer());
			stationProfile.put("toplight", iasp.getToplight());
			stationProfile.put("sidelight", iasp.getSidelight());
			stationProfile.put("zoom", iasp.getZoom());
			stationProfile.put("focus", iasp.getFocus());
			stationProfile.put("aperture", iasp.getAperture());
			stationProfile.put("rotationspeed", iasp.getRotationspeed());
			stationProfile.put("topviewcount", iasp.getTopviewcount());
			stationProfile.put("sideviewcount", iasp.getSideviewcount());
			jsons.add(stationProfile);
		}
		return jsons;
	}

	public static void ExportToFile(String filename) {
		List<LinkedHashMap<String, Object>> jsons3 = ImgAcqStationProfileConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons3, filename, true);
	}

	public static void main(String[] args) {
		Date start = new Date();
		ExportToFile("Data/ImgStationProfile.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
