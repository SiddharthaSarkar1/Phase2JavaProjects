package com;

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


@WebServlet("/productdet")
public class ProductDetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String param = request.getParameter("prodid");
		int prodID = Integer.parseInt(param);
		
		Properties prop= new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/config.properties"));
		Connection conn= DbConfig.getConnect(prop);
		
		if(conn != null) {
			
			try {
				PreparedStatement stmt = conn.prepareStatement("select * from ecomproduct where id=?");
				stmt.setInt(1, prodID);
				ResultSet rs= stmt.executeQuery();
				out.print("<div align='center'>");
				out.print("<h1 style='color:blue'>Product Details</h1><hr>");
				
				out.print("<div align='center' style='border-style: double;'>");
					if(rs.next()!=false)
					{
					rs= stmt.executeQuery();
					while(rs.next())
					{
						out.print("<b>Product ID :</b> "+rs.getInt(1)+"<br><br>  <b>Product Name : </b>"+rs.getString(2)+" <br><br> <b>Product Price :     </b>"+rs.getString(3)+"<br><br>  <b>Dated On :  </b>"+rs.getString(4)+"<br><br>");
					}
					}else{
						out.print("<h4 style='color:red'>Failed to fetch the data : No such Product id exists : "+prodID+"</h4>");
					}
					out.print("</div>");
					out.print("</div>");
				}catch(SQLException e) {
					e.printStackTrace();
				}
			
		}else {
			System.out.println("Unable to established connection with the database......");
		}
		
	}

}
