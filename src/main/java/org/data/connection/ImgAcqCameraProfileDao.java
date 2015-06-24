package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImageViewType;
import org.data.form.ImgAcqCameraProfile;
import org.data.handle.Utils;

public class ImgAcqCameraProfileDao extends DAO<ImgAcqCameraProfile>{

	public ImgAcqCameraProfileDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ImgAcqCameraProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ImgAcqCameraProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ImgAcqCameraProfile obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImgAcqCameraProfile single(int id) {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgacqcameraprofiles where  imgacqcameraprofileid = "
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
	public List<ImgAcqCameraProfile> all() {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgacqcameraprofiles";
			ResultSet rs = statement.executeQuery(query);
			List<ImgAcqCameraProfile> data = new ArrayList<ImgAcqCameraProfile>();
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
	public ImgAcqCameraProfile get(ResultSet rs) {
		ImgAcqCameraProfile iacp = new ImgAcqCameraProfile();
		try{
			iacp.setImgacqcameraprofileid(Utils.convertToInt(rs.getObject("imgacqcameraprofileid")));
			iacp.setImgacqcameraprofilename(Utils.convertToString(rs.getObject("imgacqcameraprofilename")));
			iacp.setValidated(Utils.convertToBool(rs.getObject("validated")));
			iacp.setDeleted(Utils.convertToBool(rs.getObject("deleted")));
			iacp.setProfiletype(Utils.convertToInt(rs.getObject("profiletype")));
			iacp.setDescription(Utils.convertToString(rs.getObject("description")));
			iacp.setImageryusertype(Utils.convertToInt(rs.getObject("imageryusertype")));
			iacp.setInterfaceacqtype(Utils.convertToInt(rs.getObject("intefaceacqtype")));
			iacp.setViewtype(Utils.convertToInt(rs.getObject("viewtype")));
			iacp.setStationid(Utils.convertToInt(rs.getObject("stationid")));
			iacp.setWidth(Utils.convertToInt(rs.getObject("width")));
			iacp.setHeight(Utils.convertToInt(rs.getObject("height")));
			iacp.setTriggermode(Utils.convertToInt(rs.getObject("triggermode")));
			iacp.setShutter(Utils.convertToInt(rs.getObject("shutter")));
			iacp.setGain(Utils.convertToInt(rs.getObject("gain")));
			iacp.setBrightness(Utils.convertToInt(rs.getObject("brightness")));
			iacp.setHue(Utils.convertToInt(rs.getObject("hue")));
			iacp.setGamma(Utils.convertToInt(rs.getObject("gamma")));
			iacp.setSaturation(Utils.convertToInt(rs.getObject("saturation")));
			iacp.setSharpness(Utils.convertToInt(rs.getObject("sharpness")));
			iacp.setWhitebalance(Utils.convertToInt(rs.getObject("whitebalance")));
			iacp.setViewcount(Utils.convertToInt(rs.getObject("viewcount")));
			iacp.setPixelformat(Utils.convertToString(rs.getObject("pixelformat")));
			iacp.setMode(Utils.convertToString(rs.getObject("mode")));
			
			return iacp;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}

}
