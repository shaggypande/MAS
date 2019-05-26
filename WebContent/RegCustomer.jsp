<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>


<script language="javaScript" type="text/javascript" src="calendar.js"></script>
<script language="javaScript" type="text/javascript" src="MAS.js"></script>
   <link href="calendar.css" rel="stylesheet" type="text/css">
      <link href="style.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript">


</script>
</head>
<body>
<div style="width:100%;">
<%@ include file="./header.html" %>
</div>
<div style="width:100%;">
<ul class="menu" style="margin-left: 200px; margin-top: 10px">
<li><a href="MainControllerServlet?operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?operation=underConstruction"><em>Now showing movies</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>Upcoming movies</em></a></li>
</ul><br><br><br><br>
</div>
<center><h2>Customer Registration</h2></center>
<br>
<div style="float:center">
<form name="reg" method="post" onsubmit="return validateForm();" onreset="true" action="MainControllerServlet">

     <table border="1" align="center" class="tabFont" style="width:350px;">
     <tr>
     	<td colspan="2" align="center">
           Fields marked with star(<b style="color:red">*</b>) are mandatory
     	</td>
     </tr>
        <tr>
           <td align="center">
           First Name <b style="color:red">*</b>:
           </td>
          <td align="center">
          <input type="text" name="firstName" maxlength="20" id="firstName">
          </td>
        </tr>
         <tr>
           <td align="center">
         Middle Name:
           </td>
          <td align="center">
          <input type="text" name="middleName" maxlength="20" id="middleName">
          </td>
        </tr>
        <tr>
           <td align="center">
           Last Name<b style="color:red">*</b>:
           </td>
          <td align="center">
          <input type="text" name="lastName" maxlength="20" id="lastName">
          </td>
        </tr>
     
        <tr>
           <td align="center">
           Address:
           </td>
          <td align="center">
          <input type="text" name="address" maxlength="200" id="address">
          </td>
        </tr>
        <tr>
           <td align="center">
           Gender<b style="color:red">*</b>:
           </td>
          <td>
          <input type="radio" name="gender" id="gender" value="Male"checked>Male
          <input type="radio" name="gender" id="gender" value="Female">Female
          <input type="radio" name="gender" id="gender" value="Other">Other
          
          </td>
        </tr>
        <tr>
           <td align="center">
           Date of birth<b style="color:red">*</b>:
           
           </td> 
           <td align="center"><input type="text" size="16" readonly name="date"><a  href="#" onClick="setYears(1947, 1995); 
               showCalender(this, 'date');">
      <img src="calender.png"></a>


	
    <!-- Calender Script  --> 

    <table id="calenderTable" align="center">
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
			    <a href="#" onClick="closeCalender();"><font color="#FFFFFF" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr>
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>
    </td>
    </tr>
       
        <tr>
           <td align="center">
         	EmailId<b style="color:red">*</b>:
           </td>
          <td align="center">
          <input type="text" name="email" maxlength=30 id="email">
          </td>
        </tr>
        <tr>
           <td align="center">
			Mobile Number<b style="color:red">*</b>:
           </td>
          <td>
         +91<input type="text" name="mobile" id="mobile" maxlength="10">
          </td>
        </tr>
        <tr>
          <td align="center">
           State<b style="color:red">*</b>:
          </td>
           <td align="center">
          <SELECT onchange=changeCity(this) size="1" id="state" name="state"> 
				<OPTION selected value="Select State">Select State</OPTION>
				<OPTION value="andhrapradesh">Andhra Pradesh</OPTION>
				<OPTION value="assam">Assam</OPTION>
				<OPTION value="gujarat">Gujarat</OPTION>
				<OPTION value="madhyapradesh">Madhya Pradesh</OPTION>
				<OPTION value="maharashtra">Maharashtra </OPTION>
				<OPTION value=punjab>Punjab  </OPTION>            
          </SELECT> </td>
        </tr>
        <tr>
           <td align="center">
           City<b style="color:red">*</b>:
           </td>
         <td align="center">
        <SELECT size="0" name="city"> 
				<OPTION selected>Select City</option>
          </SELECT> 
         </td>
        </tr>
      
        <tr>
          <td colspan="2">
               <input type="checkbox" name="check1" id="check1" >Send me weekly news and events
          </td>
        </tr>
        <tr>
            <td colspan="2">
              <input type="checkbox" name="check2" id="check2">Send me offer letters
            </td>
         </tr>
          <tr>
          <td colspan="2">
               <input type="checkbox" name="check3" id="check3">I accept the <a href="t_and_c.jsp">Terms and conditions</a> 
          </td>
         </tr>
         <tr>
          <td colspan="2">
             <input  type="submit" name="submit" value="Submit">
        
            <input  type="button" onclick="parent.history.back()" value="Cancel">
          
             <input  type="reset" value="Clear"></input>
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