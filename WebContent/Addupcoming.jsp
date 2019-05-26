<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add up-coming movie</title>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>

<link rel="stylesheet" type="text/css" href="style.css">
<script language="javascript">
function fn()
{
var MovieNameElement=document.getElementById('moviename');
var isMovieNameElement=checkEmpty(MovieNameElement);

var today = new Date();
var currentdd = today.getDate();
var currentmm = today.getMonth()+1; //January is 0!
var currentyyyy = today.getFullYear();
var movieName=MovieNameElement.value;
if(!isMovieNameElement )
{
	alert('Please enter the movie name');
	MovieNameElement.focus();
	return false;
}

var isMovieNameBlank=checkBlank(MovieNameElement);
if(!isMovieNameBlank)
{
	alert('Please enter the movie name');
	MovieNameElement.focus();
	return false;
}



var MovieLanguageElement=document.getElementById('language');
var isMovieLanguageElement=checkEmpty(MovieLanguageElement);
if(!isMovieLanguageElement)
{
	alert('Please select the language');
	MovieLanguageElement.focus();
	return false;
}
var MovieDateElement=document.getElementById('date');
var isMovieDateElement=checkEmpty(MovieDateElement);
if(!isMovieDateElement)
{
	alert('Please select the date');
	MovieDateElement.focus();
	return false;
}
var MovieMonthElement=document.getElementById('month');
var isMovieMonthElement=checkEmpty(MovieMonthElement);
if(!isMovieMonthElement)
{
	alert('Please select the month');
	 MovieMonthElement.focus();
	return false;
}
var MovieYearElement=document.getElementById('year');
var isMovieYearElement=checkEmpty(MovieYearElement);
if(!isMovieYearElement)
{
	alert('Please select the Year');
	MovieYearElement.focus();
	return false;
}
var isDateValid=DateFormat(MovieDateElement,MovieMonthElement,MovieYearElement,currentdd,currentmm,currentyyyy);
if(!isDateValid)
{
	alert('Please select valid date');
	MovieDateElement.focus();
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

return true;
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

function checkBlank(elem)
{
	var elementValue=elem.getAttribute('value');
  for(var i=0;i<elem.value.length;i++)
	{
		if(elementValue.charAt(i)!=' ')
			return true;
		
		}

	return false;

	
}






function DateFormat(date,month,year,currentdd,currentmm,currentyyyy)   
{ 

	 if(month.value=="January")
	 {
		 var m=1;
	 }
	 else if(month.value=="February")
	 {
		 var m=2;
	 }
	 else if(month.value=="March")
	 {
		 var m=3;
	 }
	 else if(month.value=="April")
	 {
		 var m=4;
	 }
	 else if(month.value=="May")
	 {
		 var m=5;
	 }
	 else if(month.value=="June")
	 {
		 var m=6;
	 }
	 else if(month.value=="July")
	 {
		 var m=7;
	 }
	 else if(month.value=="August")
	 {
		 var m=8;
	 }
	 else if(month.value=="September")
	 {
		 var m=9;
	 }
	 else if(month.value=="October")
	 {
		 var m=10;
	 }
	 else if(month.value=="November")
	 {
		 var m=11;
	 }
	 else if(month.value=="December")
	 {
		 var m=12;
	 }
 if(((date.value=="30") && (month.value=="February")) || ((year.value%4!=0) && (date.value=="29")&&(month.value=="February")) || ((month.value=="April") && (date.value=="31")) || ((month.value=="February") && (date.value=="31")) || ((month.value=="June") && (date.value=="31"))|| ((month.value=="September") && (date.value=="31")) || ((month.value=="November") && (date.value=="31"))) 
{
               return false; 
}
 
 if(year.value<currentyyyy)
 {
	 return false;
 }
 
 else if(year.value==currentyyyy)
	 {
	 	if(m<(currentmm))
			 {
			return false;
			 }
	 	 else if(m==currentmm)
		 {
			 if(date.value<=currentdd)
			 {
				 return false;
			 }
			 else
			 {
				 return true;
			 }
		 }
	 	else
	 	{
		 	return true;
	 	}	
	 }
 else
	 {
	 return true;
     }
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
<%@ include file="/superadminmainmenu.jsp" %>

<%} %>
<%if("Admin".equals(role)) { %>
<%@ include file="/adminmainmenu.jsp" %>

<%} %><BR><BR>

<div id=footer>
<BR><pre> <a href="MainControllerServlet?Operation=addup">Add upcoming movie</a>     <a href="MainControllerServlet?Operation=underConstruction">Update upcoming movie</a>     <a href="MainControllerServlet?Operation=show">View upcoming movies</a>     <a href="MainControllerServlet?Operation=delup">Delete upcoming movie</a></pre>
</div>
<br><br>

<form name=upaddmovie method="post" action="MainControllerServlet" onsubmit="return fn();" >
<h1 align=center>Add up-coming movie</h1>
<table class=tabFont border=5 align=center cellpadding=5  width=70%>
<tr><td><label for="moviename">Movie name</label></td><td><input type=text name="moviename"></td></tr>
<tr><td><label for="language">Movie language</label></td><td><select name="language">
<option value="">-Select language-</option>
<option value="English">English</option>
<Option value="Hindi">Hindi</Option>
<Option value="Marathi">Marathi</Option>
<Option value="Tamil">Tamil</Option>
<option value="Telugu">Telugu</option>
</select>
</td></tr>
<tr><td>
Release date</td>		<td><select name="date" id="4">
				<option value="">Date</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				<option value="13">13</option>
				<option value="14">14</option>
				<option value="15">15</option>
				<option value="16">16</option>
				<option value="17">17</option>
				<option value="18">18</option>
				<option value="19">19</option>
				<option value="20">20</option>
				<option value="21">21</option>
				<option value="22">22</option>
				<option value="23">23</option>
				<option value="24">24</option>
				<option value="25">25</option>
				<option value="26">26</option>
				<option value="27">27</option>
				<option value="28">28</option>
				<option value="29">29</option>
				<option value="30">30</option>
				<option value="31">31</option>
			</select>
			
		<select name="month" id="5">
				<option value="">Month</option>
				<option value="January">January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>
			</select>
	<%
   Date dNow = new Date();
   SimpleDateFormat ft = new SimpleDateFormat ("yyyy");
   int year=Integer.parseInt(ft.format(dNow));
     %>
		
				<select name="year" id="2">
				<option value="">Year</option>
				<option value="<%= year %>" > <%= year %> </option>
				<option value="<%= year+1 %>" > <%= year+1 %></option>
				<option value="<%= year+2 %>" > <%= year+2 %></option>
				<option value="<%= year+3 %>" > <%= year+3 %></option></select></td></tr>

<tr><td><input type="submit"  value="Add movie"></td><td><input type="reset"></td></tr>
<tr><td><input type="hidden" name="operation" value="addupcomingmovie"></td></tr>
</table>
</form><br><br><br><br>

    
<%@ include file="./footer.html" %>

</body>
</html>