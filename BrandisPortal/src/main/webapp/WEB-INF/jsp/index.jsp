<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">

<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/indexPage.css" />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/resources/css/animationStyle.css" />" />
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-1.9.1.min.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery.json-2.4.min.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/userJS.js" /> "></script>
<link
	href="http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.css"
	rel="stylesheet">
<title>Java EE Landing Page</title>

</head>
<body style="overflow: hidden">
	<div class="top-div">
		<table width="100%">
			<tr>
				<td id="headerTD">
					<p id="pageTitle">JavaEE Final Project</p>
				</td>
				<td id="menuTD"><a class="upperButton" href="#tologin">
						Login </a> <a class="upperButton" href="#toregister">Register</a></td>
			</tr>
		</table>
	</div>
	<div class="container">
		<div id="welcomeDiv">
			<span id="welcomeHeader">Welcome</span><br> <span
				id="welcomeText"> You arrived to Or Guz & Ben Diamant JavaEE
				final Project <br> In this project we chose to implement and
				online shop <br> Please login with your credential or create a
				new one <br> Enjoy
			</span>
		</div>
		<section>
		<div id="innerContainer">
			<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor"
				id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="/brandis/user/login" autocomplete="on" modelAttribute="newUser">
						<h1>Log in</h1>
						<p>
							<label for="email" data-icon="e"> Your email address</label> <input
								id="emaillog" name="email" required="required" type="text"
								placeholder="mymail@mail.com" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p">
								Your password </label> <input id="password" name="pass"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						
						<p class="login button">
							<input type="submit" value="Login" />
						</p>
						<p class="change_link">
							First time ? <a href="#toregister" class="to_register">Register</a>
						</p>
					</form>
				</div>
				<div id="register" class="animate form">
					<form:form modelAttribute="newUser" method="post" id="registerform"
						action="/brandis/user/registration" autocomplete="on">
						<h1>Sign up</h1>
						<p>
							<label for="email" class="email" data-icon="e">E-Mail:</label>
							<form:input required="required" type="text" path="email"
								id="email" placeholder="mymail@mail.com" />
						<p>
							<form:errors path="email" cssClass="error" />
						</p>
						<p>
							<label for="fnamesignup" class="fname" data-icon="u">Full
								Name</label> <form:input id="fnamesignup" name="fnamesignup"
								required="required" path="fullName" type="text" placeholder="Ploni Almoni" />
						<p>
							<form:errors path="fullName" cssClass="error" />
						</p>
						<p>
							<label for="passwordsignup" class="youpasswd" data-icon="p">Password:</label>
							<form:input id="passwordsignup" name="passwordsignup"
								required="required" path="password" type="password"
								placeholder="eg. X8df!90EO" />
						<p>
							<form:errors path="password" cssClass="error" />
						</p>
						<p>
							<label for="rpasswordsignup" class="rpasswd" data-icon="p">Confirm
								Password </label> <input id="rpasswordsignup" name="rpasswordsignup"
								required="required" type="password" placeholder="eg. X8df!90EO"
								onfocus="validatePass(document.getElementById('passwordsignup'), this);"
								oninput="validatePass(document.getElementById('passwordsignup'), this);">
						</p>
						
						<p>
							<label class="gender">Gender:</label>
							<form:radiobutton path="gender" value="M" label="M" />
							<form:radiobutton path="gender" value="F" label="F" />
						<p>
							<form:errors path="gender" cssClass="error" />
						</p>

						<p class="signin button">
							<input id="signup" type="submit" value="Sign up" />
						</p>
						<p class="change_link">
							Already a member ? <a href="#tologin" class="to_register"> Go
								and log in </a>
						</p>
					</form:form>
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>

