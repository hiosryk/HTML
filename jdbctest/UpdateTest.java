package com.kitri.jdbctest;

import java.sql.*;

//javaz의 가입일을 현재시간으로 수정.
public class UpdateTest {

	public UpdateTest() {
		try {
//			드라이버 불러오기 C.F
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Loading Sucess!!!");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

//			connection생성 D.g () 연결 
	public Connection DBConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("Connection Sucess!!");
		return conn;

	}

//	업데이트>> 
	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		String id = "java";
		int cnt = 0;

		Connection conn = null;
		Statement stmt = null;

		try {
//			연결
			conn = ut.DBConnection();
//			실행준비
			String sql = "";
			sql += "update jdbctest set joindate = sysdate\n";
			sql += "where id = '" + id + "'";
//			System.out.println(sql);

			stmt = conn.createStatement();
//			실행

			cnt = stmt.executeUpdate(sql);
//			System.out.println(cnt);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (stmt != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		if (cnt != 0)
			System.out.println(cnt + "개 update !!!!!!!");

	}

}