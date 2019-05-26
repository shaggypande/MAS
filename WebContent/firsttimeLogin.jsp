<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="false"  errorPage="SessionInactive.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multiplex- Reset Your Password</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script language="javascript" src="changePasswordValidation.js">
</script>
</head>
<body>

<%@ include file="./header.html" %>
<br>
<ul class="menu" style="margin-left: 300px; margin-top: 10px">
<li><a href="MainControllerServlet?Operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>Now showing movies</em></a></li>
<li><a href="MainControllerServlet?Operation=underConstruction"><em>Upcoming movies </em></a></li>
</ul><br><br><br><br>
<div align="center"><b>Welcome, you are logging in first time.<br>
Please change your password and log in again!</b></div>
<div>

<br><br>

<form action="MainControllerServlet" method="post" onSubmit="return Validation();"> 
<table class=tabFont align="center">
	<tr>
		<td colspan="2" align="center">Password should contain 7-12 characters</td>
		
	</tr>
	<tr>
		<td align="center" height="90">Choose a password<font color="red">*</font>:</td>
		<td align="center" height="90"><br>
		<input type="password" id="password1" name="password1"><BR><br>
		
		</td>
	</tr>
	<tr>
		<td align="center" height="90">Re-enter your password<font color="red">*</font>:</td>
		<td align="center" height="90">
		<input type="password" id="password2" name="password2">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" height="100">
		<input type="submit" name="submit" value="CHANGE"/>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" height="100">
		<input type="reset" name="reset" value="RESET"/>
		</td>
	</tr>
	<tr>
		<td><input type="hidden" value="choosePassword" name="operation"></input></td>	
	</tr>
</table>
</form>
</div>

<div>
<%@ include file="./footer.html" %>
</div>

</body>
</html>