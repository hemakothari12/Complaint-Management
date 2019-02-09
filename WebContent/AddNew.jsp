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

<%
	String val = request.getParameter("value");
%>

<%
	String complaintidvalue = "";
	String categoryvalue = "";
	String issuevalue = "";
	String descriptionvalue = "";
	String cmethodvalue = "";
	String requestedByvalue = "";
	String statusvalue = "";
	String commentsvalue = "";
	if (request.getAttribute("complaintid") != null)
		complaintidvalue = (String) request.getAttribute("complaintid");
	if (request.getAttribute("category") != null)
		complaintidvalue = (String) request.getAttribute("category");
	if (request.getAttribute("issue") != null)
		complaintidvalue = (String) request.getAttribute("issue");
	if (request.getAttribute("description") != null)
		descriptionvalue = (String) request.getAttribute("description");
	if (request.getAttribute("cmethod") != null)
		cmethodvalue = (String) request.getAttribute("cmethod");
	if (request.getAttribute("requestedBy") != null)
		requestedByvalue = (String) request.getAttribute("requestedBy");
	if (request.getAttribute("status") != null)
		statusvalue = (String) request.getAttribute("status");
	if (request.getAttribute("comments") != null)
		commentsvalue = (String) request.getAttribute("comments");
%>

<div class="row content">
	<div class="col-sm-3 sidenav hidden-xs">
		<ul class="nav nav-pills nav-stacked ">
			<li class="active"><a href="AddNew.jsp?value=Technology">Add
					Complaint</a></li>
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
			<li><a href="ViewProfile.jsp">View Profile</a></li>
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

		<form method="Post" action="command" ?name=action>
			<h3>Report an Complaint</h3>
			<div>
				Category:
				<%
				String[] eqArray = {"Technology", "HR", "Facilities", "Security"};
				%>
				<select name="category"
					onchange="configureDropDownLists(this,document.getElementById('ddl2'))">
					<%for (int count = 0; count < eqArray.length; count++) {%>
					<option value="<%=eqArray[count]%>"
						<%=(eqArray[count].equals(val)) ? "selected" : ""%>><%=eqArray[count]%></option>
					<% } %>
				</select>
			</div>
			<br>

			<div>
				Select an Issue from the List:
				<%
				if (val.equals("Technology")) {
				%>
				<select id="ddl2" name="issue">
					<option value="Workstation">Workstation</option>
					<option value="Mobile">Mobile</option>
					<option value="Access">Access</option>
					<option value="Boarding">Boarding</option>
				</select>
				<%
					} else if (val.equals("HR")) {
				%>
				<select id="ddl2" name="issue">
					<option value="Benefits">Benefits</option>
					<option value="Leave">Leave</option>
					<option value="Pay">Pay</option>
					<option value="Timesheet">Timesheet</option>
					<option value="Details">Details</option>
				</select>
				<%
					} else if (val.equals("Facilities")) {
				%>
				<select id="ddl2" name="issue">
					<option value="Desk">Desk</option>
					<option value="Floor">Floor</option>
					<option value="Room">Room</option>
					<option value="Building">Building</option>
				</select>
				<%
					} else if (val.equals("Security")) {
				%>
				<select id="ddl2" name="issue">
					<option value="VPN">VPN</option>
					<option value="Firewall">Firewall</option>
					<option value="Certificates">Certificates</option>
				</select>
				<%
					}
				%>
			</div>
			<br>
			<div>
				Please describe your incident in details: <br>
				<textarea type="text" style="height: 100px; width: 400px"
					name="description" required="required"><%=descriptionvalue%></textarea>
			</div>
			<br>
			<div>
				Best Method of Contact: <br> <select name="cmethod">
					<option value="email">Email</option>
					<option value="phone">Mobile</option>
					<option value="both">Any</option>
				</select>
			</div>
			<br>
			<div>
				Comments:<br>
				<textarea type="text" name="comments"><%=commentsvalue%></textarea>
				<br> <br> <input type="submit" name="action"
					value="insert">
			</div>
		</form>
	</div>
</div>

<jsp:include page="Footer.jsp" />


<script type="text/javascript">
	function configureDropDownLists(ddl1, ddl2) {
		var Technology = [ 'Workstation', 'Mobile', 'Access', 'Boarding' ];
		var HR = [ 'Benefit', 'Leave', 'Pay', 'Timesheet', 'Details' ];
		var Facilities = [ 'Desk', 'Floor', 'Room', 'Building' ];
		var Security = [ 'VPN', 'Firewall', 'Certificates' ];

		switch (ddl1.value) {
		case 'Technology':
			ddl2.options.length = 0;
			for (i = 0; i < Technology.length; i++) {
				createOption(ddl2, Technology[i], Technology[i]);
			}
			break;
		case 'HR':
			ddl2.options.length = 0;
			for (i = 0; i < HR.length; i++) {
				createOption(ddl2, HR[i], HR[i]);
			}
			break;
		case 'Facilities':
			ddl2.options.length = 0;
			for (i = 0; i < Facilities.length; i++) {
				createOption(ddl2, Facilities[i], Facilities[i]);
			}
			break;
		case 'Security':
			ddl2.options.length = 0;
			for (i = 0; i < Security.length; i++) {
				createOption(ddl2, Security[i], Security[i]);
			}
			break;
		default:
			ddl2.options.length = 0;
			break;
		}

	}

	function createOption(ddl, text, value) {
		var opt = document.createElement('option');
		opt.value = value;
		opt.text = text;
		ddl.options.add(opt);
	}
</script>
