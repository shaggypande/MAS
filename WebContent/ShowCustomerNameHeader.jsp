<%@ page import="com.tcs.ilp.ghy.G06.beans.User" %>
<H3> Hello <%=((User)request.getAttribute("user")).getFirstName()%>  
<%=((User)request.getAttribute("user")).getLastName()%></H3>