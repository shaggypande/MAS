<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
</head>
<body>
<%@ include file="./header.html" %>
<br>
<%User uObj1=(User)((request.getSession(false)).getAttribute("user"));%>
<%String role=uObj1.getRoleName(); %>
<%if ("SuperAdmin".equals(role) ){ %>
<%@ include file="./superadminmainmenu.jsp" %>

<%} %>
<%if("Admin".equals(role)) { %>
<%@ include file="./adminmainmenu.jsp" %>

<%} %><br><br>
<div id=footer>
<BR>
<PRE>
<a href="MainControllerServlet?Operation=underConstruction">Register Admin</a>        <a href="MainControllerServlet?Operation=underConstruction">Update Admin Details</a>          <a href="MainControllerServlet?Operation=ManageAdmin">Delete Admin</a>         <a href="MainControllerServlet?Operation=underConstruction">View Admin Details</a>
</PRE>
</div>

<BR><BR>



<h2>Please enter a correct Admin ID. <a href="MainControllerServlet?Operation=errorPage">Click here</font></a> to re-enter Admin ID.</h2>
<div><br><br>
<%@ include file="./footer.html" %>
</div>
</body>
</html>