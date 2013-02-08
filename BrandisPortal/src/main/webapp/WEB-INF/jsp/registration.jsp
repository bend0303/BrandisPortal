<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/popup.css" />"
	type="text/css" media="screen, projection">
<style type="text/css">
.even {
	background-color: silver;
}
</style>
<title>Registration Page</title>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-1.4.min.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/json.min.js" /> "></script>
</head>
<body>

	<form:form modelAttribute="temp" method="post"
		action="/user/registration">
		<table>
			<tr>
				<td>User Name :</td>
				<td><form:input path="username" /></td>

			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" value="M" label="M" /> <form:radiobutton
						path="gender" value="F" label="F" /></td>
			</tr>
			<tr>
				<td>Disability :</td>
				<td><form:checkbox path="disability" value="Leg" label="Leg" />
					<form:checkbox path="disability" value="Hand" label="Hand" /> <form:checkbox
						path="disability" value="Head" label="Head" /></td>
				<td colspan="2"><input id="submit" name="Submit" type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form:form>

		<h3>
		<a href="/user/loginform">Login</a>
	</h3>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		// check name availability on focus lost
		$('#username').blur(function() {
			if ($('#username').val()) {
				checkAvailability();
			}
		});
	});

	function checkAvailability() {
		$.getJSON("/user/availability", {
			username : $('#username').val()
		}, function(available) {
			if (available == false) {
				alert("Username already exists aaaaa");
				$('#submit').attr("disabled", true);
				
			} else {
				$('#submit').attr("disabled", false);
			}

		});
	}

</script>
</html>
