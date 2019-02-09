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

<%
	String useridvalue = "";
	String usernamevalue = "";
	String passwordvalue = "";
	String firstnamevalue = "";
	String lastnamevalue = "";
	String positionvalue = "";
	String emailvalue = "";
	String phonevalue = "";
	String typevalue = "";
	if (request.getAttribute("userid") != null)
		useridvalue = (String) request.getAttribute("userid");
	if (request.getAttribute("username") != null)
		usernamevalue = (String) request.getAttribute("username");
	if (request.getAttribute("password") != null)
		passwordvalue = (String) request.getAttribute("password");
	if (request.getAttribute("firstname") != null)
		firstnamevalue = (String) request.getAttribute("firstname");
	if (request.getAttribute("lastname") != null)
		lastnamevalue = (String) request.getAttribute("lastname");
	if (request.getAttribute("position") != null)
		positionvalue = (String) request.getAttribute("position");
	if (request.getAttribute("email") != null)
		emailvalue = (String) request.getAttribute("email");
	if (request.getAttribute("phone") != null)
		phonevalue = (String) request.getAttribute("phone");
	if (request.getAttribute("type") != null)
		typevalue = (String) request.getAttribute("type");
%>

<br>

<div class="row content">
	<div class="col-sm-3 sidenav hidden-xs">
		<ul class="nav nav-pills nav-stacked ">
			<li><a href="AddNew.jsp?value=Technology">Add Complaint</a></li>
			<li><a href="AdminViewComplaints.jsp">Maintain Complaints</a></li>
			<li><a href="ViewProfile.jsp">View Profile</a></li>
			<li class="active"><a href="UserProfile.jsp">Maintain User</a></li>
		</ul>
		<br>
	</div>
	<div class="col-sm-9 container">

		<form method="Post" action="command" ?name=action>
			<h3>Maintain User</h3>
			<div>
				User ID: <input type="text" name="userid" value=<%=useridvalue%>><br>
			</div>
			<br>
			<div>
				Username: <input type="text" name="username"
					value=<%=usernamevalue%>><br>
			</div>
			<br>
			<div>
				Password: <input type="password" name="password"
					value=<%=passwordvalue%>>
			</div>
			<br>
			<div>
				First Name: <input type="text" name="firstname"
					value=<%=firstnamevalue%>><br>
			</div>
			<br>
			<div>
				Last Name: <input type="text" name="lastname"
					value=<%=lastnamevalue%>><br>
			</div>
			<br>
			<div>
				Position: <input type="text" name="position"
					value=<%=positionvalue%>><br>
			</div>
			<br>
			<div>
				Email: <input type="text" name="email" value=<%=emailvalue%>><br>
			</div>
			<br>
			<div>
				Phone: <input type="number" name="phone" value=<%=phonevalue%>><br>
			</div>
			<br>
			<div>
				Type:<input type="text" name="type" value=<%=typevalue%>><br>
				<br> <input type="submit" name="action" value="userinsert">
				<input type="submit" name="action" value="userfind"> <input
					type="submit" name="action" value="userupdate"> <input
					type="submit" name="action" value="userdelete"> <input
					type="submit" name="action" value="userdisplay">
			</div>
		</form>
	</div>
</div>

<jsp:include page="Footer.jsp" />