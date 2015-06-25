package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.DirectoryPath;
import org.data.form.ImageViewType;
import org.data.handle.Utils;

public class DirectoryPathDao extends DAO<DirectoryPath>{

	public DirectoryPathDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(DirectoryPath obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DirectoryPath obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DirectoryPath obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DirectoryPath single(int id) {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from directorypaths where  pathid = "
					+ id;
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
	public List<DirectoryPath> all() {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from directorypaths";
			ResultSet rs = statement.executeQuery(query);
			List<DirectoryPath> data = new ArrayList<DirectoryPath>();
			while (rs.next()) {
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
	public DirectoryPath get(ResultSet rs) {
		DirectoryPath dp = new DirectoryPath();
		try{
			dp.setPathid(Utils.convertToInt(rs.getObject("pathid")));
			dp.setDirpath(Utils.convertToString(rs.getObject("dirpath")));
			dp.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			return dp;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
