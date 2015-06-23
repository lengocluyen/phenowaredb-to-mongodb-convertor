package org.data.jsonconvertor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.handle.Utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Convertor {
	public static List<LinkedHashMap<String, Object>> WeighingResultConvertToJson(ResultSet rs){
		List<LinkedHashMap<String,Object>> jsons = new ArrayList<LinkedHashMap<String,Object>>();
		//JSONObject jsonObject = new JSONObject();
		LinkedHashMap<String,Object> jsonOrderedMap = new LinkedHashMap<String,Object>();
		try {
			while(rs.next()){
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
}
