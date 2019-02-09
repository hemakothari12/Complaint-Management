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
			<li class="active"><a href="AddNew.jsp?value=Technology">Add
					Complaint</a></li>
			<li><a href="ViewComplaints.jsp">View Complaints</a></li>
			<li><a href="ViewProfile.jsp">View Profile</a></li>
		</ul>
		<br>
	</div>
	<div class="col-sm-9 container">

		<form method="Post" action="command" ?name=action>
			<h3>Maintain Complaint</h3>
			<div>
				Category: <input type="text" name="category" required="required"
					readonly="readonly"
					value=<%=(String) session.getAttribute("category")%>><br>
			</div>
			<br>
			<div>
				Issue: <input type="text" name="issue" required="required"
					readonly="readonly"
					value=<%=(String) session.getAttribute("issue")%>><br>
			</div>
			<br>
			<div>
				Please describe your incident in details: <br> <input
					type="text" style="height: 100px; width: 400px" name="description"
					required="required" readonly="readonly"
					value=<%=(String) session.getAttribute("description")%>>
			</div>
			<br>
			<div>
				Best Method of Contact: <br> <input type="text" name="cmethod"
					required="required" readonly="readonly"
					value=<%=(String) session.getAttribute("cmethod")%>><br>
			</div>
			<br>
			<div>
				Comments:<br>
				<textarea type="text" name="comments" required="required"><%=(String) session.getAttribute("comments")%></textarea>
				<br> <br> <input type="submit" name="action"
					value="update">
			</div>
		</form>
	</div>
</div>

<jsp:include page="Footer.jsp" />