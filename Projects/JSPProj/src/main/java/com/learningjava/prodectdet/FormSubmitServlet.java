package com.learningjava.prodectdet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formsubmit")
public class FormSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("pname");		
		int price = Integer.parseInt(request.getParameter("pprice"));
		
		out.println("<h3>Product name is "+name+"</h3>");
		out.println("<h3>Product price is "+price+"</h3>");
		
	}

}
