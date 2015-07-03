package org.data.jsonconvertor;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.PlantObservationDao;
import org.data.connection.WeighingresultDao;
import org.data.form.PlantObservation;
import org.data.form.Weighingresult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class PlantObservationConvertor {
	public static List<LinkedHashMap<String, Object>> PlantObservationResultConvertToJson() {
		List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		PlantObservationDao pod = new PlantObservationDao(null);
		List<PlantObservation> pos = pod.all(false);

		for (PlantObservation po : pos) {
			LinkedHashMap<String, Object> plantObservation = new LinkedHashMap<String, Object>();
			// dans platforme
			plantObservation.put("platform", "http://www.phenome-fppn.fr/m3p/");
			plantObservation.put("technicalPlateau",
					"http://www.phenome-fppn.fr/m3p/phenoarch");
			plantObservation.put("experiment", "");
			plantObservation.put("experimentAlias", "");
			plantObservation.put("genotype", "");
			plantObservation.put("genotypeAlias", "");
			plantObservation.put("study", "");
			plantObservation.put("studyAlias", "");
			plantObservation.put("plant","");
			plantObservation.put("plantAlias",po.getPlant()==null?"":po.getPlant().getPlantCode());
			plantObservation.put("date", po.getDate());
			plantObservation.put("timestamp", po.getTimestamps());
			Map<String, Object> configurations = new LinkedHashMap<String, Object>();
			configurations.put("provider", "phenowaredb");
			configurations.put("observationid",po.getObservationid());
			configurations.put("studyname", po.getStudyname());
			configurations.put("taskid", po.getTaskid());
			configurations.put("plantid", po.getPlantid());
			configurations.put("userlogin", po.getUserlogin());

			Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
			nextLocation.put("lane", po.getLane());
			nextLocation.put("rank", po.getRank());
			nextLocation.put("level", po.getLevel());

			configurations.put("nextLocation", nextLocation);

			plantObservation.put("configurations", configurations);
			plantObservation.put("userValidation", po.isValid());

			Map<String, Object> setpoints = new LinkedHashMap<String, Object>();
			setpoints.put("stationid", po.getSetpointsStationid()==-1?"":po.getSetpointsStationid());

			plantObservation.put("setpoints", setpoints);
			
			
			Map<String, Object> observation = new LinkedHashMap<String, Object>();
		
			observation.put("code", po.getObservationcode());
			observation.put("detail", po.getObservation());
			
			
			plantObservation.put("observation", observation);

			jsons.add(plantObservation);
		}
		return jsons;
	}
	public static int ComputedWeight(int before, int after){
		return Math.abs(after-before);
	}
	public static void ExportToFile(String filename){
		List<LinkedHashMap<String,Object>> jsons3 = PlantObservationResultConvertToJson();
		JsonReadWrite jrw3 = new JsonReadWrite();
		jrw3.WriteToFile(jsons3, filename,true);
	}
	public static void main(String[] args) {
		Date start = new Date();
		ExportToFile("Data/PlantObservation.json");
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
