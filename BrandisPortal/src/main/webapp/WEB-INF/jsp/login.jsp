<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Language" content="en-us" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Login</title>
<style type="text/css">
.style1 {
	text-align: center;
	text-decoration: underline;
}
</style>
</head>

<body>

	<h3>USER LOGIN</h3>
	<form method="post" action="/brandis/user/login">
		<table align="left">
			<tr>
				<td>E-mail</td>
				<td><input name="email" type="text" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="pass" type="password" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input name="Submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>

</html>
