<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.even {
	background-color: silver;
}
</style>
<title>Registration Page</title>
</head>
<body>

	<form:form modelAttribute="newProduct" method="post"
		action="/brandis/products/addproduct" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Product's Name :</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Product's Description :</td>
				<td><form:input path="productDesc" /></td>
			</tr>
			<tr>
				<td>Product's price :</td>
				<td><form:input path="productPrice" /></td>
			</tr>
			<tr>
				<td><form:input type="file" path="productImage" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="Submit" type="submit"
					value="submit" /></td>
			</tr>
		</table>
	</form:form>
	<h3>
		<a href="/brandis/user/logout">Logout</a>
	</h3>
</body>
</html>