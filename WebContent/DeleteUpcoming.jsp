<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false"  errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete movie</title>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
<link rel="stylesheet" type="text/css" href="style.css">
<script language="javascript">
function fn()
{
var MovieIDElement=document.getElementById('movieid');
var isMovieIDElement=checkEmpty(MovieIDElement);
if(!isMovieIDElement)
{
	alert('Please enter movie ID');
	MovieIDElement.focus();
	return false;
}

var idValid=onlynum(MovieIDElement);
if(!idValid)
{
	alert('Movie Id should have only numbers');
	//mobelmt.focus();
	return false;
}
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
function checkEmpty(elem)
{


var elementValue=elem.getAttribute('value');

if(elementValue!="")

{

	return true;
}

return false;

}
function onlynum(elmt)
{ 
	
	var numpattern= /^[0-9]+$/;
	var elementV=elmt.getAttribute('value');
	if(numpattern.test(elementV))
	   { 
		   
		return true;

		}
	
	
	return false;
}
</script>
</head>
<body>
<div>
<%@ include file="./header.html" %>
</div>
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
<form name=updeletemovie method="get" action="MainControllerServlet" onsubmit="return fn();" >
<h1 align=center>Delete up-coming movie</h1>
<table class=tabFont  border=5 align="center" cellpadding=5  width=40%>
<tr><td>Movie ID</td><td><input type=text name="movieid" maxlength="4"></td></tr>
<tr><td><input type="submit"  value="Delete" align="centre"></td><td><input type="reset"></td></tr>
<tr><td ><input  type="hidden" name="Operation" value="deleteupcomingmovie"></td></tr>
</table>
</form>
<div>
     <br><br>
<%@ include file="./footer.html" %>
</div>
</body>
</html>