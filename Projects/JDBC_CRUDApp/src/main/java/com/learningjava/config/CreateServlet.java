package com.learningjava.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ageS = request.getParameter("age");
		int age = Integer.parseInt(ageS);
		String city = request.getParameter("city");
		
		Properties prop= new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		Connection conn= DBConfig.getConnect(prop);
		
		if(conn != null) {
			try {
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO students_data (name, email, age, city) VALUES (?, ?, ?, ?)");
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setInt(3, age);
				stmt.setString(4, city);
				
				int rs=stmt.executeUpdate();
				if(rs>0)
				{
					System.out.print(rs+" rows inserted in database");
					response.sendRedirect("read");
				}
				else
				{
					System.out.println("error while inserting a data");
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
