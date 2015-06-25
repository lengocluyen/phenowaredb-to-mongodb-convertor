package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.SQLException;
=======
>>>>>>> origin/BRA-maud3
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImgProcProfile;
import org.data.handle.Utils;

<<<<<<< HEAD
public class ImgProcProfileDao extends DAO<ImgProcProfile> {
=======
public class ImgProcProfileDao extends DAO<ImgProcProfile>{
>>>>>>> origin/BRA-maud3

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
<<<<<<< HEAD
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
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> origin/BRA-maud3
	}

	@Override
	public List<ImgProcProfile> all() {
		List<ImgProcProfile> ipp = new ArrayList<ImgProcProfile>();
		try {
<<<<<<< HEAD
			Statement statement = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from imgprocprofiles limit 10");

			while (result.next()) {
				
				ipp.add(this.get(result));
			}
		} catch (Exception ex) {
=======
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
>>>>>>> origin/BRA-maud3
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
<<<<<<< HEAD
		} catch (Exception ex) {
=======
		} catch(Exception ex) {
>>>>>>> origin/BRA-maud3
			return null;
		}
		return result;
	}

<<<<<<< HEAD
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
=======
>>>>>>> origin/BRA-maud3
}
