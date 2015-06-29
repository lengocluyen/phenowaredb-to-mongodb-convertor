package org.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn) {
		if (this.connect == null) {
			try {
				Class.forName("org.postgresql.Driver");
				this.connect = DriverManager
						.getConnection(
								"jdbc:postgresql://lps-elcomdb.supagro.inra.fr:5432/phenowaredb",
								"phis", "c1.61!");
				this.connect.setAutoCommit(false);

			} catch (Exception ex) {
				this.connect = conn;
				//System.out.println("connectException : " + this.connect);

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

	public abstract ResultSet resultSet();

	public abstract T get(ResultSet result);
}
