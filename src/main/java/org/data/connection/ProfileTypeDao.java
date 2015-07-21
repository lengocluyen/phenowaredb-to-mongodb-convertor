package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ProfileType;
import org.data.handle.Utils;

public class ProfileTypeDao extends DAO<ProfileType>{

	public ProfileTypeDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ProfileType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ProfileType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ProfileType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProfileType single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from profiletypes where profiletypeid = " + id;
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
	public List<ProfileType> all() {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from profiletypes";
			ResultSet rs = statement.executeQuery(query);
			List<ProfileType> data = new ArrayList<ProfileType>();
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
	public ProfileType get(ResultSet rs) {
		ProfileType pt = new ProfileType();
		try{
			pt.setProfiletypeid(Utils.convertToInt(rs.getObject("profiletypeid")));
			pt.setProfiletypename(Utils.convertToString(rs.getObject("profiletypename")));
			return pt;
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
