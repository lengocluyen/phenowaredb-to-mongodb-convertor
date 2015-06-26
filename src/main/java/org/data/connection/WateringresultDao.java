package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.connection.DAO;
import org.data.form.Wateringresult;
import org.data.handle.Utils;



public class WateringresultDao extends DAO<Wateringresult>{

	public WateringresultDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Wateringresult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Wateringresult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Wateringresult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Wateringresult single(int id) {
		try {
			Statement statement = this.connect.createStatement();
			ResultSet result = statement
					.executeQuery("Select * from wateringresults where wateringid = "
							+ id);

			if (result.first()) {
				return this.get(result);
			}
			return null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public List<Wateringresult> all() {
		List<Wateringresult> wrs = new ArrayList<Wateringresult>();
		try {
			Statement statement = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from wateringresults limit 10");
			
			while (result.next()) {
				Wateringresult temps = this.get(result);
				wrs.add(temps);
			}
		} catch(Exception ex) {
			return null;
		}
		return wrs;
	}

	@Override
	public ResultSet resultSet() {
		Statement statement;
		ResultSet result;
		try {
			statement = this.connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			result = statement
					.executeQuery("Select * from wateringresults limit 10");
		} catch(Exception ex) {
			return null;
		}
		return result;
	}

	@Override
	public Wateringresult get(ResultSet result) {
		Wateringresult temps = new Wateringresult();
		try{
		temps.setWateringId(Utils.convertToInt(result.getInt("wateringid")));
		temps.setStudyName (Utils.convertToString(result.getString("studyname")));
		temps.setTaskId (Utils.convertToInt(result.getInt("taskid")));
		temps.setTagName (Utils.convertToString(result.getString("tagname")));
		temps.setPlantId ( Utils.convertToInt(result.getInt("plantid")));
		temps.setResultDate(result.getTimestamp("resultdate"));
		
		temps.setValid ( Utils.convertToBool(result.getBoolean("valid")));
		temps.setSuccess(Utils.convertToBool(result.getBoolean("success")));
		temps.setCalibration(Utils.convertToInt(result.getInt("calibration")));
		
		temps.setLane(Utils.convertToInt(result.getInt("lane")));
		temps.setRank(Utils.convertToInt(result.getInt("rank")));
		temps.setLevel(Utils.convertToInt(result.getInt("level")));
		
		temps.setRequiredProduct( Utils.convertToString(result.getString("reqproductname")));
		temps.setRequiredScaleType( Utils.convertToString(result.getString("reqscaletypename")));
		temps.setRequiredPumpType( Utils.convertToString(result.getString("reqpumptypename")));
		temps.setRequiredTargetWeight( Utils.convertToInt(result.getInt("reqtargetweight")));
		temps.setRequiredTargetQuantity( Utils.convertToInt(result.getInt("reqtargetquantity")));
		temps.setRequiredPumpSpeed( Utils.convertToInt(result.getInt("reqpumpspeed")));
		temps.setRequiredMaxQuantity( Utils.convertToInt(result.getInt("reqmaxquantity")));
		temps.setRequiredMinWeight( Utils.convertToInt(result.getInt("reqminweight")));
		temps.setRequiredMovePerch( Utils.convertToBool(result.getBoolean("reqmoveperch")));
		
		temps.setUsedStationId(Utils.convertToInt(result.getInt("usedstationid")));
		temps.setUsedScaleId(Utils.convertToInt(result.getInt("usedscaleid")));
		temps.setUsedPumpId(Utils.convertToInt(result.getInt("usedpumpid")));
		temps.setUsedProduct(Utils.convertToString(result.getString("usedproductname")));	
		temps.setUsedScaleType(Utils.convertToString(result.getString("usedscaletypename")));	
		temps.setUsedPumpType(Utils.convertToString(result.getString("usedpumptypename")));	
		temps.setUsedPumpSpeed(Utils.convertToInt(result.getInt("pumpspeed")));
		
		temps.setWeightBefore (Utils.convertToInt(result.getInt("weightbefore")));
		temps.setWeightAfter ( Utils.convertToInt(result.getInt("weightafter")));
		return temps;
		}
		catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}