<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body>
	<h1>
		Welcome
		<core:out value="${userPersist.username}" />
	</h1>
	<br>
	<h3>
		<a href="/logout">Logout</a>
	</h3><br>
	<h3>
		<a href="/products/addproductform">AddProduct</a>
		<a href="/products/products">ShowProducts</a>
	</h3>
</body>
</html>