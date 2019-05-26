<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="./header.html" %>
<link href="style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>

</head>
<body>
<div style="height:20%;">
<ul class="menu" style="margin-left: 90px; margin-top: 10px">
<li><a href="MainControllerServlet?Operation=bookTicket"><em>Book tickets</em></a></li>
<li><a href="MainControllerServlet?Operation=newsAndEvents"><em>News and Events</em></a></li>
<li><a href="MainControllerServlet?Operation=showProfileNew"><em>Profile</em></a></li>
<li><a href="MainControllerServlet?Operation=homepage"><em>Logout</em></a></li>
</ul>
<br>
</div>

 <br>
<%@ include file="ShowCustomerNameHeader_New.jsp"%>
<br><br>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>

<div style="float:right;color:black;">

</div>
<div  style="height:50%;">
<table border="1" class="tabFont" align="center">
<tr><td colspan=2 align=center>Profile</td></tr>
<%if(request.getSession(false)!=null) {
	User oUser=(User)((session).getAttribute("user"));
%>
<tr><td>Customer Id</td><td><%= (oUser.getUserId()) %></td></tr>
<tr><td>User name</td><td><%=(oUser.getFirstName())%></td></tr>
<tr><td>Mobile number</td><td><%=(oUser.getMobileNo()) %></td></tr>
<tr><td>City</td><td><%=(oUser.getCity()) %></td></tr>
<tr><td>State</td><td><%=(oUser.getState()) %></td></tr>
<tr><td>Email Id</td><td><%=(oUser.getEmailId()) %></td></tr>
<%} %>
</table>
<center><a href="MainControllerServlet?Operation=editProfile" style="text-decoration:none"><font color="#000000" size="4"><b>[Edit Profile]</b></font></a></center>

</div>
<div  style="height:10%;">
<br><br><br><br>
<%@ include file="./footer.html" %>
</div>
</body>
</html>