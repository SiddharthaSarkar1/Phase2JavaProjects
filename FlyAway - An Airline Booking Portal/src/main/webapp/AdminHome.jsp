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
	<br><br>
	<a href=masterflightlist>Master Flight List</a>
	</center>
	<br><br>
	<center>
	<h1 style="color:brown;">Insert New Flight Details</h1>
	
	<div style="border:3px solid brown;width:25%;border-radius:10px;padding:20px" align="center">
	<form action=insertflight method=post>
		<label for=name>Name :-</label> <input type="text" name=name id=name /><br><br>
		<label for=Source>Source :-</label> <input type="text" name=Source id=Source /><br><br>
		<label for=Dest>Dest :-</label> <input type="text" name=Dest id=Dest /><br><br>
		<label for=departure>Departure :-</label> <input type="date" name=departure id=departure /><br><br>
		<label for=time>Time :-</label> <input type="time" name=time id=time /><br><br>
		<label for=price>Price :-</label> <input type="text" name=price id=price /><br><br>
		<input type=submit value=submit />
	</form>
	</div>
	</center>
	<center>
	<%
		String message=(String)session.getAttribute("message");
		if(message!=null){
	%>
	<p style="color:green;font-size:20px;font-weight:bold;"><%=message %></p>
	<%
			session.setAttribute("message", null);
		}
	%>
	</center>
</body>
</html>