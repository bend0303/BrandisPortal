<%@page import="il.co.brandis.services.ProductManagerService"%>
<%@page import="il.co.brandis.entities.Product"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />

<script type="text/javascript" src="<c:url value="/resources/javascript/jquery-1.9.1.min.js" /> "></script>

<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/productsDisplayJS.js" /> "></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/productsDisplay.css"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products page</title>
</head>
<ul id="productList">
	<c:forEach var="p" items="${products}">
		<li>
			<div>
				<table width="100%">
					<tr>
						<td width="15%" rowspan="2" id="productImage"><img width="100px" height="100px" src="<c:url value="/resources/images/newProduct.jpg"/>" /></td>
						<td width="55%" class="productTitle"><c:out value="${p.productName}" /></td>
						<td align="center"> <img title="Add Item To Cart" style="vertical-align:bottom; width:22px; height:22px; padding-right:1px;"
							src="<c:url value="/resources/images/shoppingCart.png"/>" /> <input style="font-size:12px;" class="spinner" name="value" /></td>
					</tr>
					<tr>
						<td class="productDesc"><c:out value="${p.productDesc}" /></td>
						<td align="center" class="productDesc"><b>Price: </b> <span class="price"><c:out value="${p.productPrice}" /></span></td>
					</tr>
				</table>
			</div>
		</li>
	</c:forEach>
</ul>



</body>
</html>









<%-- 	<div class="wrapperDiv">
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
	</div> --%>
