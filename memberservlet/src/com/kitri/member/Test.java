package com.kitri.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registertest")
public class Test extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   public Test() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html;charset=UTF-8");
      PrintWriter out = resp.getWriter();
      
      String name = req.getParameter("name");
      String id = req.getParameter("id");
      String pass = req.getParameter("pass");
      String email = req.getParameter("emailid")+"@"+req.getParameter("emaildomain");
      String tel1 = req.getParameter("tel1");
      String tel2 = req.getParameter("tel2");
      String tel3 = req.getParameter("tel3");
      String zipcode = req.getParameter("zipcode");
      String address = req.getParameter("address");
      String address_detail = req.getParameter("address_detail");
      
      Connection conn=null;
      PreparedStatement stmt=null;
      
      
      try {
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "kitri", "kitri");
         String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?)";
         
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, name);
         stmt.setString(2, id);
         stmt.setString(3, pass);
         stmt.setString(4, email);
         stmt.setString(5, tel1);
         stmt.setString(6, tel2);
         stmt.setString(7, tel3);
         stmt.setString(8, zipcode);
         stmt.setString(9, address);
         stmt.setString(10, address_detail);
         
         int a = stmt.executeUpdate();
         
         if (a>0) {
            out.println("<html>");
            out.println("<body>");
            out.println("회원관리 완료옷!!!");
            out.println("</body>");
            out.println("</html>");
         } else {
            out.println("<html>");
            out.println("<body>");
            out.println("회원관리 실패..");
            out.println("</body>");
            out.println("</html>");
         }
               
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("UTF-8");
      doGet(request, response);
   }
}

