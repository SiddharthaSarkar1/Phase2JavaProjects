package com.learningjava.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatepage")
public class UpdatePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String param= request.getParameter("id");
		int id= Integer.parseInt(param);
		
		Properties prop= new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		Connection conn= DBCOnfig.getConnect(prop);
		PrintWriter out= response.getWriter();
		
		if(conn!=null)
		{
			try {
				PreparedStatement stmt= 
						conn.prepareStatement("select * from eproduct where id=?");
				stmt.setInt(1, id);
				ResultSet rs= stmt.executeQuery();
				out.println("<h1>Welcome and Update your product</h1>");
				if(rs.next())
				{
					out.print("<form action='update' method='post'>");
					out.print("<input type='hidden' name='id' value='"+rs.getString(1)+"'>");
					out.print("Product Name : <input type='text' name='name' value='"+rs.getString(2)+"'><br><br>");
					out.print("Product Price : <input type='text' name='price' value='"+rs.getString(3)+"'><br><br>");
					out.print("<input type='submit' value='Update Data'></form>");
				}
				else {
					System.out.println("invalid Id, Register First");
					response.sendRedirect("index.html");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			response.getWriter().print("Error while connecting with DB");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
