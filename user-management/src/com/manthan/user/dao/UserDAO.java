package com.manthan.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manthan.user.dto.User;

public class UserDAO {
	private static final String FETCH_USER_CREDENTIALS = "SELECT EMAIL,PASSWORD FROM USER_DETAILS WHERE EMAIL = ?";
	private static final String INSERT_USERS_SQL = "INSERT INTO USER_DETAILS "
			+ "  (NAME, EMAIL,AGE, PASSWORD, PHONE_NO) VALUES  (?, ?, ?,?,?)";

	private static final String SELECT_USER_BY_ID = "SELECT ID,NAME,AGE,EMAIL,PHONE_NO,PASSWORD FROM USER_DETAILS WHERE ID = ?";
	private static final String SELECT_USER_BY_EMAIL = "SELECT ID,NAME,EMAIL,PHONE_NO FROM USER_DETAILS WHERE EMAIL = ?";
	private static final String FETCH_ALL_USERS = "SELECT ID,NAME,EMAIL,PHONE_NO,AGE FROM USER_DETAILS";
	private static final String DELETE_USERS_SQL = "DELETE FROM USER_DETAILS WHERE ID = ?";
	private static final String UPDATE_USERS_SQL = "UPDATE USER_DETAILS SET NAME = ?,EMAIL= ?, AGE= ?,PASSWORD = ?,PHONE_NO= ? WHERE ID = ?";

	DBConnectionUtils connectionUtils = null;

	public UserDAO() {
		connectionUtils = DBConnectionUtils.getInstance();
	}

	public boolean validate(String userName, String password) {

		if (userName != null && !userName.isEmpty() && password != null && !password.isEmpty()) {

			Connection connection = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				connection = connectionUtils.getConnection();
				ps = connection.prepareStatement(FETCH_USER_CREDENTIALS);
				ps.setString(1, userName);
				rs = ps.executeQuery();

				if (rs.next()) {
					String storedPassword = rs.getString("PASSWORD");
					if (storedPassword.equals(password)) {
						return true;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connectionUtils.closeConnection(connection, ps, rs);
			}

		}

		return false;

	}

	public User selectUser(String email) {
		User user = null;

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = connectionUtils.getConnection();
			ps = connection.prepareStatement(SELECT_USER_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("NAME");
				String userEmail = rs.getString("EMAIL");
				int id = rs.getInt("ID");
				String phoneno = rs.getString("PHONE_NO");

				user = new User(id, name, userEmail, phoneno);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtils.closeConnection(connection, ps, rs);
		}
		return user;
	}

	public User selectUser(Integer userId) {
		User user = null;

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = connectionUtils.getConnection();
			ps = connection.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("NAME");
				String userEmail = rs.getString("EMAIL");
				String password = rs.getString("PASSWORD");
				int id = rs.getInt("ID");
				int age = rs.getInt("AGE");
				String phoneno = rs.getString("PHONE_NO");
				user = new User(id, name, age, password, userEmail, phoneno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtils.closeConnection(connection, ps, rs);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<User> users = new ArrayList<>();

		try {
			connection = connectionUtils.getConnection();
			ps = connection.prepareStatement(FETCH_ALL_USERS);
			rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				int age = rs.getInt("AGE");
				String phoneno = rs.getString("PHONE_NO");
				users.add(new User(id, name, age, email, phoneno));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtils.closeConnection(connection, ps, rs);
		}

		return users;

	}

	public int insertUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		int status = 0;
		try {
			connection = connectionUtils.getConnection();
			ps = connection.prepareStatement(INSERT_USERS_SQL);

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhoneno());

			status = ps.executeUpdate();
			System.out.println("inserted row status: " + status);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtils.closeConnection(connection, ps);
		}
		return status;

	}

	public int updateUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		int rowsUpdated = 0;

		try {
			connection = connectionUtils.getConnection();
			statement = connection.prepareStatement(UPDATE_USERS_SQL);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setInt(3, user.getAge());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getPhoneno());
			statement.setInt(6, user.getId());

			rowsUpdated = statement.executeUpdate();
			System.out.println("rows updated status: " + rowsUpdated);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtils.closeConnection(connection, statement);
		}
		return rowsUpdated;

	}

	public int deleteUser(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		int rowsDeleted = 0;

		try {
			connection = connectionUtils.getConnection();
			statement = connection.prepareStatement(DELETE_USERS_SQL);
			statement.setInt(1, id);

			rowsDeleted = statement.executeUpdate();
			System.out.println("rows deleted status: " + rowsDeleted);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectionUtils.closeConnection(connection, statement);
		}
		return rowsDeleted;

	}
}
