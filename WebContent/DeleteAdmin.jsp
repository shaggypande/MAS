<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Admin</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript" src="Validation.js"></script>
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

<%} %>
<br><br>
<div id=footer>
<BR>
<PRE>
<a href="MainControllerServlet?Operation=underConstruction">Register Admin</a>        <a href="MainControllerServlet?Operation=underConstruction">Update Admin Details</a>          <a href="MainControllerServlet?Operation=ManageAdmin">Delete Admin</a>         <a href="MainControllerServlet?Operation=underConstruction">View Admin Details</a>
</PRE>
</div>


<h1>Delete Admin</h1>
<form  action="MainControllerServlet"  method="post" onsubmit="return validateForm();">
<table class=tabFont border=5 align=center cellpadding=5 cellspacing=10 width=40%>
	<tr>
		<td>
		<b><label for="adminId">Admin ID</label></b>
		</td>
		<td align="center">
			<input type="text" name="adminId" id="adminId" >
		</td>
	</tr>

	<tr>
		<td>
			<input type="submit" name="submit" value="Submit" />
			</td>
			<td>
			<input type="reset" name="reset" value="Reset" />
		</td>
	</tr>
	
</table>

<input type="hidden" name="operation" value="DeleteAdmin" style="border: none">
</form>
<%@ include file="./footer.html" %>
</body>
</html>