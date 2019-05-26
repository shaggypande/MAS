<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.ghy.G06.beans.UpcominMovie" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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


<br><br>
<h2 align=center>Movie added with following details</h2>


<%UpcominMovie upcomingmovie=(UpcominMovie)request.getAttribute("movie"); %>
<table class=tabFont border=5 align=center cellpadding=5 cellspacing=5 width=100 style="width:400px" >
<tr><th>Movie Name </th><td> <%= (upcomingmovie.getMovieName())%></td></tr>
<tr><th>Movie ID </th><td> <%= (upcomingmovie.getMovieId())%></td></tr>
<tr><th>Movie Release Date </th><td> <%= (upcomingmovie.getCalenderDate())%></td></tr>
<tr><th>Movie Language </th><td> <%= (upcomingmovie.getMovieLanguage())%></td></tr>
</table>
<div>
     <br><br><br><br><br><br>
<%@ include file="./footer.html" %>
</div>
</body>
</html>		