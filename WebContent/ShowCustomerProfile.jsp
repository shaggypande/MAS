<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
   <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %><br>
<div>
<%@ include file="./header.html" %>
</div>
<div style="width:100%">
<ul class="menu" style="padding-left: 240px; margin-top: 10px">
<li><a href="MainControllerServlet?Operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>Now showing movies</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>Upcoming movies</em></a></li>
</ul><br><br><br>

<h3 align="left">
<%@ include file="ShowCustomerNameHeader.jsp"%>
</h3>
<br><br>

</div>
<% User oUser=(User)request.getAttribute("user");%> 

<h3 align="center">
 Your account has been created successfully.</h3>
<table border="1" align="center" class="tabFont" style="width:400px;">

<tr><td colspan="2" align="center">Profile</td></tr>
<tr><td>User name</td><td><%=(oUser.getFirstName())%></td></tr>
<tr><td>Mobile number</td><td><%=(oUser.getMobileNo()) %></td></tr>
<tr><td>City</td><td><%=(oUser.getCity()) %></td></tr>
<tr><td>Email Id</td><td><%=(oUser.getEmailId()) %></td></tr>

</table><br><br>
<table align="center">
<tr>
   <td>
   <h3 align="center">(Your User Id and password is sent to your email Id)<br>
To use other facilities and book tickets please <a href="MainControllerServlet?Operation=homepage"><font style="color:black"><b>login</b></font></a></h3>
   
   </td>
</tr>


</table>
<br><br><br>
<br><br><br>

<%@ include file="./footer.html" %>

</body>
</html>