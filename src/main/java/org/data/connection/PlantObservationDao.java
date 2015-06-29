package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.PlantObservation;
import org.data.form.PlantObservationCode;
import org.data.form.Task;
import org.data.handle.Utils;

public class PlantObservationDao extends DAO<PlantObservation>{

	public PlantObservationDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(PlantObservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PlantObservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlantObservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlantObservation single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plantobservations where observationid = " + id;
			ResultSet rs = statement.executeQuery(query);
			if (rs.first()) {
				return this.get(rs);
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<PlantObservation> all() {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plantobservations limit 10";
			ResultSet rs = statement.executeQuery(query);
			List<PlantObservation> data = new ArrayList<PlantObservation>();
			while(rs.next()) {
				data.add(this.get(rs));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<PlantObservation> all(boolean test) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query;
			if(test)
			query = "Select * from plantobservations limit 10";
			else
				query = "Select * from plantobservations";
				
			ResultSet rs = statement.executeQuery(query);
			List<PlantObservation> data = new ArrayList<PlantObservation>();
			while(rs.next()) {
				data.add(this.get(rs));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public ResultSet resultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlantObservation get(ResultSet rs) {
		PlantObservation po = new PlantObservation();
		try{
			po.setObservationid(Utils.convertToInt(rs.getObject("observationid")));
			po.setStudyname(Utils.convertToString(rs.getObject("studyname")));
			po.setTaskid(Utils.convertToInt(rs.getObject("taskid")));
			po.setTagname(Utils.convertToString(rs.getObject("tagname")));
			po.setPlantid(Utils.convertToInt(rs.getObject("plantid")));
			po.setUserlogin(Utils.convertToString(rs.getObject("userlogin")));
			po.setResultdate(Utils.convertToString(rs.getObject("resultdate")));
			po.setDate(Utils.convertToString(rs.getObject("resultdate")));
			po.setTimestamps(rs.getTimestamp("resultdate").getTime());
			po.setValid(Utils.convertToBool(rs.getObject("valid")));
			po.setObservationcode(Utils.convertToString(rs.getObject("observationcode")));
			po.setObservation(Utils.convertToString(rs.getObject("observation")));
			po.setLane(Utils.convertToInt(rs.getObject("lane")));
			po.setRank(Utils.convertToInt(rs.getObject("rank")));
			po.setLevel(Utils.convertToInt(rs.getObject("level")));
			
			TaskDao td  = new TaskDao(null);
			Task t = td.single(po.getTaskid());
			if(t!=null)
				po.setTaks(t);

			System.out.println("transacting... with observationid " + po.getObservationid());
			return po;
		}
		catch(SQLException e)
		{	
			e.printStackTrace();
			return null;
		}
	}

}
