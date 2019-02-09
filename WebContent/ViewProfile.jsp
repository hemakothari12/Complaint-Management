<%@page import="com.example.Complaints"%>
<jsp:include page="Header.jsp" />

<div class="row content">
	<div class="col-sm-9"></div>
	<div class="col-sm-3">
		<div class="col-sm-6 container">
			<span class="highlight">Welcome <%=session.getAttribute("user")%></span>
		</div>
		<div class="col-sm-6 nav nav-pills nav-stacked">
			<a href="HomePage.jsp">Logout</a>
		</div>
	</div>
</div>
<br>

<div class="row content">
	<div class="col-sm-3 sidenav hidden-xs">
		<ul class="nav nav-pills nav-stacked ">
			<li><a href="AddNew.jsp?value=Technology">Add Complaint</a></li>

			<%
				if (session.getAttribute("usertype").equals("admin")) {
			%>
			<li><a href="AdminViewComplaints.jsp">Manage Complaints</a></li>
			<%
				} else {
			%>
			<li><a href="ViewComplaints.jsp">View Complaints</a></li>
			<%
				}
			%>

			<!-- <li><a href="ViewComplaints.jsp">View Complaints</a></li> -->
			<li class="active"><a href="#">View Profile</a></li>

			<%
				if (session.getAttribute("usertype").equals("admin")) {
			%>
			<li><a href="UserProfile.jsp">Maintain User</a></li>
			<%
				}
			%>
		</ul>
		<br>
	</div>
	<div class="col-sm-9 container">

		<h4>
			Username: <I><%=(String) session.getAttribute("user")%>
		</h4>
		</I>
		<h4>
			First Name: <I><%=(String) session.getAttribute("firstname")%>
		</h4>
		</I>
		<h4>
			Last Name: <I><%=(String) session.getAttribute("lastname")%>
		</h4>
		</I>
		<h4>
			Position: <I><%=(String) session.getAttribute("position")%>
		</h4>
		</I>
		<h4>
			Email: <I><%=(String) session.getAttribute("email")%>
		</h4>
		</I>
		<h4>
			Phone: <I><%=(String) session.getAttribute("phone")%>
		</h4>
		</I>
	</div>
</div>

<jsp:include page="Footer.jsp" />