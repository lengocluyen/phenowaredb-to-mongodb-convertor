package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImgProcProfile;
import org.data.handle.Utils;

public class ImgProcProfileDao extends DAO<ImgProcProfile>{

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImgProcProfile> all() {
		List<ImgProcProfile> ipp = new ArrayList<ImgProcProfile>();
		try {
			Statement statement = this.connect.createStatement();
			ResultSet result = statement
					.executeQuery("Select * from imgprocprofiles limit 10");
			
			while (result.next()) {
				ImgProcProfile temps = new ImgProcProfile();
				temps.setImgProcProfileId(Utils.convertToInt(result.getInt("imgprocprofileid")));
				temps.setImgProcProfileName (Utils.convertToString(result.getString("imgprocprofilename")));
				temps.setValidated ( Utils.convertToBool(result.getBoolean("validated")));
				temps.setDeleted(Utils.convertToBool(result.getBoolean("deleted")));
				
				temps.setProfileType( Utils.convertToInt(result.getInt("profiletype")));
				temps.setDescription( Utils.convertToString(result.getString("description")));
				temps.setImgProcScript( Utils.convertToString(result.getString("imgprocscript")));
			
				ipp.add(temps);
			}
		} catch(Exception ex) {
			return null;
		}
		return ipp;
	}

	@Override
	public ResultSet resultSet() {
		Statement statement;
		ResultSet result;
		try {
			statement = this.connect.createStatement();
			result = statement
					.executeQuery("Select * from imgprocprofiles limit 10");
		} catch(Exception ex) {
			return null;
		}
		return result;
	}

	@Override
	public ImgProcProfile get(ResultSet result) {
		// TODO Auto-generated method stub
		return null;
	}

}
