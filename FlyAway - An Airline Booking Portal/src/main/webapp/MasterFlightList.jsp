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
	<center>
	<br>
	<a href=index.jsp style="color:brown;text-decoration:none;font-size:35px;font-weight:bold;">FlyAway</a>
	<br><br>
	<%
		@SuppressWarnings("unchecked")
		List<String[]> flights=(List<String[]>)session.getAttribute("flights");
		if(flights!=null){
	%>
	
	<h1 style="color:brown;">Master list of available flights</h1>
	
	<table border="2">
	<tr>
		<th>Name</th>
		<th>Source</th>
		<th>Destination</th>
		<th>Date</th>
		<th>Time</th>
		<th>Price</th>
	</tr>
	
	
	<%
		
		for(String[] flight:flights){
	%>
	
	<tr>
	<td><%=flight[0]%></td>
	<td><%=flight[1]%></td>
	<td><%=flight[2]%></td>
	<td><%=flight[3]%></td>
	<td><%=flight[4]%></td>
	<td><%=flight[5]%></td>
	</tr>
	
	<%
		}
	
	%>
	</table>
	
	
	<%
		}
		else{
	%>
	<h1>There are no available flights</h1>
	<%
		}
	%>
</center>
</body>
</html>