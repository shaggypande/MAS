<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.ghy.G06.beans.UpcominMovie" %>
    <%@ page import="java.util.*" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Upcoming</title>
<link rel="stylesheet" type="text/css" href="style.css">
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

<%} %><BR><BR>

<div id=footer>
<BR><pre> <a href="MainControllerServlet?Operation=addup">Add upcoming movie</a>     <a href="MainControllerServlet?Operation=underConstruction">Update upcoming movie</a>     <a href="MainControllerServlet?Operation=show">View upcoming movies</a>     <a href="MainControllerServlet?Operation=delup">Delete upcoming movie</a></pre>
</div>



<%ArrayList<UpcominMovie> oupcoming=(ArrayList<UpcominMovie>)request.getAttribute("movie2"); %>
<h1 align=center>Upcoming Movies</h1>
<table class=tabFont border=5 align=center cellpadding=5 cellspacing=5 width=100 style="width:800px" >

<tr><td>S.No</td><td>Movie name</td><td>Movie ID</td><td>Release date</td><td>Language</td></tr>

<%for(int i=0;i<oupcoming.size();i++) %><%{ %><%UpcominMovie oupcoming1= oupcoming.get(i); %><tr>
<td><%=i+1 %></td>
<td> <%= (oupcoming1.getMovieName())%></td>
<td> <%= (oupcoming1.getMovieId())%></td>
<td> <%= (oupcoming1.getCalenderDate())%></td>
<td> <%= (oupcoming1.getMovieLanguage())%></td></tr>


<%} %></table>
<br><br><br><br><br><br><br><br><br><br><br><br>
     
<%@ include file="./footer.html" %>

</body>
</html>