<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body  style="background:url('BackG.jpg') no-repeat; background-size: cover; backdrop-filter: blur(5px);">
	<center>
	<a href=index.jsp style="color:brown;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
	<br><br>

	<div style="border:3px solid brown;width:25%;border-radius:20px;padding:20px" align="center">
	<form action=forgotpassword method=post>
		<label for=email>Email :-</label> <input type="email" name=email id=email /><br><br>
		<label for=pass>New Password :-</label> <input type="password" name=password id=pass /><br><br>
		<input type=submit value=submit />
	</form>
	</div>
	</center>

</body>
</html>