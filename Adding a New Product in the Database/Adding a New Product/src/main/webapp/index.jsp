<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
		<h1 align="center" style="color: blue">Enter Product Details</h1>
		<hr>
		
		<form action="adddata" method="post">
		<fieldset>
		<h3 align="center">Product Name: <input type="text" name="name" /></h3>
		<h3 align="center">Product Price: <input type="text" name="price" /></h3>
		<h3 align="center">Product Quantity: <input type="text" name="quantity" /></h3>
		<h2 align="center"><input type="submit" value="Save" /></h2>
		</fieldset>
		</form>
		</tr>
	</table>

</body>
</html>