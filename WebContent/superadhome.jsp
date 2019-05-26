<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp"%>
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
<ul class="menu">
<li><a href="MainControllerServlet?Operation=homepage"><em>logout</em></a></li>
<li class="current"><a href="MainControllerServlet?Operation=logAd"><em>Manage Admin</em></a></li>
<li><a href="MainControllerServlet?Operation=adminmovie"><em>Manage Movies </em></a></li>
</ul>
<br><br>
<br><br>
<h2>You don't have access to this page!</h2>
<%@ include file="./footer.html" %>
</body>
</html>