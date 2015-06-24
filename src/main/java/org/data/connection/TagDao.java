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
import org.data.handle.Utils;

public class TagDao extends DAO<Tag>{

	public TagDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Tag obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Tag obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Tag obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tag single(int id) {
		try {
			Statement statement = this.connect.createStatement();
			ResultSet result = statement
					.executeQuery("Select * from tags where tagid = "
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
	public List<Tag> all() {
		List<Tag> wrs = new ArrayList<Tag>();
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from tags");

			while (result.next()) {
				Tag temps = this.get(result);
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
	public Tag get(ResultSet rs) {
		try{
			Tag tag = new Tag();
			tag.setTagid(Utils.convertToInt(rs.getObject("tagid")));
			tag.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			tag.setTaskid(Utils.convertToInt(rs.getObject("taskid")));
			tag.setTagname(Utils.convertToString(rs.getObject("tagname")));
			StudyDao st = new StudyDao(null);
			tag.setStudy(st.single(tag.getStudyid()));
			TaskDao td = new TaskDao(null);
			Task t= td.single(tag.getTaskid());
			if(t!=null)
				tag.setTask(t);
			return tag;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
