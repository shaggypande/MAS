<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isErrorPage="false"  errorPage="SessionInactive.jsp"%>
<%@ page import="com.tcs.ilp.ghy.G06.beans.Admin" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="style.css">

<title>Admin Details</title>
<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
<script language="javascript">


function confirmDeletion()<%--method to confirm deletion --%>
{

	var response=confirm("Confirm Deletion");
	if(response)
		return true;
	else
		return false;
			
}

function displayDeleted()<%--method to display alert that admin deleted if no. of admin deleted is 1 and then send to delete admin page--%>
{
	
	
	<%!String hasBeenDeleted=null; 
	int thenDeleted=0;%>
	<%hasBeenDeleted=session.getAttribute("deletedAdmin").toString();%>
	<%thenDeleted=Integer.parseInt(hasBeenDeleted);%><%--creating variables to store no. of admin deleted, parsing to integer and if no. is 1 then displaying alert and redirecting--%>
	if(1==<%=thenDeleted%>)
	{
	alert("Admin deleted");	
	<%
	int deletedAdmin=0;
	session.setAttribute("deletedAdmin",deletedAdmin);
	%>
	window.location = "MainControllerServlet?Operation=cancelAtDisplay";
	}
	
	
	
	
}


function pageRedirect()<%--redirecting to previous page on cancel--%>
{

	window.location = "MainControllerServlet?Operation=okAtDisplay";
}

</script>

</head>
<body onload="return displayDeleted()">

<%@ include file="./header.html" %>
<br>
<%User uObj1=(User)((request.getSession(false)).getAttribute("user"));%>
<%String role=uObj1.getRoleName(); %>
<%if ("SuperAdmin".equals(role) ){ %>
<%@ include file="./superadminmainmenu.jsp" %>

<%} %>
<%if("Admin".equals(role)) { %>
<%@ include file="./adminmainmenu.jsp" %>

<%} %><br><br>
<div id=footer>
<BR>
<PRE>
<a href="MainControllerServlet?Operation=underConstruction">Register Admin</a>        <a href="MainControllerServlet?Operation=underConstruction">Update Admin Details</a>          <a href="MainControllerServlet?Operation=ManageAdmin">Delete Admin</a>         <a href="MainControllerServlet?Operation=underConstruction">View Admin Details</a>
</PRE>
</div>

<BR><BR>


<h1>Admin Details</h1>

<form action= "MainControllerServlet" method="post" onSubmit="return confirmDeletion()">

	<table class=tabFont border=5 align=center cellpadding=5 cellspacing=10 width=40%>
		<tr>
			<th>
			Admin Id
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getAdminId()%>
			</td>
		</tr>
		<tr>
			<th>
			First Name
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getFirstName()%>
			</td>
		</tr>
		<tr>
			<th>
			Last Name
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getLastName()%>
			</td>
		</tr>
		<tr>
			<th>
			Gender
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getGender()%>
			</td>
		</tr>
		<tr>
			<th>
			Date Of Birth
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getDateOfBirth()%>
			</td>
		</tr>
		<tr>
			<th>
			Email-id
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getEmailId()%>
			</td>
		</tr>
		<tr>
			<th>
			City
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getCity()%>
			</td>
		</tr>
		<tr>
			<th>
			Location
			</th>
			<td>
			<%=((Admin)session.getAttribute("admin")).getLocation()%>
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit"  name="delete" value="Delete"> 
			</td>
			<td>
			<input type="button" name="Cancel" value="Cancel" onClick="return pageRedirect()" >
			</td>
		</tr>
		
	
	</table>

<input type="hidden" name="operation" value="Display">
</form>

<%@ include file="footer.html" %>

</body>
</html>