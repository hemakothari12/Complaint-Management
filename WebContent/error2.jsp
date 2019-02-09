<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<%
		String op = (String) session.getAttribute("operation");
		boolean found = false;
	%>
	<%
		if (op.equals("login")) {
			found = true;
			out.println("Error in login");
	%><br>
	<A HREF="HomePage.jsp ">Go Back</a>
	<%
		} else if (op.equals("inserted")) {
			found = true;
			out.println("Error in adding a new record, possibly duplicate record");
	%><br>
	<A HREF="UserProfile.jsp">Go Back</a>
	<%
		} else if (op.equals("updated")) {
			found = true;
			out.println("Error in updating record, possibly record not found");
	%><br>
	<A HREF="UserProfile.jsp ">Go Back</a>
	<%
		} else if (op.equals("deleted")) {
			found = true;
			out.println("Error in deleting record, possibly record not found");
	%><br>
	<A HREF="UserProfile.jsp ">Go Back</a>
	<%
		} else if (response.getStatus() == 500 && found == false) {
	%>
	<font color="red">Error: <%=pageContext.EXCEPTION%></font>
	<br>

	<%-- include index page --%>
	<%@ include file="HomePage.jsp"%>
	<%
		} else if (response.getStatus() != 500 && found == false) {
	%>
	Hi There, error code is
	<%=response.getStatus()%><br> Please go to
	<a href="HomePage.jsp">home page</a>
	<%
		}
	%>
</body>
</html>