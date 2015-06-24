package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Study;
import org.data.form.StudyStatus;
import org.data.handle.Utils;
import org.json.simple.JSONArray;

public class StudyDao extends DAO<Study>{

	public StudyDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Study obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Study obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Study obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Study single(int id) {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from studies where studyid = " + id;
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
	public List<Study> all() {
		try {
			Statement statement = this.connect.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from studies";
			ResultSet rs = statement.executeQuery(query);
			List<Study> studies = new ArrayList<Study>();
			while(rs.next()) {
				studies.add(this.get(rs));
			}
			return studies;
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
	public Study get(ResultSet rs) {
		Study study = new Study();
		try{
		study.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
		study.setName(Utils.convertToString(rs.getObject("name")));
		study.setStartdate(Utils.convertToString(rs.getObject("startdate")));
		study.setEnddate(Utils.convertToString(rs.getObject("enddate")));
		study.setStatus(Utils.convertToInt(rs.getObject("status")));
		study.setOwnerid(Utils.convertToInt(rs.getObject("ownerid")));
		study.setDescription(Utils.convertToString(rs.getObject("description")));
		study.setKeywords(Utils.convertToString(rs.getObject("keywords")));
		study.setImgfolderid(Utils.convertToInt(rs.getObject("imgfolderid")));
		study.setStorebinaryimg(Utils.convertToBool(rs.getObject("storebinaryimg")));
		study.setBinaryimgsubfolder(Utils.convertToString(rs.getObject("binaryimgsubfolder")));
		study.setIntranetimgstorename(Utils.convertToString(rs.getObject("intranetimgstorename")));
		study.setExtranetimgstorename(Utils.convertToString(rs.getObject("extranetimgstorename")));
		study.setImgstorelogin(Utils.convertToString(rs.getObject("imgstorelogin")));
		study.setImgstorepassword(Utils.convertToString(rs.getObject("imgstorepassword")));
		StudyStatusDao ssd = new StudyStatusDao(null);
		study.setStudystatus(ssd.single(study.getStatus()));
		UserInfoDao uid = new UserInfoDao(null);
		study.setUserInfo(uid.single(study.getOwnerid()));
		return study;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
