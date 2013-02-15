<%@page import="il.co.brandis.services.ProductManagerService"%>
<%@page import="il.co.brandis.entities.DBProduct"%>
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
		<form action="/cart/deleteitemfromcart" method="post">
			<table class="productsTable" cellspacing="0"
				summary="Product List Table">
				<caption>Cart</caption>
				<tr>
					<th width="25% scope="col" abbr="Product Name">Product Name</th>
					<th width="25% scope="col" abbr="Price">Price</th>
					<th width="25% scope="col" abbr="Amount">Amount</th>
					<th width="25% scope="col" abbr="Total">Total</th>
				</tr>

				<c:forEach var="p" items="${cartItems}">
					<tr>
						<!-- <th scope="row" class="spec"><c:out value="${p.product.productId}" />
						</th> -->
						<td width="25%"><c:out value="${p.product.productName}" /></td>						
						<td width="25%"><c:out value="${p.product.productPrice}" /></td>
						<td width="25%"><c:out value="${p.amount}" /></td>
						<td width="25%"><c:out value="${p.price}" /></td>
						<td><input type="submit" style="width: 30px; height: 30px;" alt="Delete product" name="singleDelete" value="${p.product.productId}"></td>
			</tr>
					</tr>
				</c:forEach>
			</table>
		</form>
		<br><br>
		<h3>Total Balance : </h3><c:out value="${cart.balance}" />
	</div>
	<img alt="" src="http://localhost:8080/images/garbage-bin-icon.jpg"/>
</body>
</html>