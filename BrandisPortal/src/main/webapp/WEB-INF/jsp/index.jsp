<%@ page language="java" contentType="text/html; charset=windows-1255" pageEncoding="windows-1255"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">

<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/indexPage.css" />"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/animationStyle.css" />"/>

<title>Java EE Landing Page</title>

</head>
<body style="overflow: hidden">
	<div class="top-div">
		<table width="100%">
			<tr>
				<td id="headerTD">
					<p id="pageTitle">JavaEE Final Project</p>
				</td>
				<td id="menuTD"><a class="upperButton" href="#tologin"> Login </a> <a class="upperButton" href="#toregister">Register</a></td>
			</tr>
		</table>
		<script>
			function validatePass(p1, p2) {
				if (p1.value != p2.value || p1.value == '' || p2.value == '') {
					p2.setCustomValidity('Password does not match');
				} else {
					p2.setCustomValidity('');
				}
			}
		</script>
	</div>
	<div class="container">
		<div id="welcomeDiv">
			<span id="welcomeHeader">Welcome</span><br> <span id="welcomeText"> You arrived to Or Guz & Ben Diamant JavaEE final Project <br>
				In this project we chose to implement and online shop <br> Please login with your credential or create a new one <br> Enjoy
			</span>
		</div>
		<section>
		<div id="innerContainer">
			<!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
			<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor" id="tologin"></a>
			<div id="wrapper">
				<div id="login" class="animate form">
					<form action="#" autocomplete="on">
						<h1>Log in</h1>
						<p>
							<label for="uname" class="uname" data-icon="e"> Your email address</label> <input id="uname" name="uname" required="required"
								type="text" placeholder="mymail@mail.com" />
						</p>
						<p>
							<label for="password" class="youpasswd" data-icon="p"> Your password </label> <input id="password" name="password" required="required"
								type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p class="keeplogin">
							<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> <label for="loginkeeping">Remember me</label>
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
					<form action="mysuperscript.php" autocomplete="on">
						<h1>Sign up</h1>
						<p>
							<label for="usernamesignup" class="uname" data-icon="e">Email Address</label> <input id="usernamesignup" name="usernamesignup"
								required="required" type="text" placeholder="mymail@mail.com" />
						</p>
						<p>
							<label for="passwordsignup" class="youpasswd" data-icon="p">Password</label> <input id="passwordsignup" name="passwordsignup"
								required="required" type="password" placeholder="eg. X8df!90EO" />
						</p>
						<p>
							<label for="rpasswordsignup" class="rpasswd" data-icon="p">Confirm Password </label> <input id="rpasswordsignup" name="rpasswordsignup"
								required="required" type="password" placeholder="eg. X8df!90EO" onfocus="validatePass(document.getElementById('passwordsignup'), this);"
								oninput="validatePass(document.getElementById('passwordsignup'), this);/>">
						</p>
						<p>
							<label for="fnamesignup" class="fname" data-icon="u">Full Name</label> <input id="fnamesignup" name="fnamesignup" required="required"
								type="password" placeholder="Ploni Almoni" />
						</p>
						<p>
							<label class="gender">Gender:</label> <input type="radio" name="gendersignup" id="malesignup" value="Male" title="I am a dude" /> <label
								for="sizeMed">Male</label> <input type="radio" name="gendersignup" id="femalesignup" value="Female" title="I am a lady" /> <label
								for="sizeLarge">Female</label>
						</p>
						<p class="signin button">
							<input type="submit" value="Sign up" />
						</p>
						<p class="change_link">
							Already a member ? <a href="#tologin" class="to_register"> Go and log in </a>
						</p>
					</form>
				</div>
			</div>
		</div>
		</section>
	</div>
</body>
</html>

