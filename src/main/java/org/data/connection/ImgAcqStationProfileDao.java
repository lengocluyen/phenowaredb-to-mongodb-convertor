package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.data.form.ImgAcqStationProfile;
import org.data.handle.Utils;

public class ImgAcqStationProfileDao extends DAO<ImgAcqStationProfile> {

	public ImgAcqStationProfileDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ImgAcqStationProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ImgAcqStationProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ImgAcqStationProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImgAcqStationProfile single(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImgAcqStationProfile> all() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet resultSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImgAcqStationProfile get(ResultSet rs) {
		ImgAcqStationProfile iasp = new ImgAcqStationProfile();
		try{
			iasp.setImgacqstationprofileid(Utils.convertToInt(rs.getObject("imgacqcameraprofileid")));
			iasp.setImgacqstationprofilename(Utils.convertToString(rs.getObject("imgacqcameraprofilename")));
			iasp.setValidated(Utils.convertToBool(rs.getObject("validated")));
			iasp.setDeleted(Utils.convertToBool(rs.getObject("deleted")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setDescription(Utils.convertToString(rs.getObject("description")));
			
			iasp.setImageryusertype(Utils.convertToInt(rs.getObject("imageryusertype")));
			iasp.setStationid(Utils.convertToInt(rs.getObject("stationid")));
			iasp.setIndexer(Utils.convertToInt(rs.getObject("indexer")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			
			return iasp;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
