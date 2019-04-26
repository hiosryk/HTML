package com.kitri.jdbctest;

import java.sql.*;

public class InsertTest {

	public InsertTest() {
		try {
//			1.드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Succeess!!!!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection makeConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
		System.out.println("DB Connection Success!!!!!!");
		return conn;

	}

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		String name = "김형섭";
		String id = "JAVA";
		int cnt = 0;

		Connection conn = null;
		Statement stmt = null;
		try {
//			2.연결
			conn = it.makeConnection();
//			insert into jdbctest (no, name, id, joindate)
//			calues (jdbctest_no_swq.nextval,'김형섭','javaz',sysdate);

//			3.실행준비
			String sql = "";// 나중엔 StringBuffer
			sql += "insert into jdbctest (no, name, id, joindate) \n";
			sql += "values (jdbctest_no_seq.nextval, '" + name + "','" + id + "', sysdate)";
//			System.out.println(sql);
			stmt = conn.createStatement();

//			4.실행
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
			System.out.println("data insert success!!!!!!!!!");
		else
			System.out.println("data insert fail!!!!!!!!!");

	}
}
