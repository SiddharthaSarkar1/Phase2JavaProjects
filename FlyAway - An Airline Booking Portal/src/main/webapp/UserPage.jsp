<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background:url('BackG.jpg') no-repeat; background-size: cover; backdrop-filter: blur(5px);">

	<center>
	<a href=index.jsp style="color:brown;text-decoration:none ;font-size:35px;font-weight:bold;">FlyAway</a>
	</center>
	<br><br>
	<center>
	<h2>User Login</h2>
	<div style="border:2px solid brown;width:25%;border-radius:10px;padding:20px" align="center">
	<form action=userlogin method=post >
	    <table >
	    <tr>
	    <td><label for=email>Email</label><br></td>
	    <td><input type="email" name=email id=email /></td>
	    </tr>
	    <tr>
	    <td><label for=pass>Password</label><br></td>
	    <td><input type="password" name=password id=pass /></td>
	    </tr>
	    
	    <tr>
	    <td><input type=submit value=submit /></td>
	    </tr>
	    </table>
		
	</form>
	</div>
	</center>
	<br><br>
	<center>
	<a>New User-Create account</a>
	<h4><a href=UserRegistration.jsp style="font-size:25;color:blue;">Create Account</a></h4>
	</center>
	<center>
	<%
		String message=(String)session.getAttribute("message");
		if(message!=null){
	%>
	<p style="color:green; font-size:25px;"><%=message %></p>
	<%
			session.setAttribute("message", null);
		}
	%>
	</center>
</body>
</html>