package com.flyaway.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.database.Dao;


@WebServlet("/masterflightlist")
public class MasterFlightList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Dao dao = new Dao();
			List<String[]> flights = dao.getAvailableFlightsMasterList();
			HttpSession session = request.getSession();
			session.setAttribute("flights", flights);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("MasterFlightList.jsp");
		
	}

	
}
