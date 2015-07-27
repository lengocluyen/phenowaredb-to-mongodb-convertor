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

import org.bson.Document;
import org.data.connection.PlantDao;
import org.data.connection.PlantDaoSesame;
import org.data.connection.StudyDao;
import org.data.connection.WateringresultDao;
import org.data.connection.WateringresultDaoMongo;
import org.data.form.Image;
import org.data.form.Plant;
import org.data.form.Study;
import org.data.form.Wateringresult;
import org.data.handle.JsonReadWrite;
import org.data.handle.Utils;
import org.openrdf.query.MalformedQueryException;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.repository.RepositoryException;

public class WateringConvertor {

	public static void WateringResultConvertToJson(String filename,
			boolean formated) throws RepositoryException, MalformedQueryException, QueryEvaluationException {
		// List<LinkedHashMap<String,Object>> jsons = new
		// ArrayList<LinkedHashMap<String,Object>>();
		WateringresultDao ward = new WateringresultDao(null);

		// List<Wateringresult> war = ward.all();
		PlantDao pld = new PlantDao(ward.getConnect());
		StudyDao std = new StudyDao(ward.getConnect());
		try {
			WateringresultDaoMongo watDaoMongo = new WateringresultDaoMongo();
			//id maximum des waterings deja presents dans la base mongodb
			//Rq : les docs ne sont p-e pas inseres dans l'ordre dans mongodb,
			//par consequent, l'id max ne correspond pas forcement au dernier doc insere
			int idMax = watDaoMongo.getWateringidMax();
			System.out.println("IdMax Watering dans mongodb " + idMax);
			String query = " select * from wateringresults where wateringid > " + idMax + " order by wateringid;";
			ResultSet rs = ward.resultSet(query);
			FileWriter file = new FileWriter(filename);
			
			PlantDaoSesame pds = new PlantDaoSesame();

			while (rs.next()) {
				Wateringresult ws = ward.get(rs);
				System.out.println("wateringid : " + ws.getWateringId());
				LinkedHashMap<String, Object> watering = new LinkedHashMap<String, Object>();

				Study st;
				Plant pl = new Plant();
				st = std.singleFromName(ws.getStudyName());
				if (st != null)
					pl = pld.single(st.getStudyid(), ws.getPlantId());
				
				Map<String, Object> context = new LinkedHashMap<String, Object>();

				if(pl!=null){
					context.put("plant", pds.getURIFromAlias(pl.getPlantCode()));
				}
				else{
					System.out.println("Erreur  : pas de plante pr le wateringid "+ ws.getWateringId());
					context.put("plant", "");
				}

				context.put("plantAlias", pl == null ? "" : pl.getPlantCode());
				context.put("genotype", "");
				context.put("genotypeAlias", "");
				context.put("experiment", "http://www.phenome-fppn.fr/m3p/"+ws.getStudyName());
				context.put("experimentAlias", ws.getStudyName());
				context.put("study", "");
				context.put("studyAlias", "");
				context.put("platform", "http://www.phenome-fppn.fr/m3p/");
				context.put("technicalPlateau",
						"http://www.phenome-fppn.fr/m3p/phenoarch");
				watering.put("context",  context);

				watering.put("timestamp", ws.getTimestamp());
				watering.put("date", ws.getDate());

				Map<String, Object> config = new LinkedHashMap<String, Object>();
				config.put("provider", "phenowaredb");
				config.put("wateringid", ws.getWateringId());
				config.put("plantid", ws.getPlantId());
				config.put("studyname", ws.getStudyName());
				config.put("taskid", ws.getTaskId());
				config.put("calibration", ws.getCalibration());
				config.put("usedstationid", ws.getUsedStationId());
				config.put("usedscaleid", ws.getUsedScaleId());
				config.put("usedpumpid", ws.getUsedPumpId());
				Map<String, Object> nextLoc = new LinkedHashMap<String, Object>();
				nextLoc.put("lane", ws.getLane());
				nextLoc.put("rank", ws.getRank());
				nextLoc.put("level", ws.getLevel());
				config.put("nextLocation", nextLoc);
				watering.put("configuration", config);

				// dans wateringresult
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
				watering.put("setpoints", setpoints);

				watering.put("product", ws.getUsedProduct());
				watering.put("scaleType", ws.getUsedScaleType());
				watering.put("pumpType", ws.getUsedPumpType());
				watering.put("pumpSpeed", ws.getUsedPumpSpeed());

				Map<String, Object> measures = new LinkedHashMap<String, Object>();

				Map<String, Object> meas = new LinkedHashMap<String, Object>();
				meas.put("value", ws.getWeightBefore());
				meas.put("unity", "");
				meas.put("type", "automatic");
				meas.put("confidence", "unspecified");
				measures.put("weightBefore", meas);
				meas = new LinkedHashMap<String, Object>();
				meas.put("value", ws.getWeightAfter());
				meas.put("unity", "");
				meas.put("type", "automatic");
				meas.put("confidence", "unspecified");
				measures.put("weightAfter", meas);
				meas = new LinkedHashMap<String, Object>();
				meas.put("value", ws.getWeightAfter() - ws.getWeightBefore());
				meas.put("unity", "");
				meas.put("type", "computed");
				meas.put("confidence", "unspecified");
				measures.put("weightAmount", meas);

				watering.put("measures", measures);

				// jsons.add(image);

				String jsonString = new org.json.JSONObject(watering).toString();
				// file.write("Document json "+i+"\n");

				if (formated)
					file.write(Utils.prettyJsonFormat(jsonString) + "\n");
				else
					file.write(jsonString + "\n");
				// System.out.println("Writing the document " + i+": " +
				// jsonString);

				file.flush();
				
				//Insertion du document JSON dans Mongodb
				watDaoMongo.getCollection().insertOne(new Document(watering));

			}

			System.out.println("Finish");
			pds.getConnection().close();
			file.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		// return jsons;
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ExportToFile(String filename) {
		//List<LinkedHashMap<String, Object>> jsons = WateringResultConvertToJson();
		//JsonReadWrite jrw3 = new JsonReadWrite();
		//jrw3.WriteToFile(jsons, filename, true);
	}

	public static void main(String[] args) {

		Date start = new Date();
		try {
			WateringResultConvertToJson("Data/Watering2.json", true);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueryEvaluationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date end = new Date();
		System.out.println(Utils.timePerformance(start, end));


	}
}
