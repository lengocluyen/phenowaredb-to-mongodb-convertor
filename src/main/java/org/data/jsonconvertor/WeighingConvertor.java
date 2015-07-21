package org.data.jsonconvertor;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.data.connection.PlantDao;
import org.data.connection.StudyDao;
import org.data.connection.WeighingresultDao;
import org.data.connection.WeighingresultDaoMongo;
import org.data.form.Plant;
import org.data.form.Study;
import org.data.form.Weighingresult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;

public class WeighingConvertor {
	public static void WeighingResultConvertToJson(String filename, boolean formated) {
		//List<LinkedHashMap<String, Object>> jsons = new ArrayList<LinkedHashMap<String, Object>>();
		WeighingresultDao wrsd = new WeighingresultDao(null);
		//List<Weighingresult> wrs = wrsd.all(false);
		
		try{
			WeighingresultDaoMongo weighDaoMongo = new WeighingresultDaoMongo();
			//id maximum des pesees deja presentes dans la base mongodb
			//Rq : les docs ne sont p-e pas inseres dans l'ordre dans mongodb,
			//par consequent, l'id max ne correspond pas forcement au dernier doc insere
			int idMax = weighDaoMongo.getWeighingidMax();
			
			String query = " select * from weighingresults where weighingid > " + idMax + "limit 10;";
			ResultSet rs = wrsd.resultSet(query);
			FileWriter file = new FileWriter(filename);
			
		while(rs.next()) {
			Weighingresult ws = wrsd.get(rs);
			LinkedHashMap<String, Object> weighing = new LinkedHashMap<String, Object>();
			
			weighing.put("platform", "http://www.phenome-fppn.fr/m3p/");
			weighing.put("technicalPlateau",
					"http://www.phenome-fppn.fr/m3p/phenoarch");
			weighing.put("experiment", "http://www.phenome-fppn.fr/m3p/" + ws.getStudyname() );
			weighing.put("experimentAlias", "");
			weighing.put("study", "");
			weighing.put("studyAlias", "");
			weighing.put("genotype", "");
			weighing.put("genotypeAlias", "");
			weighing.put("plant","");
			weighing.put("plantAlias", ws.getPlant()==null?"":ws.getPlant().getPlantCode());

			
			weighing.put("date", ws.getDate());
			weighing.put("timestamp", ws.getTimestamps());
			
			Map<String, Object> configuration = new LinkedHashMap<String, Object>();
			configuration.put("provider", "phenowaredb");
			configuration.put("weighingid", ws.getWeighingid());
			configuration.put("studyname", ws.getStudyname());
			configuration.put("taskid", ws.getTaskid());
			configuration.put("plantid", ws.getPlantid());
			configuration.put("usedstationid", ws.getUsedstationid());
			configuration.put("usedscaleid", ws.getUsedscaleid());

			Map<String, Object> nextLocation = new LinkedHashMap<String, Object>();
			nextLocation.put("lane", ws.getLane());
			nextLocation.put("rank", ws.getRank());
			nextLocation.put("level", ws.getLevel());

			configuration.put("nextLocation", nextLocation);

			weighing.put("configuration", configuration);
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

			//jsons.add(weighing);
			String jsonString = new org.json.JSONObject(weighing)
			.toString();
			// file.write("Document json "+i+"\n");

			if (formated)
				file.write(Utils.prettyJsonFormat(jsonString) + "\n");
			else
				file.write(jsonString + "\n");
			// System.out.println("Writing the document " + i+": " +
			// jsonString);

			file.flush();
		}
		System.out.println("Finish");
		file.close();
	} catch (IOException ie) {
		ie.printStackTrace();
	}
		//return jsons;
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int ComputedWeight(int before, int after){
		return Math.abs(after-before);
	}
	public static void ExportToFile(String filename){
//		List<LinkedHashMap<String,Object>> jsons3 = WeighingResultConvertToJson();
//		JsonReadWrite jrw3 = new JsonReadWrite();
//		jrw3.WriteToFile(jsons3, filename,true);
	}
	public static void main(String[] args) {
		Date start = new Date();
		WeighingResultConvertToJson("Data/Weighing2.json", true);
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));
	}
}
