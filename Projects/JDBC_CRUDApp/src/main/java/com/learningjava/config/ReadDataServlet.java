package com.learningjava.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadDataServlet
 */
@WebServlet("/read")
public class ReadDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		Properties prop= new Properties();
		try {
			prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn= DBConfig.getConnect(prop);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		if(conn != null) {
			
			try {
				Statement stmt = conn.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_FORWARD_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM students_data");
				out.print("<h1>Student Details</h1><hr>");
				out.print("<table border=1 cellspacing=0 cellpadding=10><tr><th>Roll no</th><th>Name</th><th>Email</th><th>Age</th><th>City</th><th>Update</th><th>Delete</th>");
				out.print("</tr>");
				
				while(rs.next())
				{
					out.print("<tr>");
					out.print("<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+
				"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getInt(4)+"</td>"+"<td>"+rs.getString(5)+"</td>"+"<td><a href='addstudent?rollno="+rs.getInt(1)+"'>Update</a></td>"+"<td><a href='delete?rollno=\"+rs.getInt(1)+\"'>Delete</a></td>");
					out.println("</tr>");
				}
				out.print("</table>");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			out.println("Unable to establish the database connection.......");
		}
		
	}

	@Override
	public void destroy() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
