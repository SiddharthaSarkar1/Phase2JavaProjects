package com.flyaway.database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.flyaway.util.StringUtil;


public class Dao {
	public Connection conn = null;
	public Statement st = null;

	public Dao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_db", "root", "SiddharthaS1995");
		System.out.println("Connected to the Database.........");
		st = conn.createStatement();
	}

	public List<String[]> getAvailableFlights(String S, String D, String d) {

		List<String[]> flights = new ArrayList<>();
		String query = "SELECT * FROM flight_info where Source='" + S + "' and Dest='" + D + "' and date='" + d + "'";
		try {
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				String[] flight = new String[3];
				flight[0] = rs.getString("name");
				flight[1] = rs.getString("time");
				flight[2] = rs.getString("price");
				flights.add(flight);
				return flights;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public List<String[]> getAvailableFlightsMasterList() {

		List<String[]> flights = new ArrayList<>();
		String query = "SELECT * FROM flight_info";
		try {
			ResultSet rs = st.executeQuery(query);

				while(rs.next()){
					String[] flight = new String[6];
					flight[0] = rs.getString("name");
					flight[1] = rs.getString("Source");
					flight[2] = rs.getString("Dest");
					flight[3] = rs.getString("date");
					flight[4] = rs.getString("time");
					flight[5] = rs.getString("price");
					flights.add(flight);
					System.out.println(rs.next());
				}
			
			
			System.out.println(flights.size());
			return flights;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	public HashMap<String, String> checkUser(String email, String password) {

		HashMap<String, String> user = null;
		String query = "select * from user where email='" + email + "' and password='" + password + "'";
		try {
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				user = new HashMap<>();
				user.put("name", rs.getString("name"));
				user.put("email", rs.getString("email"));
				user.put("phno", rs.getString("phno"));
				user.put("adno", rs.getString("adno"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean insertUser(HashMap<String, String> user) {

		String query = "INSERT INTO user (email, password, name, phno, adno) values('" + user.get("email") + "','"
				+ user.get("password") + "','" + user.get("name") + "','" + user.get("phno") + "','" + user.get("adno")
				+ "')";

		try {
			st.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAdmin(String email, String password) {

		try {
			ResultSet rs = st
					.executeQuery("select * from admin where email='" + email + "' and password='" + password + "'");
			if (rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean changeAdminPassword(String email, String password) {

		try {
			ResultSet rs = st.executeQuery("select * from admin where email='" + email + "'");
			if (!rs.next()) {
				return false;
			}
			st.execute("update admin set password='" + password + "' where email='" + email + "'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertFlight(HashMap<String, String> flight) throws SQLException {

		String query1 = "INSERT INTO flight_info (name, Source, Dest, date, time, price) VALUES" + " ('"
				+ StringUtil.fixSqlFieldValue(flight.get("name")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("Source")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("Dest")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("date")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("time")) + "'," + " '"
				+ StringUtil.fixSqlFieldValue(flight.get("price")) + "')";

		System.out.println(flight.get("date"));
		System.out.println(flight.get("time"));

		try {
			st.execute(query1);
			return true;
		} catch (SQLException e) {
			System.out.print("Error in inserting Data");
			e.printStackTrace();
		}
		return false;
	}
}
