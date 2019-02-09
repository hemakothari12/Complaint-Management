<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complaint Management</title>
</head>
<body>
	<TABLE BORDER=5 ALIGN="CENTER">
		<TR>
			<TH CLASS="TITLE">UserDetails
	</TABLE>
	<OL>
		The Complaints with the following data are
		<%=request.getAttribute("operation")%>:
		<br>
		<I><%=request.getAttribute("result")%></I>
		<A HREF="UserProfile.jsp">Go Back</a>
	</OL>
</body>
</html>