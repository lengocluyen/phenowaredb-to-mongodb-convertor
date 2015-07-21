package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Study;
import org.data.form.Tag;
import org.data.form.Task;
import org.data.form.TaskType;
import org.data.form.UserInfo;
import org.data.form.Weighingresult;
import org.data.handle.Utils;

public class TaskDao extends DAO<Task>{

	public TaskDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Task obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Task obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Task obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Task single(int id) {
		try {
			Statement statement = this.connect.createStatement();
			ResultSet result = statement
					.executeQuery("Select * from tasks where id = "
							+ id);

			if (result.first()) {
				return this.get(result);
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Task> all() {
		List<Task> wrs = new ArrayList<Task>();
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from tasks limit 10");

			while (result.next()) {
				Task temps = this.get(result);
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
	public ResultSet resultSet(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task get(ResultSet rs) {
		Task t = new Task();
		try{
			t.setId(Utils.convertToInt(rs.getObject("id")));
			t.setScheduledstartdate(Utils.convertToString(rs.getObject("scheduledstartdate")));
			t.setValidity(Utils.convertToString(rs.getObject("validity")));
			t.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			t.setRealstartdate(Utils.convertToString(rs.getObject("realstartdate")));
			t.setRealenddate(Utils.convertToString(rs.getObject("realenddate")));
			t.setOwnerid(Utils.convertToInt(rs.getObject("ownerid")));
			t.setTasktypeid(Utils.convertToInt(rs.getObject("tasktype")));
			t.setStatus(Utils.convertToInt(rs.getObject("status")));
			t.setCreationdate(Utils.convertToString(rs.getObject("creationdate")));
			t.setTagid(Utils.convertToInt(rs.getObject("tagid")));
			t.setDuration(Utils.convertToString(rs.getObject("duration")));
			t.setLanes(Utils.convertToInt(rs.getObject("lanes")));
			t.setStations(Utils.convertToInt(rs.getObject("stations")));
			t.setProfileid(Utils.convertToInt(rs.getObject("profileid")));
			t.setCsvcreationdate(Utils.convertToString(rs.getObject("csvcreationdate")));
			t.setTarget(Utils.convertToString(rs.getObject("target")));
			StudyDao sd = new StudyDao(null);
			Study s = sd.single(t.getStudyid());
			if(s!=null)
				t.setStudy(s);
			UserInfoDao uid = new UserInfoDao(null);
			UserInfo ui = uid.single(t.getOwnerid());
			if(ui!=null)
				t.setUserinfo(ui);
			TagDao td = new TagDao(null);
			Tag tag = td.single(t.getTagid());
			if(tag!=null)
				t.setTag(tag);
			TaskTypeDao ttd = new TaskTypeDao(null);
			TaskType tt = ttd.single(t.getTasktypeid());
			if(tt!=null)
				t.setTaskType(tt);
			return t;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

	

}
