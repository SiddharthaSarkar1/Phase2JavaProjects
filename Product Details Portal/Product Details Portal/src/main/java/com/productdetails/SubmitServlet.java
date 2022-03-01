package com.productdetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/submitservlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			
			String Id = request.getParameter("Id");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String date = request.getParameter("date");
			Product product = new Product(Id, name, price, date);
			
			HttpSession ss = request.getSession();
			ss.setAttribute("product", product);
			response.sendRedirect("ShowProduct.jsp");
			
		doGet(request, response);
		}
		catch(Exception e){
			e.printStackTrace();
			
	}
	}

}
