package org.data.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.data.form.StudyStatus;
import org.data.form.UserInfo;
import org.data.handle.Utils;

public class StudyStatusDao extends DAO<StudyStatus> {

	public StudyStatusDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(StudyStatus obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(StudyStatus obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(StudyStatus obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StudyStatus single(int id) {
		// TODO Auto-generated method stub
		try {
			Connection connection = this.connect;
			Statement statement = connection.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from studystatus where labelid = " + id;
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
	public List<StudyStatus> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet resultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudyStatus get(ResultSet rs) {
		StudyStatus sts = new StudyStatus();
		try {
			sts.setLabelid(Utils.convertToInt(rs.getObject("labelid")));
			sts.setLabel(Utils.convertToString(rs.getObject("label")));
			return sts;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
