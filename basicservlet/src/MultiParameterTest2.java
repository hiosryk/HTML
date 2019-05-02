package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/multiparam2")
public class MultiParameterTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String fruit[] = request.getParameterValues("fruit");
		
		int age = Integer.parseInt(request.getParameter("age"));
		
//		2.logic
		String color = age == 10? "pink" : "skyblue";
		
//		과일이면 과일 바나나면 바나나 
		
//		
//		3.응답페이지 
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("	<body>");
		
		out.println( name + "(<font color =" + color + ">" +id + "</font>)" + "님 안녕하세요.");
		out.println("당신이 좋아하는 과일은");
		
		

		if ( fruit.length == 0) {
			out.print("없습니다.");
		} else if ( fruit.length == 1 ) {
			out.print( fruit[0] + "입니다");
		} else if ( fruit.length > 1 ) {
		
			int len = fruit.length;							//중요.!
			for (int i = 0; i < len; i++) {
				out.print(fruit[i]);
			} out.print("입니다");
		}
			
			
		
		
		out.println("	</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
