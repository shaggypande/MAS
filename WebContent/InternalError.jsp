<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Internal Error</title>
<link rel="stylesheet" type="text/css" href="style.css">

</head>
<body> 
<%@ include file="./header.html" %>
<br>
<ul class="menu" style="margin-left: 300px; margin-top: 10px">
<li><a href="MainControllerServlet?Operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>Now showing movies</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>upcoming movies </em></a></li>
</ul><br><br><br><br>
<div>
<h2>Sorry, your request could not be processed due to an internal error.</h2>
<h2>Please try again after sometime.</h2></div>

<br><br>

<div>
<%@ include file="./footer.html" %>
</div>



</body>
</html>