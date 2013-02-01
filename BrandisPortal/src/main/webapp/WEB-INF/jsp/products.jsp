<%@page import="il.co.brandis.services.ProductManagerService"%>
<%@page import="il.co.brandis.entities.Product"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products page</title>
</head>

<body>
	<div class="wrapperDiv">
		<form action="/cart/additemtocart" method="post">
			<table class="productsTable" cellspacing="0"
				summary="Product List Table">
				<caption>Product Table</caption>
				<tr>
					<th scope="col" abbr="Product ID">Product ID</th>
					<th scope="col" abbr="Product Name">Product Name</th>
					<th scope="col" abbr="Price">Price</th>
					<th scope="col" abbr="Description">Description</th>
				</tr>

				<c:forEach var="p" items="${products}">
					<tr>
						<td width="5%"><input type="checkbox" value="${p.productId}"
							name="delCheckbox"></td>
						<th scope="row" class="spec"><c:out value="${p.productId}" />
						</th>
						<td width="25%"><a
							href="http://localhost:8080/HibernateStudying/Product/<c:out value="${p.productId}"></c:out>">
								<c:out value="${p.productName}" />
						</a></td>
						<td width="15%"><c:out value="${p.productPrice}" /></td>
						<td width="35%"><c:out value="${p.productDesc}" /></td>
						<td width="10%">
						<td> <input type="text" value="" name="amount<c:out value="${p.productId}"></c:out>"></td>
							<td>
						<input type="submit" style="width: 30px; height: 30px;" alt="Add product" name="productId" value="${p.productId}"></td>
					</tr>

				</c:forEach>
			</table>
		</form>
		<a href="/cart/showcart">Cart</a>
	</div>
</body>
</html>