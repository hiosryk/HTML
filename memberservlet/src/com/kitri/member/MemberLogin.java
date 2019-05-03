package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection conn = null; //connection 선언
		PreparedStatement pstmt = null; //pstmt
		ResultSet rs = null;
		
		
		request.setCharacterEncoding("UTF-8");//한글
//		1.data get (아이디, 비번)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		

//		2.Logic : 1의 data를  select
//		select name
//		from member
//		where id = ? and pass = ?
		
		String name = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.52:1521:orcl", "kitri", "kitri");
			StringBuffer sql = new StringBuffer();
			sql.append("select name \n");
			sql.append("from member \n");
			sql.append("where id = ? and pass = ? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next())
				
			name = rs.getString(1);		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			
		}
		
			response.setContentType("text/html;charset=UTF-8");	//앞으로 할게 네모빨대야. 
			PrintWriter out = response.getWriter(); //pw 스트림이죠? 데이터를 와따가따 네모빨대랬나? 네모빨대로. 
					out.println("<html>");//소스상의 엔터는 공백이다.
					out.println(	"<body>");
					if(name != null) {
						out.println("<strong>" + name + "</strong>님 안녕하세요.<br>");
					} else {
						out.println("<font size=\"13\" color=\"red\">");
						out.println("아이디 또는 비밀번호를 다시 확인하세요.<br>");
						out.println("등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.<br>");
						out.println("</font>");
					}
					
					out.println();
					
					out.println(	"</body>");
					out.println("</html>");
		
//		3. response page : 2의 결과에 따라
//			3-1. name!= null : 홍길동님 안녕하세요.
		
//			3-2. name == null
//			아이디 또는 비밀번호를 다시 확인하세요.
//			등록되지 않은 아이디이거나, 아이디 또는 비밀번호를 잘못 입력하셨습니다.
//			로그인
//		4.일치하지 않는 다면 로그인 실패 
		
	}

}

}