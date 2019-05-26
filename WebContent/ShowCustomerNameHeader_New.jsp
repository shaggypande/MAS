<%@ page import="com.tcs.ilp.ghy.G06.beans.User" isErrorPage="false" errorPage="SessionInactive.jsp"%>
<H3> Hello <%=((User)session.getAttribute("user")).getFirstName()%>  
<%=((User)session.getAttribute("user")).getLastName()%></H3>