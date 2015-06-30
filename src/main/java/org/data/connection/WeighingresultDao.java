package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.data.form.Plant;
import org.data.form.Study;
import org.data.form.WeighingSetpoint;
import org.data.form.Weighingresult;
import org.data.handle.Utils;

public class WeighingresultDao extends DAO<Weighingresult> {

	public WeighingresultDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Weighingresult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Weighingresult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Weighingresult obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Weighingresult single(int id) {
		// TODO Auto-generated method stub
		try {
			Statement statement = this.connect.createStatement();
			ResultSet result = statement
					.executeQuery("Select * from weighingresults where weighingid = "
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
	public List<Weighingresult> all() {
		List<Weighingresult> wrs = new ArrayList<Weighingresult>();
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result = statement
					.executeQuery("Select * from weighingresults limit 10");

			while (result.next()) {
				Weighingresult temps = this.get(result);
				wrs.add(temps);
			}
		} catch (Exception ex) {
			return null;
		}
		return wrs;
	}

	public List<Weighingresult> all(boolean test) {
		List<Weighingresult> wrs = new ArrayList<Weighingresult>();
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet result;
			if (test)
				result = statement
						.executeQuery("Select * from weighingresults limit 10");
			else
				result = statement
						.executeQuery("Select * from weighingresults");

			while (result.next()) {
				Weighingresult temps = this.get(result);
				wrs.add(temps);
			}
		} catch (Exception ex) {
			return null;
		}
		return wrs;
	}

	@Override
	public ResultSet resultSet() {
		Statement statement;
		ResultSet result;
		try {
			statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			result = statement
					.executeQuery("Select * from weighingresults limit 10");
		} catch (Exception ex) {
			return null;
		}
		return result;
	}

	WeighingSetpointDao wsd = new WeighingSetpointDao(null);
	PlantDao pld = new PlantDao(null);
	StudyDao std = new StudyDao(null);
	@Override
	public Weighingresult get(ResultSet result) {
		Weighingresult temps = new Weighingresult();
		try {
			temps.setWeighingid(Utils.convertToInt(result.getInt("weighingid")));

			temps.setStudyname(Utils.convertToString(result
					.getString("studyname")));
			temps.setTaskid(Utils.convertToInt(result.getInt("taskid")));
			temps.setTagname(Utils.convertToString(result.getString("tagname")));
			temps.setPlantid(Utils.convertToInt(result.getInt("plantid")));

			
			Study st = std.singleFromName(temps.getStudyname());
			if (st != null) {
				Plant pl = pld.single(st.getStudyid(), temps.getPlantid());
				if (pl != null)
					temps.setPlant(pl);
			}
			temps.setResultdate(result.getTimestamp("resultdate"));
			temps.setDate(Utils.convertToString(result.getString("resultdate")));
			temps.setTimestamps(temps.getResultdate().getTime());
			temps.setValid(Utils.convertToBool(result.getBoolean("valid")));
			temps.setWeighingtype(Utils.convertToString(result
					.getString("weighingtype")));
			temps.setReqscaletypename(Utils.convertToString(result
					.getString("reqscaletypename")));
			temps.setUsedstationid(Utils.convertToInt(result
					.getInt("usedstationid")));
			temps.setUsedscaleid(Utils.convertToInt(result
					.getInt("usedscaleid")));
			temps.setUsedscaletypename(Utils.convertToString(result
					.getString("usedscaletypename")));
			temps.setWeighbefore(Utils.convertToInt(result
					.getInt("weightbefore")));
			temps.setWeighafter(Utils.convertToInt(result.getInt("weightafter")));
			temps.setSuccess(Utils.convertToBool(result.getBoolean("success")));
			temps.setLane(Utils.convertToInt(result.getInt("lane")));
			temps.setRank(Utils.convertToInt(result.getInt("rank")));
			temps.setLevel(Utils.convertToInt(result.getInt("level")));

			WeighingSetpoint ws = wsd.single(temps.getTaskid(),
					temps.getPlantid(), temps.getStudyname());
			if (ws != null)
				temps.setSetpointscaletype(ws.getScaletypeid());
			else
				temps.setSetpointscaletype(-1);
			System.out.println("transacting... with weighingid "
					+ temps.getWeighingid());
			return temps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
