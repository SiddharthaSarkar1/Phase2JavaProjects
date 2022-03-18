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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
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
				PreparedStatement stmt = conn.prepareStatement("DELETE FROM students_data WHERE rollno=?");
				stmt.setInt(1, rollno);
				int rs = stmt.executeUpdate();
				if(rs>0){
					System.out.println(rs+ " deleted from DB");
					response.sendRedirect("fetch");
				}
				else {
					System.out.println("Error while deleting a data");
					response.sendRedirect("fetch");
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
