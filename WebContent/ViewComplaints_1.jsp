<TABLE BORDER=5 ALIGN="CENTER">
	<TR>
		<TH CLASS="TITLE">Complaint Registration
</TABLE>
<OL>
	The Complaints with the following data are
	<%=session.getAttribute("operation")%>:
	<br>
	<I><%= session.getAttribute("result") %></I>
	<br>

	<%if(session.getAttribute("usertype").equals("admin")){%>
	<A HREF="Admin.jsp">Manage</a>
	<%} else {%>
	<A HREF="User.jsp">Go Back</a>
	<%} %>
</OL>