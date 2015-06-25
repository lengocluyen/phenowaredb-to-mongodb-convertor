package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.data.form.UserInfo;
import org.data.handle.Utils;

public class UserInfoDao extends DAO<UserInfo> {

	public UserInfoDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(UserInfo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserInfo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserInfo obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from userinfos where userid = " + id;
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
	public List<UserInfo> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet resultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo get(ResultSet rs) {
		UserInfo ui = new UserInfo();
		try {
			ui.setUserid(Utils.convertToInt(rs.getObject("userid")));
			ui.setFirstName(Utils.convertToString(rs.getObject("firstname")));
			ui.setLastName(Utils.convertToString(rs.getObject("lastname")));
			ui.setPhone1(Utils.convertToString(rs.getObject("phone1")));
			ui.setPhone2(Utils.convertToString(rs.getObject("phone2")));
			ui.setCellPhone1(Utils.convertToString(rs.getObject("cellphone1")));
			ui.setCellPhone2(Utils.convertToString(rs.getObject("cellphone2")));
			ui.setEmail1(Utils.convertToString(rs.getObject("email1")));
			ui.setEmail2(Utils.convertToString(rs.getObject("email2")));
			ui.setDescription(Utils.convertToString(rs.getObject("description")));
			return ui;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
