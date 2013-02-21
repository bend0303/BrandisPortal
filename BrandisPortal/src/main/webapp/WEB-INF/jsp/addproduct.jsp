<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<form:form modelAttribute="newProduct" method="post" action="/products/addproduct" enctype="multipart/form-data">
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
				<td colspan="2"><input name="Submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form:form>
	<form action="#" method="post">
		<div id="title">Contact form</div>
		<div class="row">
			<label class="col1">Name:&nbsp;&nbsp;</label> <span class="col2"><input name="name" class="input" type="text" id="name" size="20" tabindex="1" /></span>
		</div>
		<div class="row">
			<label class="col1">e-mail:&nbsp;&nbsp;</label> <span class="col2"><input name="email" class="input" type="text" id="email" size="20" tabindex="2" /></span>
		</div>
		<div class="row">
			<label class="col1">Website:&nbsp;&nbsp;</label> <span class="col2"><input name="website" class="input" type="text" id="website" value="http://" size="20" tabindex="3" /></span>
		</div>
		<div class="row">
			<label class="col1comment">Comment:&nbsp;&nbsp;</label> <span class="col2comment"><textarea cols="20" class="textarea" rows="4" name="comment" id="comment" tabindex="4"></textarea></span>
		</div>
		<div align="center" class="submit">
			<input type="image" src="images/b_send.gif" alt="send" width="52" height="19" border="0" />
		</div>
	</form>
	<h3>
		<a href="/user/logout">Logout</a>
	</h3>
</body>
</html>