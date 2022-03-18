package com.learn;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/demoservlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> studs = Arrays.asList(new Student(1, "Khokon"), new Student(2, "Baptu"), new Student(3, "Bhoda"));
		
		Student s = new Student(10, "Sarkar");
		
		String name = "Siddhartha";
		request.setAttribute("label", name);
		request.setAttribute("student", studs);
		RequestDispatcher rd = request.getRequestDispatcher("Display.jsp");
		rd.forward(request, response);
		
	}


}
