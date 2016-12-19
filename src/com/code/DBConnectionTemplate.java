package com.code;

import java.sql.*;


public class DBConnectionTemplate {

	public static boolean updatePassword(String mobile, String password, String newpassword) {
		return connection(conn -> statement(conn, "select id, password from user where mobile = ?", stmt -> {
			stmt.setString(1, mobile);
			return resultSet(stmt, rs -> {
				if (rs.next()) {
					if (rs.getString("password").equals(password)) {
						long id = rs.getLong("id");
						return statement(conn, "update user set password = ? where id = ?", stmt2 -> {
							stmt2.setString(1, newpassword);
							stmt2.setLong(3, id);
							return stmt2.executeUpdate() == 1;
						});
					}
				}
				return false;
			});
		}));
	}


	public interface ConnectionCallback<T> {
		T doConnection(Connection conn) throws SQLException;
	}
	public interface StatementCallback<T> {
		T doStatement(PreparedStatement stmt) throws SQLException;
	}
	public interface ResultSetCallback<T> {
		T doResultSet(ResultSet rs) throws SQLException;
	}
	public static <T> T connection(ConnectionCallback<T> callback) {
		Connection conn = null;
		T result = null;
		try {
			conn = beginTransaction();
			result = callback.doConnection(conn);
//            commitTransaction(conn);
		} catch (SQLException e) {
//            rollbackTransaction(conn);
			throw new RuntimeException(e);
		} finally {
//            safeClose(conn);
		}
		return result;
	}

	private static Connection beginTransaction() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://127.0.0.1:3306/jjd?useUnicode=true&generateSimpleParameterMetadata=true&characterEncoding=utf-8" ;
		String username = "root";
		String password = "";
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static <T> T statement(Connection conn, String sql, StatementCallback<T> callback) throws SQLException {
		PreparedStatement stmt = null;
		T result = null;
		try {
			stmt = conn.prepareStatement(sql);
			result = callback.doStatement(stmt);
		} finally {
//            safeClose(stmt);
		}
		return result;
	}
	public static <T> T resultSet(PreparedStatement stmt, ResultSetCallback<T> callback) throws SQLException {
		ResultSet rs = null;
		T result = null;
		try {
			rs = stmt.executeQuery();
			result = callback.doResultSet(rs);
		} finally {
//            safeClose(rs);
		}
		return result;
	}

}
