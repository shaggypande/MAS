<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
 <link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function validateForm()
{
	var fnameelmt=document.getElementById('fname');
	var fnameValid=onlyalpha(fnameelmt);
	var fnameFill=onlynull(fnameelmt);
	if(!fnameFill)
	{
		alert('First name is mandatory');
		fnameelmt.focus();
		return false;
	}
	if(!fnameValid)
	{
		alert('First name should have alphabets only');
		fnameelmt.focus();
		return false;	
	}

	
	var mnameelmt=document.getElementById('mname');
	if(mnameelmt.value.length!=0)
	{
	var mnameValid=onlyalpha1(mnameelmt);
	if(!mnameValid)
	{
		alert('middle name should have alphabets only');
		mnameelmt.focus();
		return false;	
	}
	}
	
	var lnameelmt=document.getElementById('lname');
	var lnameValid=onlyalpha(lnameelmt);
	var lnameFill=onlynull(lnameelmt);
	if(!lnameFill)
	{
		alert('Last name is mandatory');
		lnameelmt.focus();
		return false;
	}
	if(!lnameValid)
	{
		alert('Last name should have alphabets only');
		lnameelmt.focus();
		return false;	
	}
	//alert('Last name should have alphabets only');

	var addelmt=document.getElementById('address');
	var addValid=onlyalphanum(addelmt);



	//var dob=document.getElementById('date').value;
	//var dobpattern= /^[0-9]+(\-[12])(\-[1995])*$/;
	//var dobpattern=/^[12-12-1995]$/;
	//alert(dobpattern);
	//if(dob.test(dobpattern))

	//{
		//alert(dob);
	//}
	
 	var emailelmt=document.getElementById('email');
 	var emailvalid=onlyemail(emailelmt);
 	var emailFill=onlynull(emailelmt);
	if(!emailFill)
	{
		alert('Email is mandatory');
		 emailelmt.focus();
		return false;
	}
 	if(!emailvalid)
 	{
 		alert('Enter valid email id');
 		 emailelmt.focus();
		return false;

 	 }
 	var mobelmt=document.getElementById('mobile');
	var mobValid=onlynum(mobelmt);
	var mobstart=numstart(mobelmt);
	var mobl=mobelmt.value.length;
	var mobFill=onlynull(mobelmt);
	if(!mobFill)
	{
		alert('Mobile no. is mandatory');
		mobelmt.focus();
		return false;
	}
	if(!mobValid)
	{
		alert('Please enter valid number');
		mobelmt.focus();
		return false;
	}
	if(mobl!=10)
	{
		alert('Please enter 10 digit mobile number');
		mobelmt.focus();
		return false;
	}
	if(!mobstart)
	{

	alert('Please enter valid mobile no');
	return false;
	}


	var stateelmt=document.getElementById('state');
	if(stateelmt.value=="select")
	{
		alert('Please select the state');
		stateelmt.focus();
		return false;
	}

	var check1elmt=document.getElementById('check1');
	if(check1elmt.checked==true)
	{
		
		check1elmt.value="yes";
	}
	else
	{
		check1elmt.value="no";
	}


	var check2elmt=document.getElementById('check2');
	if(check2elmt.checked==true)
	{
		
		check2elmt.value="yes";
	}
	else
	{
		check2elmt.value="no";
	}
	
	
	 var check3=document.getElementById('check3');
      if(check3.checked==false)
      {
		alert('Please accept the terms and conditions');
		check3.focus();
		return false;
      }
      
	
		var con=confirm('Are you sure?');
	if(con==true)
	{
	return true;
	}
	else return  false;
	
}





//**************end validation function*******************

//******************sub functions***********************




function onlyalpha(elmt)
{
	
	var alphapattern= /^[A-Za-z]+$/; 
	var elementV=elmt.getAttribute('value');
	if(alphapattern.test(elementV))
	   {
		return true;

		}
	return false;
	
	
}

function onlyalpha1(elmt)
{
	
	var alphapattern= /^[A-Za-z]+[ ]*$/; 
	var elementV=elmt.getAttribute('value');
	if(alphapattern.test(elementV))
	   {
		return true;

		}
	return false;
	
	
}




function DateFormat(date,month,year)   
{ 
 
 if(((date.value=="30") && (month.value=="February")) || ((year.value%4!=0) && (date.value=="29")) || ((month.value=="April") && (date.value=="31")) || ((month.value=="February") && (date.value=="31")) || ((month.value=="June") && (date.value=="31"))|| ((month.value=="September") && (date.value=="31")) || ((month.value=="November") && (date.value=="31"))) 
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

function onlyalphanum(elmt)
{
	var addpattern=/^[0-9 -\/A-Za-z]+$/;
	var elementV=elmt.getAttribute('value');
	if(addpattern.test(elementV))
	{
		return true;

	}
	return false;
	
}


function onlyemail(elmt)
{
	//var emailpat=/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	//var emailpat=/^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[com]*[co])*$/;
	var emailpat= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
	var elementV=elmt.getAttribute('value');
	if(emailpat.test(elementV))
	{
	return true;
	}
	return false;
}

function onlynull(elem)
{


var elementValue=elem.getAttribute('value');

if(elementValue!="")

{

	return true;
}

return false;

}
function numstart(elmt)
{ 
var elementV=elmt.getAttribute('value');
if(elementV.charAt(0)!=9 && elementV.charAt(0)!=8 && elementV.charAt(0)!=7)
{
	return false;
}
return true;
}

//**********************end sub functions****************************
</script>
</head>

<body>
<div>
<%@ include file="./header.html" %>
</div>
<div>
<ul class="menu">
<li><a href="MainControllerServlet?Operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?Operation=upcomingMovies"><em>Upcoming Movies</em></a></li>
<li><a href="MainControllerServlet?Operation=nowshowingMovies"><em>Now Showing</em></a></li>
</ul><br><br><br><br>
</div>

<br><br><br><br>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
<%@ include file="ShowCustomerNameHeader_New.jsp"%>
<%User oUser=(User)session.getAttribute("user"); %>

<form name="edit" method="post" onsubmit="return validateForm();" onreset="true" action="MainControllerServlet">
<table border="1" align="center">
<tr><td colspan="2" align="center">Profile</td></tr>
<tr><td>Customer Id</td><td><input type="text"  value=<%= (oUser.getUserId()) %>></input></td></tr>
<tr><td>First name</td><td><input type="text" name="fname" id="fname" value=<%=(oUser.getFirstName())%>></input></td></tr>
<tr><td>Last name</td><td><input type="text" name="fname" id="fname" value=<%=(oUser.getLastName())%>></input></td></tr>
<tr><td>Mobile number</td><td><input type="text" value=<%=(oUser.getMobileNo()) %>></input></td></tr>
<tr><td>City</td><td><%=(oUser.getCity()) %></td></tr>
<tr><td>State</td><td><%=(oUser.getState()) %></td></tr>
<tr><td>Email Id</td><td><%=(oUser.getEmailId()) %></td></tr>
<tr>
<td>
<input type="submit" name="submit" value="EDIT"></input>
</td>
</tr>
</table>
 <input type="hidden" name="operation" value="editProfile">
</form>
</body>
</html>