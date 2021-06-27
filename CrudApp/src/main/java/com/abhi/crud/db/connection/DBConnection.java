package com.abhi.crud.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() {
		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String username = "system";
			String password = "root";
			Connection con = null;

			Class.forName(driverName);
			con = DriverManager.getConnection(dbURL, username, password);

			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
