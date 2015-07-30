package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImgProcProfile;
import org.data.handle.Utils;

public class ImgProcProfileDao extends DAO<ImgProcProfile> {

	public ImgProcProfileDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ImgProcProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ImgProcProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ImgProcProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImgProcProfile single(int id) {

		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgprocprofiles where  imgprocprofileid = "
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

	public ImgProcProfile single(String profileName) {

		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgprocprofiles where  imgprocprofilename = '"
					+ profileName + "'";
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
	public List<ImgProcProfile> all() {
		List<ImgProcProfile> ipp = new ArrayList<ImgProcProfile>();
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from imgprocprofiles limit 10");

			while (result.next()) {

				ipp.add(this.get(result));
			}
		} catch (Exception ex) {
			return null;
		}
		return ipp;
	}

	@Override
	public ResultSet resultSet() throws SQLException {
		Statement statement;
		ResultSet result;

		statement = this.connect.createStatement();
		result = statement
				.executeQuery("Select * from imgprocprofiles");

		return result;
	}

	@Override
	public ResultSet resultSet(String query) throws SQLException {
		Statement statement;
		ResultSet result;

		statement = this.connect.createStatement();
		result = statement
				.executeQuery(query);

		return result;
	}
	
	@Override
	public ImgProcProfile get(ResultSet result) {

		ImgProcProfile temps = new ImgProcProfile();
		try {
			temps.setImgProcProfileId(Utils.convertToInt(result
					.getInt("imgprocprofileid")));
			temps.setImgProcProfileName(Utils.convertToString(result
					.getString("imgprocprofilename")));
			temps.setValidated(Utils.convertToBool(result
					.getBoolean("validated")));
			temps.setDeleted(Utils.convertToBool(result.getBoolean("deleted")));

			temps.setProfileType(Utils.convertToInt(result
					.getInt("profiletype")));
			temps.setDescription(Utils.convertToString(result
					.getString("description")));
			temps.setImgProcScript(Utils.convertToString(result
					.getString("imgprocscript")));
			return temps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}



}
