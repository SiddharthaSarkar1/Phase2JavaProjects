<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<br><br>
	<center>
	<h2>Admin Login</h2>
	<div style="border:3px solid brown;width:25%;border-radius:10px;padding:20px" align="center">
	<form action=adminlogin method=post>
		<label for=email>Email :-</label> <input type="email" name=email id=email /><br><br>
		<label for=pass>Password :-</label> <input type="password" name=password id=pass /><br><br>
		<input type=submit value=submit />
	</form>
	</div>
	</center><br>
	<center>
	<a href=ForgotPassword.jsp style="font-size:25;color:red;">Forgot Password</a>
	</center>
	<%
		String message=(String)session.getAttribute("message");
		if(message!=null){
	%>
	<p style="color:silver;"><%=message %></p>
	<%
			session.setAttribute("message", null);
		}
	%>
</body>
</html>