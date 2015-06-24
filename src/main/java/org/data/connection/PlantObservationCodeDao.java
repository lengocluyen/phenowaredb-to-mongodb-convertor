package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.PlantObservationCode;
import org.data.form.ProfileType;
import org.data.form.Study;
import org.data.handle.Utils;

public class PlantObservationCodeDao extends DAO<PlantObservationCode>{

	public PlantObservationCodeDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(PlantObservationCode obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PlantObservationCode obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlantObservationCode obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlantObservationCode single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plantobservationcodes where observationcode like " + id;
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
	public List<PlantObservationCode> all() {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plantobservationcodes";
			ResultSet rs = statement.executeQuery(query);
			List<PlantObservationCode> data = new ArrayList<PlantObservationCode>();
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
	public PlantObservationCode get(ResultSet rs) {
		PlantObservationCode poc = new PlantObservationCode();
		try{
			poc.setObservationcode(Utils.convertToString(rs.getObject("observationcode")));
			poc.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			poc.setValid(Utils.convertToBool(rs.getObject("valid")));
			StudyDao sd = new StudyDao(null);
			Study s = sd.single(poc.getStudyid());
			if(s!=null)
				poc.setStudy(s);
			return poc;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
