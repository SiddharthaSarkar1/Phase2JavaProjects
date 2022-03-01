<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1 style="color:green;">    ::    Enter Product Details   ::    </h1><hr>
	<form action="submitservlet" method="post">
	<label>Product Id : </label>
	<input type="text" name="Id" placeholder="Enter Product Id"><br><br>
	<label>Product name : </label>
	<input type="text" name="name" placeholder="Enter Product name"><br><br>
	<label>Product price : </label>
	<input type="text" name="price" placeholder="Enter Price"><br><br>
	<label>Date : </label>
	<input type="text" name="date" placeholder="Enter Date"><br><br>
	<input type="submit" value="Submit">
	</form>
	</div>
</body>
</html>