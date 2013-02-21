<%@page import="il.co.brandis.services.ProductManagerService"%>
<%@page import="il.co.brandis.entities.DBProduct"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.msg.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.center.min.js" /> "></script>
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery.msg.min.js" /> "></script>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Products page</title>

</head>
<body>
	<div id="uppderDockDiv">
		<table width="100%" height="62px">
			<tr>
				<td id="headerTD">
					<p id="pageTitle">JavaEE Final Project</p>

				</td>
				<td></td>
				<td id="menuTD"><a id="logout" href="/brandis/user/logout/">Logout</a>&nbsp;<a
					id="logout" href="/brandis/products/addproductform/">Add
						Products</a></td>

			</tr>

		</table>
		<div id="slidingTopWrap">
			<div id="slidingTopContent" style="display: none;">
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
			</div>
			<div id="slidingTopFooter">
				<div id="slidingTopFooterLeft">
					<img alt="Show Basket" src="../../resources/images/arrow-up.png" />
					<a href="no-js.htm" class="slidingTopTrigger"
						onclick="return false;">Hide Basket</a>
				</div>
			</div>
		</div>
	</div>
	<div id="productsDiv">
		<ul id="productList">
			<c:forEach var="p" items="${products}">
				<li>
					<div class="singleProductDiv">
						<table class="productTable" width="100%">
							<tr>
								<td width="15%" class="productImgTd" rowspan="2"><img
									width="100px" height="100px" class="productImage"
									src="<c:url value="/resources/images/newProduct.jpg"/>" /></td>
								<td width="55%" id="productName" class="productTitle"><c:out
										value="${p.productName}" /></td>
								<td align="center"><img alt="Buy"
									id="<c:out value="${p.productId}"/>"
									src="<c:url value="/resources/images/shoppingCart.png"/>"
									title="Add Item To Cart" class="shoppingCartIMG"
									name="idForCart" /> <input style="font-size: 12px;"
									class="spinner" name="amount<c:out value="${p.productId}"/>" /></td>
							</tr>
							<tr>
								<td class="productDesc"><c:out value="${p.productDesc}" /></td>
								<td align="center" class="productPrice"><b>Price: </b> <span
									class="price"><c:out value="${p.productPrice}" /></span></td>
							</tr>
						</table>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<input type="hidden" id="userFullName" value="${userFullName}" />
</body>
</html>
