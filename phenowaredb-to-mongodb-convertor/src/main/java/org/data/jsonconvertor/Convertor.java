package org.data.jsonconvertor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.handle.Utils;
import org.json.simple.JSONObject;

public class Convertor {
	public static List<LinkedHashMap<String,Object>> WeighingResultConvertToJson(ResultSet rs){
		List<LinkedHashMap<String,Object>> jsons = new ArrayList<LinkedHashMap<String,Object>>();
		//JSONObject jsonObject = new JSONObject();
		try {
			while(rs.next()){
				LinkedHashMap<String, Object> jsonOrderedMap = new LinkedHashMap<String, Object>();
				//dans platforme
				jsonOrderedMap.put("plateform","http://www.phenome-fppn.fr/m3p/");
				jsonOrderedMap.put("technicalPlateau","http://www.phenome-fppn.fr/m3p/phenoarch");
				jsonOrderedMap.put("experiment","http://www.phenome-fppn.fr/m3p/ARCH2013-09-12");
				jsonOrderedMap.put("experimentAlias","ZD13");
				jsonOrderedMap.put("specie","maize");
				jsonOrderedMap.put("study","");
				jsonOrderedMap.put("studyAlias","");
				jsonOrderedMap.put("plant","http://www.phenome-fppn.fr/m3p/arch/2013/c13006199");
				jsonOrderedMap.put("plantAlias","1605/22H3/ZM3597/MYB/WW/1/2745/ARCH2013-09-12");
				
				Map<String, Object> childObject = new LinkedHashMap<String, Object>();
				childObject.put("separator", "/");
				childObject.put("itemsNumber", "8");
				childObject.put("item1", "car_number");
				childObject.put("item2", "genotype");
				childObject.put("item3", "seedlot");
				childObject.put("item4", "project");
				childObject.put("item5", "scenario");
				childObject.put("item6", "repetition");
				childObject.put("item7", "balance");
				childObject.put("item8", "experiment");
				org.json.JSONObject childjson = new org.json.JSONObject(childObject) ;
				//JSONArray jsonArray = new JSONArray(childjson);
				jsonOrderedMap.put("plantPatternAlias",childjson);
				
				//dans weighingresult
				jsonOrderedMap.put("weighingid", Utils.convertToString(rs.getInt("weighingid")));
				jsonOrderedMap.put("studyname", Utils.convertToString(rs.getString("studyname")));
				jsonOrderedMap.put("taskid", Utils.convertToString(rs.getInt("taskid")));
				jsonOrderedMap.put("tagname", Utils.convertToString(rs.getString("tagname")));
				jsonOrderedMap.put("plantid", Utils.convertToString(rs.getInt("plantid")));
				jsonOrderedMap.put("resultdate", rs.getTimestamp("resultdate").toString());
				jsonOrderedMap.put("valid", Utils.convertToString(rs.getBoolean("valid")));
				jsonOrderedMap.put("weighingtype", Utils.convertToString(rs.getString("weighingtype")));
				jsonOrderedMap.put("reqscaletypename", Utils.convertToString(rs.getString("reqscaletypename")));
				jsonOrderedMap.put("usedstationid", Utils.convertToString(rs.getInt("usedstationid")));
				jsonOrderedMap.put("usedscaleid", Utils.convertToString(rs.getInt("usedscaleid")));
				jsonOrderedMap.put("usedscaletypename", Utils.convertToString(rs.getString("usedscaletypename")));
				jsonOrderedMap.put("weightbefore", Utils.convertToString(rs.getInt("weightbefore")));
				jsonOrderedMap.put("weightafter", Utils.convertToString(rs.getInt("weightafter")));
				jsonOrderedMap.put("success", Utils.convertToString(rs.getBoolean("success")));
				jsonOrderedMap.put("lane", Utils.convertToString(rs.getInt("lane")));
				jsonOrderedMap.put("rank", Utils.convertToString(rs.getInt("rank")));
				jsonOrderedMap.put("level", Utils.convertToString(rs.getInt("level")));
				//jsonObject = new JSONObject(data).toString(); 
				jsons.add(jsonOrderedMap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsons;
	}
	
	
	public static List<LinkedHashMap<String,Object>> WateringResultConvertToJson(ResultSet rs){
		List<LinkedHashMap<String,Object>> jsons = new ArrayList<LinkedHashMap<String,Object>>();
		//JSONObject jsonObject = new JSONObject();
		
		try {
			while(rs.next()){
				LinkedHashMap<String, Object> jsonOrderedMap = new LinkedHashMap<String, Object>();
				//dans platforme
				jsonOrderedMap.put("plant","");
				jsonOrderedMap.put("plantAlias","");
				jsonOrderedMap.put("genotype","");
				jsonOrderedMap.put("genotypeAlias","");
				jsonOrderedMap.put("experiment","");
				jsonOrderedMap.put("experimentAlias","");
				jsonOrderedMap.put("study","");
				jsonOrderedMap.put("studyAlias","");
				jsonOrderedMap.put("platform","http://www.phenome-fppn.fr/m3p/");
				jsonOrderedMap.put("technicalPlateau","http://www.phenome-fppn.fr/m3p/phenoarch");
				jsonOrderedMap.put("timestamp", rs.getTimestamp("resultdate").getTime());
				jsonOrderedMap.put("date", rs.getTimestamp("resultdate").toString());

				Map<String, Object> childConfig = new LinkedHashMap<String, Object>();
				childConfig.put("provider","phenowaredb");
				childConfig.put("wateringid", Utils.convertToString(rs.getInt("wateringid")));
				childConfig.put("plantid", Utils.convertToString(rs.getInt("plantid")));
				childConfig.put("studyname", Utils.convertToString(rs.getString("studyname")));
				childConfig.put("taskid", Utils.convertToString(rs.getInt("taskid")));
				childConfig.put("calibration", Utils.convertToString(rs.getInt("calibration")));
				childConfig.put("stationid", Utils.convertToString(rs.getInt("usedstationid")));
				childConfig.put("usedscaleid", Utils.convertToString(rs.getInt("usedscaleid")));
				childConfig.put("usedpumpid", Utils.convertToString(rs.getInt("usedpumpid")));
				Map<String, Object> childNextLoc = new LinkedHashMap<String, Object>();
				childNextLoc.put("lane", Utils.convertToString(rs.getInt("lane")));
				childNextLoc.put("rank", Utils.convertToString(rs.getInt("rank")));
				childNextLoc.put("level", Utils.convertToString(rs.getInt("level")));
				org.json.JSONObject childjson = new org.json.JSONObject(childNextLoc) ;
				childConfig.put("nextLocation", childjson);
				childjson = new org.json.JSONObject(childConfig) ;
				jsonOrderedMap.put("configuration",childjson);
								
				
				//dans wateringresult
				jsonOrderedMap.put("automatonSuccess", Utils.convertToString(rs.getBoolean("success")));
				jsonOrderedMap.put("userValidation", Utils.convertToString(rs.getBoolean("valid")));

				Map<String, Object> childRequired = new LinkedHashMap<String, Object>();
				childRequired.put("product", Utils.convertToString(rs.getString("reqproductname")));
				childRequired.put("scaleType", Utils.convertToString(rs.getString("reqscaletypename")));
				childRequired.put("pumpType", Utils.convertToString(rs.getString("reqpumptypename")));
				childRequired.put("targetWeight", Utils.convertToString(rs.getInt("reqtargetweight")));
				childRequired.put("targetQuantity", Utils.convertToString(rs.getInt("reqtargetquantity")));
				childRequired.put("pumpSpeed", Utils.convertToString(rs.getInt("reqpumpspeed")));
				childRequired.put("maxQuantity", Utils.convertToString(rs.getInt("reqmaxquantity")));
				childRequired.put("minWeight", Utils.convertToString(rs.getInt("reqminweight")));
				childRequired.put("movePerch", Utils.convertToString(rs.getBoolean("reqmoveperch")));
				childjson = new org.json.JSONObject(childRequired) ;
				jsonOrderedMap.put("setpoints",childjson);
				
				jsonOrderedMap.put("product", Utils.convertToString(rs.getString("usedproductname")));
				jsonOrderedMap.put("scaleType", Utils.convertToString(rs.getString("usedscaletypename")));
				jsonOrderedMap.put("pumpType", Utils.convertToString(rs.getString("usedpumptypename")));
				jsonOrderedMap.put("pumpSpeed", Utils.convertToString(rs.getInt("pumpspeed")));
				
				Map<String, Object> childMeasures = new LinkedHashMap<String, Object>();
				
				Map<String, Object> childM = new LinkedHashMap<String, Object>();
				childM.put("value", Utils.convertToString(rs.getInt("weightbefore")));
				childM.put("unity",  "");
				childM.put("type", "automatic");
				childM.put("confidence", "unspecified");
				childjson = new org.json.JSONObject(childM) ;
				childMeasures.put("weightBefore",childjson );
				childM = new LinkedHashMap<String, Object>();
				childM.put("value", Utils.convertToString(rs.getInt("weightafter")));
				childM.put("unity",  "");
				childM.put("type", "automatic");
				childM.put("confidence", "unspecified");
				childjson = new org.json.JSONObject(childM) ;
				childMeasures.put("weightAfter",childjson );
				childM = new LinkedHashMap<String, Object>();
				childM.put("value", Utils.convertToString(rs.getInt("weightafter")-rs.getInt("weightbefore")));
				childM.put("unity",  "");
				childM.put("type", "computed");
				childM.put("confidence", "unspecified");
				childjson = new org.json.JSONObject(childM) ;
				childMeasures.put("weightAmount",childjson );
				
				childjson = new org.json.JSONObject(childMeasures) ;
				jsonOrderedMap.put("measures",childjson);
				
				
				jsons.add(jsonOrderedMap);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsons;
	}
	
	public static List<LinkedHashMap<String,Object>> ImgProcProfileConvertToJson(ResultSet rs){
		List<LinkedHashMap<String,Object>> jsons = new ArrayList<LinkedHashMap<String,Object>>();
		//JSONObject jsonObject = new JSONObject();
		
		try {
			while(rs.next()){
				LinkedHashMap<String, Object> jsonOrderedMap = new LinkedHashMap<String, Object>();
				
				//dans imgprocprofiles
				jsonOrderedMap.put("imgProcProfileId", Utils.convertToString(rs.getInt("imgprocprofileid")));
				jsonOrderedMap.put("imgProcProfileName", Utils.convertToString(rs.getString("imgprocprofilename")));
				jsonOrderedMap.put("validated", Utils.convertToString(rs.getBoolean("validated")));
				jsonOrderedMap.put("deleted", Utils.convertToString(rs.getBoolean("deleted")));
				jsonOrderedMap.put("profileType", Utils.convertToString(rs.getInt("profiletype")));  //TODO : modif : String profileType (table profileTypes)
				jsonOrderedMap.put("description", Utils.convertToString(rs.getString("description")));
				jsonOrderedMap.put("imgProcScript", Utils.convertToString(rs.getString("imgprocscript")));
			
				jsons.add(jsonOrderedMap);
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsons;
	}
}
