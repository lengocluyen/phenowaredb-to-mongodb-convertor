package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImgAcqCameraProfile;
import org.data.form.ImgAcqStationProfile;
import org.data.form.ProfileType;
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
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgacqstationprofiles where  imgacqstationprofileid = "
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
	public List<ImgAcqStationProfile> all() {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgacqstationprofiles";
			ResultSet rs = statement.executeQuery(query);
			List<ImgAcqStationProfile> data = new ArrayList<ImgAcqStationProfile>();
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
	public ImgAcqStationProfile get(ResultSet rs) {
		ImgAcqStationProfile iasp = new ImgAcqStationProfile();
		try{
			iasp.setImgacqstationprofileid(Utils.convertToInt(rs.getObject("imgacqstationprofileid")));
			iasp.setImgacqstationprofilename(Utils.convertToString(rs.getObject("imgacqstationprofilename")));
			iasp.setValidated(Utils.convertToBool(rs.getObject("validated")));
			iasp.setDeleted(Utils.convertToBool(rs.getObject("deleted")));
			iasp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			
			ProfileTypeDao ptd = new ProfileTypeDao(null);
			ProfileType pt = ptd.single(iasp.getProfiletype());
			if(pt!=null)
				iasp.setProfileTypeObject(pt);
			iasp.setDescription(Utils.convertToString(rs.getObject("description")));
			
			iasp.setImageryusertype(Utils.convertToInt(rs.getObject("imageryusertype")));
			iasp.setStationid(Utils.convertToInt(rs.getObject("stationid")));
			iasp.setIndexer(Utils.convertToInt(rs.getObject("indexer")));
			iasp.setToplight(Utils.convertToInt(rs.getObject("toplight")));
			iasp.setSidelight(Utils.convertToInt(rs.getObject("sidelight")));
			iasp.setZoom(Utils.convertToInt(rs.getObject("zoom")));
			iasp.setFocus(Utils.convertToInt(rs.getObject("focus")));
			iasp.setAperture(Utils.convertToInt(rs.getObject("aperture")));
			iasp.setRotationspeed(Utils.convertToString(rs.getObject("rotationspeed")));
			iasp.setTopviewcount(Utils.convertToInt(rs.getObject("topviewcount")));
			iasp.setSideviewcount(Utils.convertToInt(rs.getObject("sideviewcount")));
			
			return iasp;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
