package com.learningjava.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String param = request.getParameter("rollno");
		int rollno = Integer.parseInt(param);
		
		Properties prop= new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		Connection conn= DBConfig.getConnect(prop);
		
		if(conn != null) {
			try {
				
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students_data WHERE rollno=?");
				stmt.setInt(1, rollno);
				ResultSet rs= stmt.executeQuery();
				out.println("<h1>Welcome and Update your Student data</h1>");
				if(rs.next())
				{
					out.print("<form action='update' method='post'>");
					out.print("<fieldset>");
					out.print("<input type='hidden' name='rollno' value='"+rs.getString(1)+"'>");
					out.print("Name : <input type='text' name='name' value='"+rs.getString(2)+"'><br><br>");
					out.print("Email : <input type='text' name='email' value='"+rs.getString(3)+"'><br><br>");
					out.print("Age : <input type='text' name='age' value='"+rs.getString(4)+"'><br><br>");
					out.print("City : <input type='text' name='city' value='"+rs.getString(5)+"'><br><br>");
					out.print("<input type='submit' value='Update Data'></fieldset></form>");
				}
				else {
					System.out.println("invalid Roll no, Register First");
					response.sendRedirect("index.html");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.getWriter().print("Error while connecting with DB");
		}
		
		
	}

}
