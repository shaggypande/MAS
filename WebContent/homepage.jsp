<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Multiplex</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script language="javascript" src="MAS.js">
</script>
</head>
<body>
<%@ include file="./header.html" %>
<br>
<div style="width:100%;">
<ul class="menu" style="margin-left: 300px; margin-top: 10px">
<li><a href="MainControllerServlet?operation=homepage"><em>Home</em></a></li>
<li><a href="MainControllerServlet?operation=underConstruction"><em>Now showing movies</em></a></li>
<li><a href="MainControllerServlet?operation=underConstruction"><em>Upcoming movies </em></a></li>
</ul><br><br><br><br>
</div>
<div>
<table bordercolor="#000000" bgcolor="#000000">
<tr>
	<td>
		<br><br><br>
			<marquee direction="left" width="810px" height="500px" behavior="alternate" onmouseover="this.stop();" onmouseout="this.start();">
			<img src="./Images/wakeup.jpg" height="400px" width="300px"></img>
			<img src="./Images/leap.jpg" height="400px" width="300px"></img>
			<img src="./Images/lett.jpg" height="400px" width="300px"></img>
			<img src="./Images/yjhd.jpg" height="400px" width="300px"></img>
			</marquee>
	</td>
	<td>
			<form action="MainControllerServlet" method="post" onSubmit="return formValidation();">
			<table class=tabFont align="center">
			<tr>
				<td colspan="2" align="center">
				<img src="./Images/log.jpg"></img>
				</td>
			</tr>
			<tr>
				<td align="center" height="90">User ID</td>
				<td align="center" height="90">
				<input type=text id="userId" name="userId" >
				</td>
			</tr>
			<tr>
				<td align="center" height="90">Password</td>
				<td align="center" height="90">
				<input type=password id="password" name="password" ></td>
			</tr>
			<tr>
				<td colspan="2" align="center" height="100">
				<input type="submit" name="submit" value="LOGIN"/></td>
			</tr>
			<tr>
				<td align="center"><a href="MainControllerServlet?operation=customer">
				<font color=#FFFFFF>Register Me</font></a></td>
				<td align="center"><a href="MainControllerServlet?operation=forgotpassword">
				<font color=#FFFFFF>Forgot password?</font></a></td>
			</tr>
			<tr>
				<td>
				<input type="hidden" value="login" name="operation"></input>
				</td>
			</tr>
			</table>
			</form>
	</td>
</tr>
</table>

<br><br>
</div>

<%@ include file="./footer.html" %>
</body>
</html>