<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sid" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h5>JSP --------------> </h5>
	<%
		String name = request.getAttribute("label").toString();
		out.println(name);
		
	%>
	<br>
	<h5>JSTL --------------> </h5>
	
	${label} 
	<br>
	<sid:out value="${label}"/>
	<br>
	
	${student}
		
	<sid:forEach items="${student}" var="s">
	
		${s}<br>
	
	</sid:forEach>

</body>
</html>