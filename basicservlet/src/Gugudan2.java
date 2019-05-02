package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ggd2")
public class Gugudan2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String color;
	int dan;
	
	@Override
	public void init() throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<style>");
	      out.println("span { display: inline-block; width:150px; border: 2px solid black; }");
	      out.println("span[class='0'] { background-color:orange; }");
	      out.println("span[class='1'] { background-color:cyan; }");
	      out.println("</style>");
	      out.println("</head>");
	      out.println("<div align='center'>");
	      for (int i = 1; i <= 9 ; i++) {
	         for (int j = 2; j <= 9; j++) {
	            out.println("<span class='"+(j%2)+"'>"+j+" * " + i + " = " + (j*i) +"</span>");
	         }
	         out.println("<br>");
	      }
	      out.println("</div>");
	      out.println("</html>");
	}

}
