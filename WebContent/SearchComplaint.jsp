<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.example.Complaints"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.example.DBOperations"%>
<%@page import="java.sql.ResultSet"%>
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
<br>

<div class="container-fluid">
	<div class="row content">
		<div class="col-sm-3 sidenav hidden-xs">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="AddNew.jsp?value=Technology">Add Complaint</a></li>
				<li class="active"><a href="AdminViewComplaints.jsp">Maintain
						Complaints</a></li>
				<li><a href="ViewProfile.jsp">View Profile</a></li>
				<li><a href="UserProfile.jsp">Maintain User</a></li>
			</ul>
			<br>
		</div>
		<div class="col-sm-9">
			<div class="row">
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AdminAll.jsp" onclick="">All</a>
						</h4>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AdminOpen.jsp" onclick="">Open</a>
						</h4>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AdminClose.jsp" onclick="">Closed</a>
						</h4>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="SearchComplaint.jsp" onclick="">Search</a>
						</h4>
					</div>
				</div>
			</div>

			<div class="row">

				<form method="Post" action="command" ?name=action>
					<h3>Search Complaint</h3>
					<div>
						Enter Complaint ID: <input type="text" required="required"
							name="searchcomplaint"><br>
					</div>
					<br>
					<div>
						<input type="submit" name="action" value="search">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="Footer.jsp" />