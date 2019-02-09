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
				<table border="2" class="table">
					<tr>
						<td><b>Complaint ID</b></td>
						<td><b>Category</b></td>
						<td><b>Issue</b></td>
						<td><b>Description</b></td>
						<td><b>Contact</b></td>
						<td><b>Requested By</b></td>
						<td><b>Status</b></td>
						<td><b>Comments</b></td>
					</tr>
					<%
						try {
							Class.forName("com.mysql.jdbc.Driver");
							String us = (String) session.getAttribute("user");
							String query = "Select complaintid,category,issue,Description,cmethod,RequestedBy,Status,Comments from complaint where status='Open'";
							Connection conn = DriverManager
									.getConnection("jdbc:mysql://127.0.0.1:3307/cars_collection?useSSL=false", "root", "root");
							Statement stmt = conn.createStatement();
							ResultSet rs = stmt.executeQuery(query);
							while (rs.next()) {
					%>
					<tr>
						<form method="post" action="command" ?name=action>
							<td><%=rs.getInt("complaintid")%></td>
							<td><%=rs.getString("category")%></td>
							<td><%=rs.getString("issue")%></td>
							<td><%=rs.getString("description")%></td>
							<td><%=rs.getString("cmethod")%></td>
							<td><%=rs.getString("RequestedBy")%></td>
							<td><%=rs.getString("status")%></td>
							<td><%=rs.getString("comments")%></td>
							<td><input type="hidden" name="item"
								value=<%=rs.getInt("complaintid")%>></td>
							<td><input type="submit" name="action" value="edit">
							</td>
						</form>
					</tr>
					<%
						}
					%>
				</table>
				<%
					rs.close();
						stmt.close();
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				%>
			</div>
		</div>
	</div>
</div>

<jsp:include page="Footer.jsp" />