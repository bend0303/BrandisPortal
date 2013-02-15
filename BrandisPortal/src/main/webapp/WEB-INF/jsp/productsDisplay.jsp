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
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-1.9.1.min.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery.livequery.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery-ui-1.10.0.custom.js" /> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/productsDisplayJS.js" /> "></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/productsDisplay.css"/>" />
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products page</title>
<script type="text/javascript">

</script>
</head>
<body>
		<ul id="productList">

			<c:forEach var="p" items="${products}">
				<li>
					<div>
						<table width="100%">
							<tr>
								<td width="15%" rowspan="2" id="productImage">
								<img width="100px" height="100px"
									src="file:///C:/Test/Upload/ben.png" /></td>
								<td width="55%" id="productName" class="productTitle"><c:out
										value="${p.productName}" /></td>
								<td align="center"><img alt="Buy"
									src="<c:url value="/resources/images/shoppingCart.png"/>"
									title="Add Item To Cart" class="shoppingCartIMG"
									name="idForCart" id="<c:out value="${p.productImage}"/>" > 
									<input style="font-size: 12px;" class="spinner"
									name="amount<c:out value="${p.productId}"/>" /></td>
							</tr>
							<tr>
								<td class="productDesc"><c:out value="${p.productDesc}" /></td>
								<td align="center" class="productDesc"><b>Price: </b> <span
									class="price"><c:out value="${p.productPrice}" /></span></td>
							</tr>
						</table>
					</div>
				</li>
			</c:forEach>

		</ul>
	<a href="/cart/showcart">Cart</a>

	<div id="left_bar">

		<form action="#" id="cart_form" name="cart_form">

			<div class="cart-info"></div>

			<div class="cart-total">

				<b>Total
					Charges:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b>
				$<span>0</span> <input type="hidden" name="total-hidden-charges"
					id="total-hidden-charges" value="0" />
			</div>

			<button type="submit" id="Submit">CheckOut</button>

		</form>

	</div>
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
						<input type="submit" style="width: 30px; height: 30px;" alt="Add product" name="idForCart" value="${p.productId}"></td>
					</tr>

				</c:forEach>
			</table>
		</form>
		<a href="/cart/showcart">Cart</a>
	</div> --%>
