<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:url('BackG.jpg') no-repeat; background-size: cover; backdrop-filter: blur(5px);">

	<br><center>
	<a href=index.jsp style="color:brown;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
	</center>
	<br>
	
	<%
		@SuppressWarnings("unchecked")
		HashMap<String,String> user=(HashMap<String,String>)session.getAttribute("user");
		if(user==null){
			response.sendRedirect("UserPage.jsp");
		}
	%>
	<p align="center"  style="color:green;font-size:40px;font-weight:bold">Your Ticket Booked Successfully</p>

</body>
</html>