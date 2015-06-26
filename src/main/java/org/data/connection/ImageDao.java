package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.DirectoryPath;
import org.data.form.Image;
import org.data.form.ImageViewType;
import org.data.handle.Utils;

public class ImageDao extends DAO<Image>{

	public ImageDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Image obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Image obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Image obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Image single(int id) {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from images where  imgguid like "
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
	public List<Image> all() {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from images limit 10";
			ResultSet rs = statement.executeQuery(query);
			List<Image> data = new ArrayList<Image>();
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
	public Image get(ResultSet rs) {
		Image img = new Image();
		try{
			img.setImgguid(Utils.convertToString(rs.getObject("imgguid")));
			img.setPlantid(Utils.convertToInt(rs.getObject("plantid")));
			img.setStudyid(Utils.convertToInt(rs.getObject("studyid")));
			img.setTaskid(Utils.convertToInt(rs.getObject("taskid")));
			img.setTagid(Utils.convertToInt(rs.getObject("tagid")));
			img.setImgacqprofileid(Utils.convertToInt(rs.getObject("imgacqprofileid")));
			img.setViewtypeid(Utils.convertToInt(rs.getObject("viewtypeid")));
			img.setStationid(Utils.convertToInt(rs.getObject("stationid")));
			img.setRootpathid(Utils.convertToInt(rs.getObject("rootpathid")));
			img.setValid(Utils.convertToBool(rs.getObject("valid")));
			img.setImgangle(Utils.convertToInt(rs.getObject("imgangle")));
			img.setSubfolder(Utils.convertToString(rs.getObject("subfolder")));
			img.setAcquisitiondate(Utils.convertToString(rs.getObject("acquisitiondate")));
			img.setTimestamps(rs.getTimestamp("acquisitiondate").getTime());
			img.setImgguid(Utils.convertToString(rs.getObject("imgguid")));
			img.setImgid(Utils.convertToInt(rs.getObject("imgid")));
			img.setLane(Utils.convertToInt(rs.getObject("lane")));
			img.setRank(Utils.convertToInt(rs.getObject("rank")));
			img.setLevel(Utils.convertToInt(rs.getObject("level")));
			img.setRefimage(Utils.convertToBool(rs.getObject("refimage")));
			ImageViewTypeDao ivtd = new ImageViewTypeDao(null);
			ImageViewType ivt= ivtd.single(img.getViewtypeid());
			img.setViewType(ivt);
			DirectoryPathDao dpd = new DirectoryPathDao(null);
			DirectoryPath dp = dpd.single(img.getRootpathid());
			img.setRootPath(dp);
			return img;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
			
		}
	}

}
