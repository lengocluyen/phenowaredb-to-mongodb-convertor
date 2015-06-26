package org.data.jsonconvertor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.PlantDao;
import org.data.connection.StudyDao;
import org.data.connection.WateringresultDao;
import org.data.form.Plant;
import org.data.form.Study;
import org.data.form.Wateringresult;
import org.data.handle.JsonReadWrite;

public class WateringConvertor {
	
	public static List<LinkedHashMap<String,Object>> WateringResultConvertToJson(){
		List<LinkedHashMap<String,Object>> jsons = new ArrayList<LinkedHashMap<String,Object>>();
		WateringresultDao ward = new WateringresultDao(null);
		
		List<Wateringresult> war = ward.all();
		
		for (Wateringresult ws : war) {
			System.out.println("wateringid : "+ws.getWateringId());
				LinkedHashMap<String, Object> watering = new LinkedHashMap<String, Object>();
				
				PlantDao pld = new PlantDao(ward.getConnect());
				StudyDao std = new StudyDao(ward.getConnect());
				Study st = std.singleFromName(ws.getStudyName());
				Plant pl = pld.single(st.getStudyid(),ws.getPlantId());
				
				watering.put("plant","");
				watering.put("plantAlias",pl.getPlantCode());
				watering.put("genotype","");
				watering.put("genotypeAlias","");
				watering.put("experiment","");
				watering.put("experimentAlias","");
				watering.put("study","");
				watering.put("studyAlias","");
				watering.put("platform","http://www.phenome-fppn.fr/m3p/");
				watering.put("technicalPlateau","http://www.phenome-fppn.fr/m3p/phenoarch");
				watering.put("timestamp", ws.getResultDate().getTime());
				watering.put("date", ws.getResultDate());

				Map<String, Object> config = new LinkedHashMap<String, Object>();
				config.put("provider","phenowaredb");
				config.put("wateringid", ws.getWateringId());
				config.put("plantid", ws.getPlantId());
				config.put("studyname",ws.getStudyName());
				config.put("taskid", ws.getTaskId());
				config.put("calibration", ws.getCalibration());
				config.put("usedstationid", ws.getUsedStationId());
				config.put("usedscaleid", ws.getUsedScaleId());
				config.put("usedpumpid", ws.getUsedPumpId());
				Map<String, Object> nextLoc = new LinkedHashMap<String, Object>();
				nextLoc.put("lane", ws.getLane());
				nextLoc.put("rank", ws.getRank());
				nextLoc.put("level", ws.getLevel());
				org.json.JSONObject childjson = new org.json.JSONObject(nextLoc);
				config.put("nextLocation", childjson);
				childjson = new org.json.JSONObject(config) ;
				watering.put("configuration",childjson);
								
				
				//dans wateringresult
				watering.put("automatonSuccess", ws.isSuccess());
				watering.put("userValidation", ws.isValid());

				Map<String, Object> setpoints = new LinkedHashMap<String, Object>();
				setpoints.put("product", ws.getRequiredProduct());
				setpoints.put("scaleType", ws.getRequiredScaleType());
				setpoints.put("pumpType", ws.getRequiredPumpType());
				setpoints.put("targetWeight", ws.getRequiredTargetWeight());
				setpoints.put("targetQuantity", ws.getRequiredTargetQuantity());
				setpoints.put("pumpSpeed", ws.getRequiredPumpSpeed());
				setpoints.put("maxQuantity", ws.getRequiredMaxQuantity());
				setpoints.put("minWeight", ws.getRequiredMinWeight());
				setpoints.put("movePerch", ws.isRequiredMovePerch());
				childjson = new org.json.JSONObject(setpoints) ;
				watering.put("setpoints",childjson);
				
				watering.put("product", ws.getUsedProduct());
				watering.put("scaleType", ws.getUsedScaleType());
				watering.put("pumpType", ws.getUsedPumpType());
				watering.put("pumpSpeed", ws.getUsedPumpSpeed());
				
				Map<String, Object> measures = new LinkedHashMap<String, Object>();
				
				Map<String, Object> meas = new LinkedHashMap<String, Object>();
				meas.put("value", ws.getWeightBefore());
				meas.put("unity",  "");
				meas.put("type", "automatic");
				meas.put("confidence", "unspecified");
				childjson = new org.json.JSONObject(meas) ;
				measures.put("weightBefore",childjson );
				meas = new LinkedHashMap<String, Object>();
				meas.put("value", ws.getWeightAfter());
				meas.put("unity",  "");
				meas.put("type", "automatic");
				meas.put("confidence", "unspecified");
				childjson = new org.json.JSONObject(meas) ;
				measures.put("weightAfter",childjson );
				meas = new LinkedHashMap<String, Object>();
				meas.put("value", ws.getWeightAfter()-ws.getWeightBefore());
				meas.put("unity",  "");
				meas.put("type", "computed");
				meas.put("confidence", "unspecified");
				childjson = new org.json.JSONObject(meas) ;
				measures.put("weightAmount",childjson );
				
				childjson = new org.json.JSONObject(measures) ;
				watering.put("measures",childjson);
				

				jsons.add(watering);
	
			}
		
		return jsons;
	}
	
	
	public static void ExportToFile(String filename){
		List<LinkedHashMap<String,Object>> jsons = WateringResultConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons, filename,true);
	}
	

	public static void main(String[] args) {
		ExportToFile("Data/Watering1.json");

	}
}
