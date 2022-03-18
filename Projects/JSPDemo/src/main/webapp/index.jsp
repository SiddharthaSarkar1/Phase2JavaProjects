<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Scriptlet</h1><hr>

<h1>Hello world</h1>

<% out.println(10 + 5); %>

<%= "Welcome "+"User" %>


<br><br>
<%= 7*6 %>
<br>
<%
	out.println("Welcome User");
%>
<%= java.util.Calendar.getInstance().getTime() %><br>

<%! int value = 100; %>
<%= "Value is : "+value %><br>

<%
	int serverPort = request.getServerPort();
	out.print("Port : "+serverPort);
 
%>
<br>
<a href="implicit.jsp">Implicit</a>
<br>
<a href="index1.jsp">Index1</a>
<br>
<a href="demoservlet">DemoServlet</a>

</body>
</html>