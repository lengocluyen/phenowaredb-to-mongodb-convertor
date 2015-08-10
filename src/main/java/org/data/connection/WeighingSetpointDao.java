package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Study;
import org.data.form.WeighingSetpoint;
import org.data.form.Weighingresult;
import org.data.handle.Utils;

public class WeighingSetpointDao extends DAO<WeighingSetpoint>{

	public WeighingSetpointDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(WeighingSetpoint obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(WeighingSetpoint obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(WeighingSetpoint obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WeighingSetpoint single(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public WeighingSetpoint single(int taskid, int plantid, String studyname) {
		// TODO Auto-generated method stub
		try {
			StudyDao sd = new StudyDao(this.getConnect());
			Study s = sd.single(studyname);
			List<WeighingSetpoint> ses = this.all();
			for(WeighingSetpoint ws: ses){
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
	public List<WeighingSetpoint> all() {
		List<WeighingSetpoint> wrs = new ArrayList<WeighingSetpoint>();
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from weighingsetpoints limit 10");

			while (result.next()) {
				WeighingSetpoint temps = this.get(result);
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
	public WeighingSetpoint get(ResultSet rs) {
		WeighingSetpoint ws = new WeighingSetpoint();
		try{
			ws.setTaskid(Utils.convertToInt(rs.getObject("taskid")));
			ws.setPlantid(Utils.convertToInt(rs.getObject("plantid")));
			ws.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			ws.setScaletypeid(Utils.convertToInt(rs.getObject("Scaletypeid")));
			
			StudyDao sd = new StudyDao(this.getConnect());
			Study s = sd.single(ws.getStudyid());
			ws.setStudy(s);
			return ws;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultSet resultSet(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
