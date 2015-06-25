package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Study;
import org.data.form.TaskType;
import org.data.handle.Utils;

public class TaskTypeDao extends DAO<TaskType>{

	public TaskTypeDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(TaskType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TaskType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TaskType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TaskType single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from tasktypes where tasktypeid = " + id;
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
	public List<TaskType> all() {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from tasktypes";
			ResultSet rs = statement.executeQuery(query);
			List<TaskType> tts = new ArrayList<TaskType>();
			while(rs.next()) {
				tts.add(this.get(rs));
			}
			return tts;
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
	public TaskType get(ResultSet rs) {
		TaskType tt = new TaskType();
		try{
			tt.setTasktypeid(Utils.convertToInt(rs.getObject("tasktypeid")));
			tt.setType(Utils.convertToString(rs.getObject("type")));
			tt.setRandprofilereq(Utils.convertToBool("randprofilereq"));
			tt.setWaterprofilereq(Utils.convertToBool("waterprofilereq"));
			tt.setWeighprofilereq(Utils.convertToBool("weighprofilereq"));
			tt.setObservprofilereq(Utils.convertToBool("observprofilereq"));
			tt.setImgacqprofilereq(Utils.convertToBool("imgacqprofilereq"));
			tt.setImgprocprofilereq(Utils.convertToBool("imgprocprofilereq"));
			tt.setSprayprofilereq(Utils.convertToBool("sprayprofilereq"));
			tt.setPruneprofilereq(Utils.convertToBool("pruneprofilereq"));
			tt.setCleanprofilereq(Utils.convertToBool("cleanprofilereq"));
			tt.setFillprofilereq(Utils.convertToBool("fillprofilereq"));
			tt.setPackingprofilereq(Utils.convertToBool("packingprofilereq"));
			tt.setPlctaskcode(Utils.convertToLong(rs.getObject("plctaskcode")));
			tt.setPlctasktypeletter(Utils.convertToString(rs.getObject("plctasktypeletter")));
			tt.setDisplayorder(Utils.convertToInt(rs.getObject("displayorder")));
			tt.setIssmallloop(Utils.convertToBool(rs.getObject("issmallloop")));
			tt.setIsimgprocreplay(Utils.convertToBool(rs.getObject("isimgprocreplay")));
			return tt;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
