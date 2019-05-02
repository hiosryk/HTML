package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dbcounter")
public class DBCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int cnt =0;
	int totalLen;

	public void init() {
		
		cnt = 0;
		totalLen = 8;
	
		try {
//			1.드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Succeess!!!!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			String sql = "";
			sql += "select no \n";
			sql += "from counter";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
			
			sql = "update counter \n";
			sql += "set no = no + 1 \n";
			stmt.executeUpdate(sql);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
				rs.close();
				if(stmt != null)
				stmt.close();
				if(conn != null)
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		System.out.println("DB Connection Success!!!!!!");
		
		
		
		
		cnt++;
		String cntStr = cnt + "";
		int cntLen = cntStr.length();
		int zeroLen = totalLen - cntLen;
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은");
		
		
		
		for (int i = 0; i < zeroLen; i++) {
			out.println("<img src=\"/basicservlet/img/0.PNG\">");
		}
		
		for (int i = 0; i < cntLen; i++) {
			out.println("<img src=\"/basicservlet/img/" + cntStr.charAt(i) + ".PNG\">");
		}
		
		out.println("<br>번째 방문자입니다.");
		out.println("	<body>");
		out.println("</html>");
		
	}


}
