<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
<style>
  h1 {color:Black;}
  p {color:blue;}
</style>
</head>

<body style="background:url('BackG.jpg') no-repeat; background-size: cover; backdrop-filter: blur(5px);">
<center>
<h1 style="color:brown">FlyAway</h1>
</center>

<div align="right">
<a href="AdminPage.jsp">Admin Login</a>
</div>

<%
	@SuppressWarnings("unchecked")
	HashMap<String,String> user=(HashMap<String,String>)session.getAttribute("user");
	if(user!=null){
%>
<p style="text-align:center;color:green;font-size:20px;font-weight:bold;">Welcome <%=user.get("name") %></p>
<a href="logout">Logout</a>
<%
	}else{
%>
<a href=UserPage.jsp>User Login</a>
<%
	}
%>
<br><br>
<center>
<div style="border:3px solid brown;width:25%;border-radius:10px;padding:15px" align="center">
<form action=flightlist method=post>
	<h3>Search for Flights</h3> <br>
	<p>
		<label for=Source>Source :-</label> 
		<input type=text name=Source id=Source/><br><br>
		<label for=Dest>Destination :-</label> 
		<input type=text name=Dest id=Dest/><br><br>
		<label for=departure>Departure :-</label> 
		<input type=date name=departure id=departure/><br><br>
		<label for=travellers>Travellers :-</label> 
		<input type=number name=travellers id=travellers/><br><br>
		<input type=submit value=Search />
	</p>
</form>
</div>
</center>
</body>
</html>