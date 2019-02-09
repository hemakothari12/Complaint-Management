<jsp:include page="Header.jsp" />
<jsp:include page="Header1.jsp" />

<%String usernamevalue="";
   String passwordvalue="";
   if(request.getAttribute("username")!=null)
	   usernamevalue=(String)request.getAttribute("username");
    if(request.getAttribute("password")!=null)
    	passwordvalue=(String)request.getAttribute("password");%>

<section id="main">
	<div class="container">
		<article id="main-col">
			<div class="dark">
				<h3>Login Form</h3>
				<form class="quote" method="Post" action="command" ?name=action>
					<div>
						<label for="uname"><b>Username</b></label> <input
							class="textcolor" type="text" name="username"
							required="required value=<%=usernamevalue%>">
					</div>
					<div>
						<br>
					</div>
					<div>
						<label for="psw"><b>Password</b></label> <input class="textcolor"
							type="password" name="password"
							required="required value=<%=passwordvalue%>">
					</div>
					<div>
						<br>
					</div>
					<input type="submit" name="action" value="login" class="button_1">
				</form>
			</div>

		</article>

	</div>
</section>

<jsp:include page="Footer.jsp" />
