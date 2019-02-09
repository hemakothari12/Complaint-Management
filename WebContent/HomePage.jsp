<jsp:include page="Header.jsp" />
<jsp:include page="Header1.jsp" />

<% session.invalidate(); %>

<section id="boxes">
	<div class="container">
		<div class="box">
			<a href="Login.jsp"><img src="./img/login.jpg"></a>
			<h3>Step 1</h3>
			<p>Login and Enter all the details of your complaint so that
				concerned department can be informed.</p>
		</div>
		<div class="box">
			<img src="./img/info.jpg">
			<h3>Step 2</h3>
			<p>If Required representative will ask to Submit additional
				information related to your complaint.</p>
		</div>
		<div class="box">
			<img src="./img/reso.jpg">
			<h3>Step 3</h3>
			<p>Representative for the concerned department will resolve your
				complaint. Status can be tracked online</p>
		</div>
	</div>
</section>

<jsp:include page="Footer.jsp" />