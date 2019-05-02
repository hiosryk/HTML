package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/multiparam")
public class MultiParameterTest extends HttpServlet {
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
		
		

		if (fruit !=null) {
			int len = fruit.length;
		
			for (int i = 0; i < len; i++) {
				out.print(fruit[i]);
					if (i != len -1)
						out.print(", ");
			} 
			out.println("입니다");
		} else {
		out.println("없습니다.");
		}	
		out.println("	</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
