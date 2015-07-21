package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImgProcProfile;
import org.data.form.ImgProcResult;
import org.data.handle.Utils;

public class ImgProcResultDao extends DAO<ImgProcResult> {

	public ImgProcResultDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ImgProcResult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ImgProcResult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ImgProcResult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImgProcResult single(int id) {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgprocresults where  resultid = "
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
	public List<ImgProcResult> all() {
		List<ImgProcResult> ipp = new ArrayList<ImgProcResult>();
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from imgprocresults limit 10");

			while (result.next()) {

				ipp.add(this.get(result));
			}
		} catch (Exception ex) {
			return null;
		}
		return ipp;
	}

	public List<ImgProcResult> all(boolean test) {
		List<ImgProcResult> ipp = new ArrayList<ImgProcResult>();
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result;
			if (test)
				result = statement
						.executeQuery("Select * from imgprocresults limit 10");
			else
				result = statement.executeQuery("Select * from imgprocresults");

			while (result.next()) {

				ipp.add(this.get(result));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		return ipp;
	}

	@Override
	public ResultSet resultSet() {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from imgprocresults");
			return result;
		} catch (Exception ex) {
			return null;
		}
	}
	
	@Override
	public ResultSet resultSet(String query) {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery(query);
			return result;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public ImgProcResult get(ResultSet rs) {
		ImgProcResult ipr = new ImgProcResult();
		try {
			ipr.setResultid(Utils.convertToInt(rs.getObject("resultid")));
			ipr.setStudyname(Utils.convertToString(rs.getObject("studyname")));
			ipr.setTaskid(Utils.convertToInt(rs.getObject("taskid")));
			ipr.setTagname(Utils.convertToString(rs.getObject("tagname")));
			ipr.setPlantid(Utils.convertToInt(rs.getObject("plantid")));
			ipr.setResultdate(Utils.convertToString(rs.getObject("resultdate")));
			ipr.setTimeStampResult(rs.getTimestamp("resultdate") == null ? 0
					: rs.getTimestamp("resultdate").getTime());
			ipr.setValid(Utils.convertToBool(rs.getObject("valid")));
			ipr.setOfflineprocessing(Utils.convertToBool(rs
					.getObject("offlineprocessing")));
			ipr.setImgprocprofilename(Utils.convertToString(rs
					.getObject("imgprocprofilename")));
			ipr.setImgguid(Utils.convertToString(rs.getObject("imgguid")));
			ipr.setRootpath(Utils.convertToString(rs.getObject("rootpath")));
			ipr.setXscale(Utils.convertToString(rs.getObject("xscale")));
			ipr.setYscale(Utils.convertToString(rs.getObject("yscale")));
			ipr.setParallelboundingbox_x(Utils.convertToInt(rs
					.getObject("parallelboundingbox_x")));
			ipr.setParallelboundingbox_y(Utils.convertToInt(rs
					.getObject("parallelboundingbox_y")));
			ipr.setParallelboundingbox_width(Utils.convertToInt(rs
					.getObject("parallelboundingbox_width")));
			ipr.setParallelboundingbox_height(Utils.convertToInt(rs
					.getObject("parallelboundingbox_height")));
			ipr.setParallelboundingbox_area(Utils.convertToInt(rs
					.getObject("parallelboundingbox_area")));
			ipr.setNonparallelboundingbox_x(Utils.convertToDouble(rs
					.getObject("nonparallelboundingbox_x")));
			ipr.setNonparallelboundingbox_y(Utils.convertToDouble(rs
					.getObject("nonparallelboundingbox_y")));
			ipr.setNonparallelboundingbox_width(Utils.convertToDouble(rs
					.getObject("nonparallelboundingbox_width")));
			ipr.setNonparallelboundingbox_height(Utils.convertToDouble(rs
					.getObject("nonparallelboundingbox_height")));
			ipr.setNonparallelboundingbox_area(Utils.convertToDouble(rs
					.getObject("nonparallelboundingbox_area")));
			ipr.setNonparallelboundingbox_teta(Utils.convertToDouble(rs
					.getObject("nonparallelboundingbox_teta")));
			ipr.setCenterofmassx(Utils.convertToDouble(rs
					.getObject("centerofmassx")));
			ipr.setCenterofmassy(Utils.convertToDouble(rs
					.getObject("centerofmassy")));
			ipr.setArea_color_1(Utils.convertToInt(rs.getObject("area_color_1")));
			ipr.setArea_color_2(Utils.convertToInt(rs.getObject("area_color_2")));
			ipr.setFitellipse_x(Utils.convertToDouble(rs
					.getObject("fitellipse_x")));
			ipr.setFitellipse_width(Utils.convertToDouble(rs
					.getObject("fitellipse_y")));
			ipr.setFitellipse_height(Utils.convertToDouble(rs
					.getObject("fitellipse_width")));
			ipr.setFitellipse_teta(Utils.convertToDouble(rs
					.getObject("fitellipse_height")));
			ipr.setCenterofmassy(Utils.convertToDouble(rs
					.getObject("fitellipse_teta")));
			ipr.setFitellipse_area(Utils.convertToDouble(rs
					.getObject("fitellipse_area")));
			ipr.setMinenclosingcircle_x(Utils.convertToDouble(rs
					.getObject("minenclosingcircle_x")));
			ipr.setMinenclosingcircle_y(Utils.convertToDouble(rs
					.getObject("minenclosingcircle_y")));
			ipr.setMinenclosingcircle_area(Utils.convertToDouble(rs
					.getObject("minenclosingcircle_area")));
			ipr.setConvexhull(Utils.convertToString(rs.getObject("convexhull")));
			ipr.setBinaryimgguid(Utils.convertToString(rs
					.getObject("binaryimgguid")));
			ipr.setLane(Utils.convertToInt(rs.getObject("lane")));
			ipr.setRank(Utils.convertToInt(rs.getObject("rank")));
			ipr.setLevel(Utils.convertToInt(rs.getObject("level")));
			ipr.setSubfolder(Utils.convertToString(rs.getObject("subfolder")));
			ipr.setBinarysubfolder(Utils.convertToString(rs
					.getObject("binarysubfolder")));
			ipr.setUnitscale(Utils.convertToString(rs.getObject("unitscale")));
			ipr.setMinenclosingcircle_radius(Utils.convertToDouble(rs
					.getObject("minenclosingcircle_radius")));
			ipr.setAcquisitiondate(Utils.convertToString(rs
					.getObject("acquisitiondate")));
			System.out.println("transacting... with resultid "
					+ ipr.getResultid());

			return ipr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
