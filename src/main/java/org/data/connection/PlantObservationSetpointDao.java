package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Study;
import org.data.form.WeighingSetpoint;
import org.data.form.PlantObservationSetpoint;
import org.data.handle.Utils;

public class PlantObservationSetpointDao extends DAO<PlantObservationSetpoint>{

	public PlantObservationSetpointDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(PlantObservationSetpoint obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PlantObservationSetpoint obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlantObservationSetpoint obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlantObservationSetpoint single(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public PlantObservationSetpoint single(int taskid, int plantid, String studyname) {
		// TODO Auto-generated method stub
		try {
			StudyDao sd = new StudyDao(null);
			Study s = sd.single(studyname);
			List<PlantObservationSetpoint> ses = this.all();
			for(PlantObservationSetpoint ws: ses){
				if(ws.getTaskid()==taskid&&ws.getPlantid()==plantid&&ws.getStudy().getName()==studyname)
					return ws;
			}
/*			Statement statement = this.connect.createStatement();
			ResultSet result = statement
					.executeQuery("Select * from weighingsetpoints where taskid = " + taskid + " and plantid = " + plantid + " and studyid = " + s.getStudyid()
							);

			if (result.first()) {
				return this.get(result);
			}
			*/
			return null;
		} catch (Exception ex) {
			return null;
		}
	}
	@Override
	public List<PlantObservationSetpoint> all() {
		List<PlantObservationSetpoint> wrs = new ArrayList<PlantObservationSetpoint>();
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from plantobservationsetpoints");

			while (result.next()) {
				PlantObservationSetpoint temps = this.get(result);
				wrs.add(temps);
			}
		} catch (Exception ex) {
			return null;
		}
		return wrs;
	}

	@Override
	public ResultSet resultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlantObservationSetpoint get(ResultSet rs) {
		PlantObservationSetpoint ws = new PlantObservationSetpoint();
		try{
			ws.setTaskid(Utils.convertToInt(rs.getObject("taskid")));
			ws.setPlantid(Utils.convertToInt(rs.getObject("plantid")));
			ws.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			ws.setStationidd(Utils.convertToInt(rs.getObject("stationid")));
			
			StudyDao sd = new StudyDao(null);
			Study s = sd.single(ws.getStudyid());
			ws.setStudy(s);
			return ws;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
}
