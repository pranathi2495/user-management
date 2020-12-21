package com.manthan.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionUtils {

	//private static final String DB_NAME = "usermanagement";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/usermanagement";
//	private static final String URL = "jdbc:h2:file:E:/work/eclipse-space/user-management/db/test";
	//private static final String URL = "jdbc:h2:tcp://localhost/E:/work/eclipse-space/user-management/db/test";
	
	
	

	private static DBConnectionUtils _instance = null;

	public static DBConnectionUtils getInstance() {

		if (_instance == null) {
			_instance = new DBConnectionUtils();
		}
		return _instance;
	}

	private DBConnectionUtils() {

	}

	public Connection getConnection() {
		Connection connection = null;
		try {

//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void closeConnection(Connection con, PreparedStatement smt, ResultSet res) {
		try {

			if (res != null) {
				res.close();
			}
			if (smt != null) {
				smt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeConnection(Connection con, PreparedStatement smt) {
		try {

			
			if (smt != null) {
				smt.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
