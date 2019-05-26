<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<script language="javaScript" type="text/javascript" src="calendar.js"></script>
   <link href="calendar.css" rel="stylesheet" type="text/css">
      <link href="style.css" rel="stylesheet" type="text/css">
   
<script type="text/javascript">

function Formvalid()
{
	var fnameelmt=document.getElementById('fname');
	var fnameValid=onlyalpha(fnameelmt);
	if(!fnameValid)
	{
		alert('First name should have alphabets only');
		return false;
		
	}
	

	var lnameelmt=document.getElementById('lname');
	var lnameValid=onlyalpha(lnameelmt);
	if(!lnameValid)
	{
		alert('Last name should have alphabets only');
		return false;
		
		
	}
	//alert('Last name should have alphabets only');
	
	var mobelmt=document.getElementById('mobile');
	var mobValid=onlynum(mobelmt);
	var mobl=mobelmt.value.length;
	
	if(!mobValid)
	{
		alert('mobile number should have numbers only');
		//mobelmt.focus();
		return false;
	}
	if(mobl!=10)
	{
		alert('Please enter 10 digit mobile number');
		return false;
	}
	
	
	
 	var emailelmt=document.getElementById('email');
 	var emailvalid=onlyemail(emailelmt);
 	if(!emailvalid)
 	{
 		alert('Enter valid email id');
		return false;

 	 }

	confirm('Are you sure?');
	return true;	
}

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
	//alert('fgdfmobile number should have alphabets only');
	
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
	var emailpat= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
	var elementV=elmt.getAttribute('value');
	if(emailpat.test(elementV))
	{
	return true;
	}
	return false;
}

</script>
</head>
<body bgcolor=navyblue>
<div>
<%@ include file="./header.html" %>
</div>
<div>
<ul class="menu">
<li><a href="home.html"><em>Home</em></a></li>
<li><a href="nowshowing.html"><em>Now Showing Movies</em></a></li>
<li><a href="comingsoon.html"><em>Upcoming Movies</em></a></li>
<li><a href="contact.html"><em>Contact Us</em></a></li>
</ul>
</div>
<%--<div align=center style="height:60%;width=100%;"--%><br>
<form name="reg" method="post" onsubmit="return Formvalid();" action="MainControllerServlet">

     <table class=tabFont align="center" border="1" >
     <tr>
        <h6>
           Fields marked with star(*) are mandatory
        </h6>
     
     </tr>
        <tr>
           <td>
           First Name*:
           </td>
          <td>
          <input type="text" name="fname" id="fname">
          </td>
        </tr>
         <tr>
           <td>
         Middle Name:
           </td>
          <td>
          <input type="text" name="mname" id="mname">
          </td>
        </tr>
        <tr>
           <td>
           Last Name*:
           </td>
          <td>
          <input type="text" name="lname" id="lname">
          </td>
        </tr>
        
        <tr>
           <td>
           Address:
           </td>
          <td>
          <input type="text" name="Address" id="address">
          </td>
        </tr>
        <tr>
           <td>
           Gender*:
           </td>
          <td>
          <input type="radio" name="gender" id="gender" value="Male"checked>Male
          <input type="radio" name="gender" id="gender" value="Female">Female
          <input type="radio" name="gender" id="gender" value="Other">Other
          
          </td>
        </tr>
        <tr>
           <td>
           Date of birth*:
           </td> <td><input type="text" name="date"><a href="#" onClick="setYears(1947, 1995);
       showCalender(this, 'date');">
      <img src="calender.png"></a>


	
    <!-- Calender Script  --> 

    <table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
	          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));" id="selectMonth">
	              <option value="0">Jan</option>
	              <option value="1">Feb</option>
	              <option value="2">Mar</option>
	              <option value="3">Apr</option>
	              <option value="4">May</option>
	              <option value="5">Jun</option>
	              <option value="6">Jul</option>
	              <option value="7">Aug</option>
	              <option value="8">Sep</option>
	              <option value="9">Oct</option>
	              <option value="10">Nov</option>
	              <option value="11">Dec</option>
	          </select>
            </td>
            <td colspan="2" align="center">
			    <select onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
				</select>
			</td>
            <td align="center">
			    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>
    </td>
   
         </tr>
       
        <tr>
           <td>
         	EmailId*:
           </td>
          <td>
          <input type="text" name="email" id="email">
          </td>
        </tr>
        <tr>
           <td>
			Mobile Number*:
           </td>
          <td>
          <input type="text" name="mobile" id="mobile">
          </td>
        </tr>
        <tr>
          <td>
           State:
          </td>
            <td>   
          <select name="state" id="state">
		<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
		<option value="Andhra Pradesh">Andhra Pradesh</option>
		<option value="Arunachal Pradesh">Arunachal Pradesh</option>
		<option value="Assam">Assam</option>
		<option value="Bihar">Bihar</option>
		<option value="Chandigarh">Chandigarh</option>
		<option value="Chhattisgarh">Chhattisgarh</option>
		<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
		<option value="Daman and Diu">Daman and Diu</option>
		<option value="Delhi">Delhi</option>
		<option value="Goa">Goa</option>
		<option value="Gujarat">Gujarat</option>
		<option value="Haryana">Haryana</option>
		<option value="Himachal Pradesh">Himachal Pradesh</option>
		<option value="Jammu and Kashmir">Jammu and Kashmir</option>
		<option value="Jharkhand">Jharkhand</option>
		<option value="Karnataka">Karnataka</option>
		<option value="Kerala">Kerala</option>
		<option value="Lakshadweep">Lakshadweep</option>
		<option value="Madhya Pradesh">Madhya Pradesh</option>
		<option value="Maharashtra">Maharashtra</option>
		<option value="Manipur">Manipur</option>
		<option value="Meghalaya">Meghalaya</option>
		<option value="Mizoram">Mizoram</option>
		<option value="Nagaland">Nagaland</option>
		<option value="Orissa">Orissa</option>
		<option value="Pondicherry">Pondicherry</option>
		<option value="Punjab">Punjab</option>
		<option value="Rajasthan">Rajasthan</option>
		<option value="Sikkim">Sikkim</option>
		<option value="Tamil Nadu">Tamil Nadu</option>
		<option value="Tripura">Tripura</option>
		<option value="Uttaranchal">Uttaranchal</option>
		<option value="Uttar Pradesh">Uttar Pradesh</option>
		<option value="West Bengal">West Bengal</option>
		</select>
          
            </td>
        </tr>
        <tr>
           <td>
           City*:
           </td>
         <td>
         <select name="city" > 
         <option>--Select--</option><option>Ahmedabad</option><option>Aurangabad</option><option>Mumbai</option><option>Nagpur</option><option>Hyderabad</option><option>Delhi</option><option>Guwahati</option><option>Trivendrum</option><option>Bhopal</option><option>Kochi</option><option>Bangalore</option><option>Patana</option>
         </select>
         
         </td>
        </tr>
        <tr>
          <td>
               <input type="checkbox" name=check1>Send me weekly news and events
          </td>
         </tr>
         <tr>
            <td>
              <input type="checkbox" name=check2>Send me offer letters
            </td>
         </tr>
         <tr>
          <td>
             <input type="submit" name="submit" value="submit" >
          </td>
          <td>
             <input type="reset" value="Clear"></input>
          </td>
        </tr>
     </table>
     <input type="hidden" name="operation" value="addcustomer">
     </form>
     </div>
     <div>
     <br><br>
<%@ include file="./footer.html" %>
</div>
</body>
</html>