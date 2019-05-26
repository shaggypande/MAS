<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add up-coming movie</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script language="javascript">
function fn()
{
var MovieNameElement=document.getElementById('moviename');
var isMovieNameElement=checkEmpty(MovieNameElement);
if(!isMovieNameElement)
{
	alert('Movie name field should not be empty');
	MovieNameElement.focus();
	return false;
}
var MovieLanguageElement=document.getElementById('language');
var isMovieLanguageElement=checkEmpty(MovieLanguageElement);
if(!isMovieLanguageElement)
{
	alert('Language field should not be empty');
	MovieLanguageElement.focus();
	return false;
}
var MovieDateElement=document.getElementById('date');
var isMovieDateElement=checkEmpty(MovieDateElement);
if(!isMovieDateElement)
{
	alert('Date field should not be empty');
	MovieDateElement.focus();
	return false;
}
var MovieMonthElement=document.getElementById('month');
var isMovieMonthElement=checkEmpty(MovieMonthElement);
if(!isMovieMonthElement)
{
	alert('Month field should not be empty');
	 MovieMonthElement.focus();
	return false;
}
var MovieYearElement=document.getElementById('year');
var isMovieYearElement=checkEmpty(MovieYearElement);
if(!isMovieYearElement)
{
	alert('Year field should not be empty');
	MovieYearElement.focus();
	return false;
}
var isDateValid=DateFormat(MovieDateElement,MovieMonthElement,MovieYearElement);
if(!isDateValid)
{
	alert('Date is not valid');
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

function DateFormat(date,month,year)   
{ 
 
 if(((date.value=="30") && (month.value=="February")) || ((year.value%4!=0) && (date.value=="29")&&(month.value=="February")) || ((month.value=="April") && (date.value=="31")) || ((month.value=="February") && (date.value=="31")) || ((month.value=="June") && (date.value=="31"))|| ((month.value=="September") && (date.value=="31")) || ((month.value=="November") && (date.value=="31"))) 
{
   
     
        return false; 
 }
 else{
	 return true;
     }
}

</script>
</head>

<body>
<div>
<%@ include file="./header.html" %>
</div>
<ul class="menu">
<li><a href="MainControllerServlet?Operation=homepage"><em>LOGOUT</em></a></li>
<li ><a href="MainControllerServlet?Operation=superad"><em>Manage Admin</em></a></li>
<li class="current"><a href="MainControllerServlet?Operation=superadminmovie"><em>Manage Movies </em></a></li>
</ul>
<br><br>
<%@ include file="./superadminmoviemenu.jsp" %>
<form name=upaddmovie method="post" action="MainControllerServlet" onsubmit="return fn();" >
<h1 align=center>Add up-coming movie</h1>
<table class=tabFont border=5 align=center cellpadding=5  width=40%>
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
		
			
		<select name="year" id="2">
				<option value="">Year</option>
				<option value="2013">2013</option>
				<option value="2014">2014</option>
				<option value="2016">2016</option></select></td></tr>
<tr><td>Upload movie poster</td><td><input type="file" name="pic" accept="image/*"></td></tr>

<tr><td><input type="submit"  value="Add movie"></td><td><input type="reset"></td></tr>
<tr><td><input type="hidden" name="operation" value="addupcomingmovie"></td></tr>
</table>
</form><br><br><br><br>

    
<%@ include file="./footer.html" %>

</body>
</html>