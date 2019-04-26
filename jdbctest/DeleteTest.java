package com.kitri.jdbctest;

import java.sql.*;

public class DeleteTest {

	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	public Connection DBConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		return conn;
	}

	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		String id = "지워봐라";
		int cnt = 0;

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = dt.DBConnection();

			String sql = "";
			sql += "delete from jdbctest where id = '" + id + "'";

			stmt = conn.createStatement();

			cnt = stmt.executeUpdate(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		if (cnt != 0)
			System.out.println(cnt + "개 delete!!!!");

	}
}
