<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
</head>
<body>
<%@ include file="./header.html" %>
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

<H1>Welcome</H1>
<DIV>
<BR><BR><BR><BR><BR><BR><BR><BR>
<%@ include file="./footer.html" %>

</DIV>
</body>

</html>