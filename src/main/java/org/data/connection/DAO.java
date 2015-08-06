package org.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		if (this.connect == null) {
			if (conn != null)
				this.connect = conn;
			else{
				try {
					Class.forName("org.postgresql.Driver");
					this.connect = DriverManager
							.getConnection(
									"jdbc:postgresql://lps-elcomdb.supagro.inra.fr:5432/phenowaredb",
									"phis", "c1.61!");
					this.connect.setAutoCommit(false);

				} catch (Exception ex) {
					System.out.println("connectException : connexion = " + this.connect);
					ex.printStackTrace();
				}
			}
		}
	}

	public Connection getConnect() {
		if (connect != null)
			return connect;
		else {
			try {
				Class.forName("org.postgresql.Driver");
				this.connect = DriverManager
						.getConnection(
								"jdbc:postgresql://lps-elcomdb.supagro.inra.fr:5432/phenowaredb",
								"phis", "c1.61!");
			} catch (Exception ex) {
				return null;
			}
			return this.connect;
		}
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract T single(int id);

	public abstract List<T> all();

	public abstract ResultSet resultSet() throws SQLException;
	
	public abstract ResultSet resultSet(String query) throws SQLException;

	public abstract T get(ResultSet result);
}
