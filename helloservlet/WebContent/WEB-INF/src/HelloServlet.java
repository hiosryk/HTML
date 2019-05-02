package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hs")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	//앞으로 할게 네모빨대야. 
		PrintWriter out = response.getWriter(); //pw 스트림이죠? 데이터를 와따가따 네모빨대랬나? 네모빨대로. 
				out.println("<html>");//소스상의 엔터는 공백이다.
				out.println(	"<body>");
				out.println(	"Hello Servlet!!!<br>");
				out.println(	"안녕 서블릿!!!");
				out.println(	"</body>");
				out.println("</html>");
	}


}
