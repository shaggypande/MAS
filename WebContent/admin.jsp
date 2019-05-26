<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Administrator-Homepage</title>
</head>
<body>
<%@ include file="./header.html" %>
<div>
<ul class="menu">
<li class="current"><a href="MainControllerServlet?Operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?Operation=nowshowing"><em>Now Showing Movies</em></a></li>
<li><a href="MainControllerServlet?Operation=upcoming"><em>Upcoming Movies</em></a></li>
<li><a href="MainControllerServlet?Operation=contactus"><em>Contact Us</em></a></li>
</ul>

</div>
<br><br><br><br>
<div>

<ul class="menu1">
<li class="current"><a href="DeleteAdmin.jsp"><em>Delete Admin</em></a></li>
<li><a href="nowshowing.html"><em>Add Upcoming Movie</em></a></li>
<li><a href="comingsoon.html"><em>Customer Details</em></a></li>

</ul>
</div>
</body>
</html>