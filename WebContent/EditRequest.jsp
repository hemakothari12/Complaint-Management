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
			<li><a href="AdminViewComplaints.jsp">Maintain Complaints</a></li>
			<li><a href="ViewProfile.jsp">View Profile</a></li>
			<li><a href="UserProfile.jsp">Maintain User</a></li>
		</ul>
		<br>
	</div>
	<div class="col-sm-9 container">

		<form method="Post" action="command" ?name=action>
			<h3>Edit Complaint</h3>
			<div>
				Category: <input type="text" name="category" readonly="readonly"
					required="required"
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
				Please describe your incident in details: <br>
				<textarea type="text" style="height: 100px; width: 400px"
					name="description" required="required"><%=(String) session.getAttribute("description")%></textarea>
			</div>
			<br>
			<div>
				Best Method of Contact:
				<%
				String[] eqArray2 = { "Email", "Phone", "Any" };
				String val2 = (String) session.getAttribute("cmethod");
			%>
				<select name="cmethod">
					<%
						for (int count = 0; count < eqArray2.length; count++) {
					%>
					<option value="<%=eqArray2[count]%>"
						<%=(eqArray2[count].equals(val2)) ? "selected" : ""%>><%=eqArray2[count]%></option>
					<%
						}
					%>

				</select>
			</div>
			<br>
			<div>
				Status:
				<%
				String[] eqArray1 = { "Open", "Close" };
				String val1 = (String) session.getAttribute("status");
				%>
				<select name="status">
					<%
						for (int count = 0; count < eqArray1.length; count++) {
					%>
					<option value="<%=eqArray1[count]%>"
						<%=(eqArray1[count].equals(val1)) ? "selected" : ""%>><%=eqArray1[count]%></option>
					<%
						}
					%>
				</select>
			</div>
			<br>
			<div>
				Comments:<br>
				<textarea type="text" name="comments" required="required"><%=(String) session.getAttribute("comments")%></textarea>
				<br> <br> <input type="submit" name="action"
					value="update"> <input type="submit" name="action"
					value="delete">
			</div>
		</form>
	</div>
</div>

<jsp:include page="Footer.jsp" />