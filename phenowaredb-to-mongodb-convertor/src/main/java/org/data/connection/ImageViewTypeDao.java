package org.data.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.data.form.ImageViewType;
import org.data.form.Plant;
import org.data.handle.Utils;

public class ImageViewTypeDao extends DAO<ImageViewType> {

	public ImageViewTypeDao(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(ImageViewType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(ImageViewType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ImageViewType obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageViewType single(int id) {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgviewtypes where  viewtypeid = "
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
	public List<ImageViewType> all() {
		try {
			Statement statement = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			String query = "Select * from imgviewtypes";
			ResultSet rs = statement.executeQuery(query);
			List<ImageViewType> data = new ArrayList<ImageViewType>();
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
	public ImageViewType get(ResultSet rs) {
		ImageViewType ivt = new ImageViewType();
		try {
			ivt.setViewtypeid(Utils.convertToInt(rs.getObject("viewtypeid")));
			ivt.setViewtypelabel(Utils.convertToString(rs
					.getObject("viewtypelabel")));
			return ivt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
