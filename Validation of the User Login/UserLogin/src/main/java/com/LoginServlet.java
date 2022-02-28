package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		out.println("<div>");
        out.println("<h1><center>  ---   Dashboard   ---   </center></h1><hr>");
        out.println("</div>");
        
		
		out.println("<div>");
        out.println("<h1><center><span style='color:green'>  Welcome </span><br><span style='color:blue'>"+ email +"</span> you have successful login.</center></h1>");
        out.println("</div>");
        
        out.println("<div>");
        out.println("<center><a href='logoutservlet'>Logout</a></center>");
        out.println("</div>");
		
        out.close();  
	}

}
