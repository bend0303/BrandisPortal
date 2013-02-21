<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/addProduct.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/productsDisplay.css"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Page</title>
</head>
<body>
	<div id="uppderDockDiv">
		<table width="100%">
			<tr>
				<td id="headerTD">
					<p id="pageTitle">JavaEE Final Project</p>
				</td>
				<td id="menuTD"><a id="logout" href="/brandis/user/logout/">Logout</a>&nbsp;<a id="logout" href="/brandis/products/showproducts/">Products Page</a></td>
			</tr>
			<tr>
				<td>
				<p id="userNameDisplay">Hello <c:out value="${userFullName}" />!</p>
				</td>
				<td></td>
			</tr>
		</table>
		
	</div>
	<div id="addProductFormDiv">
		<form:form modelAttribute="newProduct" method="post" action="/brandis/products/addproduct" enctype="multipart/form-data">
			<div id="title">New Product form</div>
			<div class="row">
				<label class="col1">Name:&nbsp;&nbsp;</label> <span class="col2"><form:input path="productName" class="input" type="text" id="name" size="20" /> </span>
			</div>
			<div class="row">
				<label class="col1">Price:&nbsp;&nbsp;</label> <span class="col2"> <form:input path="productPrice" class="input" type="text" size="20" tabindex="2" /></span>
			</div>
			<div class="row">
				<label class="col1">Image:&nbsp;&nbsp;</label> <span class="col2"> <form:input type="file" path="productImage" class="input" size="10" tabindex="2" /></span>
			</div>
			<div class="row">
				<label class="col1desc">Description:&nbsp;&nbsp;</label> <span class="col2desc"> <form:textarea path="productDesc" cols="20" class="textarea" rows="4" tabindex="4" /></span>
			</div>
			<div align="center" class="submit">
				<input type="image" src="../../resources/images/addproduct/b_send.gif" alt="send" width="52" height="19" />
			</div>
		</form:form>
	</div>
</body>
</html>