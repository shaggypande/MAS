<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.tcs.ilp.ghy.G06.beans.UpcominMovie" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
<script language="javascript">
function fn()
{
	var resp=confirm("Are you sure?");
	if (resp)
	{
	var nm=upaddmovie.moviename.value;

	return true;
	}
	else
	{
	alert("Canceled");
	return false;
	}
}
</script>
</head>

<body>

<div>
<%@ include file="./header.html" %>
</div>
<%if(request.getSession(false)!=null)
{
User uObj1=(User)((request.getSession(false)).getAttribute("user"));%>
<%String role=uObj1.getRoleName(); %>
<%if ("SuperAdmin".equals(role) ){ %>
<%@ include file="./superadminmainmenu.jsp" %>

<%} %>
<%if("Admin".equals(role)) { %>
<%@ include file="./adminmainmenu.jsp" %>

<%}
}%><BR><BR>

<div id=footer>
<BR><pre> <a href="MainControllerServlet?Operation=addup">Add upcoming movie</a>     <a href="MainControllerServlet?Operation=underConstruction">Update upcoming movie</a>     <a href="MainControllerServlet?Operation=show">View upcoming movies</a>     <a href="MainControllerServlet?Operation=delup">Delete upcoming movie</a></pre>
</div>



<h3 align=center>Movie present with following details</h3>

<%
if(request.getSession(false)!=null)
{
UpcominMovie upcomingmovie=(UpcominMovie)session.getAttribute("movie"); %>
<form name=updeletemovie method="post" action="MainControllerServlet" onsubmit="return fn();" >
<table class=tabFont border=5 align=center cellpadding=5 cellspacing=5 width=100 style="width:400px" %>
<tr><th>Movie Name </th><td> <%= (upcomingmovie.getMovieName())%></td></tr>
<tr><th>Movie ID </th><td> <%= (upcomingmovie.getMovieId())%></td></tr>
<tr><th>Movie Release Date </th><td> <%= (upcomingmovie.getCalenderDate())%></td></tr>
<tr><th>Movie Language </th><td> <%= (upcomingmovie.getMovieLanguage())%></td></tr>
<tr><td></td><td ><input type="hidden" name="operation" value="deleteupcomingmovie1"></td></tr>

<tr><td colspan=2 align=center><input type="submit"  value="Delete movie"></td></tr></table></form>
<%} %>



     <br><br>
<%@ include file="./footer.html" %>



</body>
</html>