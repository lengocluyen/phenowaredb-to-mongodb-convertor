package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Plant;
import org.data.form.PlantObservationCode;
import org.data.form.Study;
import org.data.handle.Utils;

public class PlantDao extends DAO<Plant> {

	public PlantDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Plant obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Plant obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Plant obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Plant single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plants where  plantrowid = " + id;
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
	
	public Plant single(int studyid, int plantid) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plants where  studyid = " + studyid + " and plantid = " + plantid;
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
	public List<Plant> all() {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from plants";
			ResultSet rs = statement.executeQuery(query);
			List<Plant> data = new ArrayList<Plant>();
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
	public ResultSet resultSet(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Plant get(ResultSet rs) {
		Plant p = new Plant();
		try{
			p.setPlantrowid(Utils.convertToInt(rs.getObject("plantrowid")));
			p.setPlantid(Utils.convertToInt(rs.getObject("plantid")));
			p.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			p.setPlantCode(Utils.convertToString(rs.getObject("plantcode")));
			p.setEmptyWeight(Utils.convertToInt(rs.getObject("emptyweight")));
			p.setInitialWeight(Utils.convertToInt(rs.getObject("initialweight")));
			p.setExternalStorage(Utils.convertToBool(rs.getObject("externalstorage")));
			p.setCustomstr1(Utils.convertToString(rs.getObject("customstr1")));
			p.setCustomstr2(Utils.convertToString(rs.getObject("customstr2")));
			p.setCustomstr3(Utils.convertToString(rs.getObject("customstr3")));
			p.setCustomstr4(Utils.convertToString(rs.getObject("customstr4")));
			p.setCustomstr5(Utils.convertToString(rs.getObject("customstr5")));
			p.setCustomint1(Utils.convertToInt(rs.getObject("customint1")));
			p.setCustomint2(Utils.convertToInt(rs.getObject("customint2")));
			p.setCustomint3(Utils.convertToInt(rs.getObject("customint3")));
			p.setCustomint4(Utils.convertToInt(rs.getObject("customint4")));
			p.setCustomint5(Utils.convertToInt(rs.getObject("customint5")));
			StudyDao sd = new StudyDao(this.getConnect());
			Study s = sd.single(p.getStudyid());
			if(s!=null)
				p.setStudyObject(s);
			return p;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	

}
