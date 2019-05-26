<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>No Access Page</title>
</head>
<body>
<%@ include file="./header.html" %>
<br>
<br>
<ul class="menu">
<li><a href="MainControllerServlet?Operation=homepage"><em>Home</em></a></li>
<li  class="current"><a href="MainControllerServlet?Operation=homenoacc"><em>Manage Admin</em></a></li>
<li><a href="MainControllerServlet?Operation=homenoaccmovies"><em>Manage Movies </em></a></li>
</ul>
<br><br>
<br><br>
<div>
<h2>You don't have access to this page!</h2></div>
<%@ include file="./footer.html" %>
</body>
</html>