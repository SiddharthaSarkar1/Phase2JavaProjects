<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@ page import="com.productdetails.Product"%>    

<%
 Product productDet = (Product) session.getAttribute("product");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1 style="color:blue;">   Product Details  </h1><hr><hr>
	<table border='2px' style="width:100%;">
	<thead>
	<tr style="color:brown;">
	<th>Id</th>
	<th>Name</th>
	<th>Price</th>
	<th>Dated On</th>
	</tr>
	</thead>
	<tbody align="center">
	<tr>
	<td><%= productDet.getId() %></td>
	<td><%= productDet.getName() %></td>
	<td><%= productDet.getPrice() %></td>
	<td><%= productDet.getDate() %></td>
	</tr>
	</tbody>
	</table>
	</div>
</body>
</html>