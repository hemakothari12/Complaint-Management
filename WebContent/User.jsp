<jsp:include page="Header.jsp" />

<div class="row content">
	<div class="col-sm-9"></div>
	<div class="col-sm-3">
		<div class="col-sm-6 container">
			<span class="highlight">Welcome <%= session.getAttribute("user") %></span>
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
				<li class="active"><a href="AddNew.jsp?value=Technology">Add
						Complaint</a></li>
				<li><a href="ViewComplaints.jsp">View Complaints</a></li>
				<li><a href="ViewProfile.jsp">View Profile</a></li>
			</ul>
			<br>
		</div>
		<div class="col-sm-9">
			<div class="row">
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AddNew.jsp?value=Technology">Technology</a>
						</h4>
						<p>Request support for workstation, mobile, access and
							boarding.</p>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AddNew.jsp?value=HR">HR</a>
						</h4>
						<p>Submit request for benefits, leave, pay, time and personal
							details.</p>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AddNew.jsp?value=Facilities">Facilities</a>
						</h4>
						<p>Create a request for your desk, floor, room and building
							needs.</p>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="well">
						<h4>
							<a href="AddNew.jsp?value=Security">Security</a>
						</h4>
						<p>Submit request for VPN, Firewall changes and certificates.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<jsp:include page="Footer.jsp" />