package org.data.jsonconvertor;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.handle.Utils;

public class WateringConvertor {
	
	
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
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
