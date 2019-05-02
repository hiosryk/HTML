package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/singleparam")
public class SingleParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.data get
		String name = request.getParameter("name"); //id아니고 이름가져가요 기억하세요
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age")); //못얻어와서 age가 업어서. 널 html에서 실행.
		
//		2.logic
		String color = age == 10 ? "pink" : "skyblue";
		
		
//		3.response page : 안효인(java2)님 안녕하세요. 10대밑이면 빨강 10대위면 파랑색.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("	<body>");
		
		out.println( name + "(" +id + ")" + "님 안녕하세요.");
		out.println( name + "(<font color =" + color + ">" +id + "</font>)" + "님 안녕하세요.");
//		out.println(" name + "(<font color=\"" + color +"\">" + id + "</font>)  + "님 안녕하세요.");
		out.println("	</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("utf-8"); //get에서 안되고 post에서만 가능. 
		String name = request.getParameter("name"); //id아니고 이름가져가요 기억하세요
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age")); //못얻어와서 age가 업어서. 널 html에서 실행.
		
//		2.logic
		String color = age == 10 ? "pink" : "skyblue";
		
		
//		3.response page : 안효인(java2)님 안녕하세요. 10대밑이면 빨강 10대위면 파랑색.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("	<body>");
		
//		out.println( name + "(" +id + ")" + "님 안녕하세요.");
		out.println( name + "(<font color =" + color + ">" +id + "</font>)" + "님 안녕하세요.");
		out.println("	</body>");
		out.println("</html>");
		
	}

}
