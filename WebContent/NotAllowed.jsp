<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>No Access Page</title>
<script type="text/javascript">

function notAllowed()
{
alert("Action not allowed");
window.location="<%=request.getContextPath()%>/MainControllerServlet?Operation=okAtDisplay";	
}


</script>


</head>
<body onLoad="return notAllowed()">
<%@ include file="./header.html" %>
<br>
<ul class="menu">
<li><a href="MainControllerServlet?Operation=homepage"><em>logout</em></a></li>
<li><a href="MainControllerServlet?Operation=noaccesstoadmin"><em>Manage Admin</em></a></li>
<li><a href="MainControllerServlet?Operation=superadminmovie"><em>Manage Movies </em></a></li>
</ul>
<br><br>
<br><br>

<%@ include file="./footer.html" %>
</body>
</html>