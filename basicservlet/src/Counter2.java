package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Counter2")
public class Counter2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int cnt = 0;
	
	public void init() {
		cnt = 0;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		cnt++;
		String result = String.format("%08d", cnt); // 카운트가 00000001 형태로 나오게. 
		System.out.println(result);


		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은 ");
		
		
		for (int i = 0; i < 8; i++) {
			out.println("<img src=\"/basicservlet/img/"+result.charAt(i)+".PNG\">");
		}
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(0)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(1)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(2)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(3)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(4)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(5)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(6)+".PNG\">");
//		out.println("<img src=\"/basicservlet/img/"+result.charAt(7)+".PNG\">");//1의자리 
		
		out.println("번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}


}
