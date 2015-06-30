package org.data.jsonconvertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.WeighingresultDao;
import org.data.form.Weighingresult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class WeighingConvertor {
	public static List<LinkedHashMap<String, Object>> WeighingResultConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		WeighingresultDao wrsd = new WeighingresultDao(null);
		List<Weighingresult> wrs = wrsd.all(false);
		for (Weighingresult ws : wrs) {
			LinkedHashMap<String, Object> weighing = new LinkedHashMap<String, Object>();
			// dans platforme
			weighing.put("platform", "http://www.phenome-fppn.fr/m3p/");
			weighing.put("technicalPlateau",
					"http://www.phenome-fppn.fr/m3p/phenoarch");
			weighing.put("experiment", "");
			weighing.put("experimentAlias", "");
			weighing.put("study", "");
			weighing.put("studyAlias", "");
			weighing.put("genotype", "");
			weighing.put("genotypeAlias", "");
			weighing.put("plant","");
			weighing.put("plantAlias", ws.getPlant()==null?"":ws.getPlant().getPlantCode());
			
			weighing.put("date", ws.getDate());
			weighing.put("timestamp", ws.getTimestamps());
			
			Map<String, Object> configurations = new LinkedHashMap<String, Object>();
			configurations.put("provider", "phenowaredb");
			configurations.put("weighingid", ws.getWeighingid());
			configurations.put("studyname", ws.getStudyname());
			configurations.put("taskid", ws.getTaskid());
			configurations.put("plantid", ws.getPlantid());
			configurations.put("usedstationid", ws.getUsedstationid());
			configurations.put("usedscaleid", ws.getUsedscaleid());

			Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
			nextLocation.put("lane", ws.getLane());
			nextLocation.put("rank", ws.getRank());
			nextLocation.put("level", ws.getLevel());

			configurations.put("nextLocation", nextLocation);

			weighing.put("configurations", configurations);
			weighing.put("automatonSuccess", ws.isSuccess());
			weighing.put("userValidation", ws.isValid());

			Map<String, Object> setpoints = new LinkedHashMap<String, Object>();
			setpoints.put("scaleType", ws.getSetpointscaletype()==-1?"":ws.getSetpointscaletype());

			weighing.put("setpoints", setpoints);
			weighing.put("scaleType", ws.getUsedscaletypename());
			weighing.put("weighingType", ws.getWeighingtype());
			
			Map<String, Object> measures = new LinkedHashMap<String, Object>();
			Map<String, Object> weightBefore = new LinkedHashMap<String, Object>();
			Map<String, Object> weightAfter = new LinkedHashMap<String, Object>();
			Map<String, Object> weight = new LinkedHashMap<String, Object>();

			measures.put("weightBefore", weightBefore);
			weightBefore.put("value", ws.getWeighbefore());
			weightBefore.put("unity", "");
			weightBefore.put("type", "automatic");
			weightBefore.put("confidence", "unspecified");

			measures.put("weightAfter", weightAfter);
			weightAfter.put("value", ws.getWeighafter());
			weightAfter.put("unity", "");
			weightAfter.put("type", "automatic");
			weightAfter.put("confidence", "unspecified");

			measures.put("weight", weight);
			weight.put("value", ComputedWeight(ws.getWeighafter(), ws.getWeighbefore()));
			weight.put("unity", "");
			weight.put("type", "computed");
			weight.put("confidence", "unspecified");

			weighing.put("measures", measures);

			jsons.add(weighing);
		}
		
		return jsons;
	}
	public static int ComputedWeight(int before, int after){
		return Math.abs(after-before);
	}
	public static void ExportToFile(String filename){
		List<LinkedHashMap<String,Object>> jsons3 = WeighingResultConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons3, filename,true);
	}
	public static void main(String[] args) {
		Date start = new Date();
		ExportToFile("Data/Weigting.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
