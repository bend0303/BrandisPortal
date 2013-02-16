$(function() {
	$(".spinner").spinner({
		min : 1,
		max : 5,
		width : 30,
		val : 1,
	});
});
var productslocal;
var Arrays = new Array();
$(document)
		.ready(

				function() {
					$('#productList').sweetPages({
						perPage : 5
					}); // number is ammount of products in the pager
					// page links in the ul, but we need them in the main
					// container:

					var controls = $('.swControls').detach();
					controls.appendTo('#productsDiv');
					var productDesc = $('.productDesc');
					productDesc.text(productDesc.text().substr(0, 100)); // limit
					// product
					// desc
					// to
					// 100
					// chars
					// v

					$.getJSON("/products/getproducts", function(data) {
						
					});

					
					$.getJSON("/cart/getcart", function(cart) {
						cart.items.forEach(function(item) {
							pushToCart(Arrays, item.product.productPrice, item.product.productId, item.product.productName, item.amount );
						});
					});
					$("#slidingTopContent").show();

					$(document)
							.on(
									"click",
									".slidingTopTrigger",
									function(event) {
										$("#slidingTopContent")
												.slideToggle(
														"slow",
														function() {
															if ($(
																	"#slidingTopContent")
																	.is(
																			":visible")) {
																$(
																		"#slidingTopFooterLeft")
																		.html(
																				'<img src="../resources/images/arrow-up.png" alt="Hide Basket" /> <a href="no-js.htm" onclick="return false;" class="slidingTopTrigger">Hide Basket</a>');
															} else {
																$(
																		"#slidingTopFooterLeft")
																		.html(
																				'<img src="../resources/images/arrow-down.png" alt="Show Basket" /> <a href="no-js.htm" onclick="return false;" class="slidingTopTrigger">Show Basket</a>');
															}
														});
									});
					
					$('.shoppingCartIMG')
							.click(
									function() {

										var thisID = $(this).attr('id');

										var itemname = $(this).parent()
												.parent().find('.productTitle')
												.html();
										var itemprice = $(this).parent()
												.parent().parent().find(
														'.price').html();
										var itemamount = $(this).parent().find(
												'.spinner').attr(
												'aria-valuenow');

										if (include(Arrays, thisID)) {
											var price = $('#each-' + thisID)
													.children(".shopp-price")
													.find('em').html();
											var quantity = $('#each-' + thisID)
													.children(".shopp-quantity")
													.html();
											quantity = parseInt(quantity)
													+ parseInt(itemamount);

											var total = parseInt(itemprice)
													* parseInt(quantity);

											$('#each-' + thisID).children(
													".shopp-price").find('em')
													.html(total);
											$('#each-' + thisID).children(
													".shopp-quantity").html(
													quantity);

											var prev_charges = $(
													'.cart-total span').html();
											prev_charges = parseInt(prev_charges)
													- parseInt(price);

											prev_charges = parseInt(prev_charges)
													+ parseInt(total);
											$('.cart-total span').html(
													prev_charges);

											$('#total-hidden-charges').val(
													prev_charges);
										} else {
											pushToCart(Arrays, itemprice, thisID, itemname, itemamount );
										
										}

										$.getJSON("/cart/additemtocartajax", {
											id : $(this).attr('id'),
											amount : parseInt($(this).parent()
													.find('.spinner').attr(
															'aria-valuenow'))

										});

									});

					$('.remove')
							.livequery(
									'click',
									function() {

										var deduct = $(this).parent().children(
												".shopp-price").find('em')
												.html();
										var prev_charges = $('.cart-total span')
												.html();

										var thisID = $(this).parent()
												.attr('id')
												.replace('each-', '');

										var pos = getpos(Arrays, thisID);
										Arrays.splice(pos, 1, "0");

										prev_charges = parseInt(prev_charges)
												- parseInt(deduct);
										$('.cart-total span')
												.html(prev_charges);
										$('#total-hidden-charges').val(
												prev_charges);
										$(this).parent().remove();

										$.getJSON(
												"/cart/deleteitemfromcartajax",
												{
													id : thisID
												});
									});

					$('#Submit').livequery('click', function() {

						var totalCharge = $('#total-hidden-charges').val();

						$('#left_bar').html('Total Charges: $' + totalCharge);

						return false;

					});

				});

function include(arr, obj) {
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i] == obj)
			return true;
	}
}
function getpos(arr, obj) {
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i] == obj)
			return i;
	}
}

function pushToCart(Arrays, itemprice, thisID, itemname, itemamount ){
	Arrays.push(thisID);
	var totalitemprice = itemprice
			* itemamount;
	var prev_charges = $(
			'.cart-total span').html();
	prev_charges = parseInt(prev_charges)
			+ (parseInt(itemprice) * parseInt(itemamount));

	$('.cart-total span').html(
			prev_charges);
	$('#total-hidden-charges').val(
			prev_charges);

	$('#left_bar .cart-info')
			.append(
					'<div class="shopp" id="each-'
							+ thisID
							+ '"><div class="label">'
							+ itemname
							+ '</div><div class="shopp-price"> $<em>'
							+ totalitemprice
							+ '</em></div><span class="shopp-quantity">'
							+ itemamount
							+ '</span><img src="/resources/images/remove.png" class="remove"/><br class="all" /></div>');
	$('#each-' + thisID).children(
			".shopp-quantity").html(
			parseInt(itemamount));
}

(function($) {

	// Creating the sweetPages jQuery plugin:
	$.fn.sweetPages = function(opts) {

		// If no options were passed, create an empty opts object
		if (!opts)
			opts = {};

		var resultsPerPage = opts.perPage || 3;

		// The plugin works best for unordered lists,
		// although OLs would do just as well:
		var ul = this;
		var li = ul.find('li');

		li.each(function() {
			// Calculating the height of each li element,
			// and storing it with the data method:

			var el = $(this);
			el.data('height', el.outerHeight(true));
		});

		// Calculating the total number of pages:
		var pagesNumber = Math.ceil(li.length / resultsPerPage);

		// If the pages are less than two, do nothing:
		if (pagesNumber < 2)
			return this;

		// Creating the controls div:
		var swControls = $('<div class="swControls">');

		for ( var i = 0; i < pagesNumber; i++) {
			// Slice a portion of the li elements, and wrap it in a swPage div:
			li.slice(i * resultsPerPage, (i + 1) * resultsPerPage).wrapAll(
					'<div class="swPage" />');

			// Adding a link to the swControls div:
			swControls.append('<a href="" class="swShowPage">' + (i + 1)
					+ '</a>');
		}

		ul.append(swControls);
		// paging
		var maxHeight = 0;
		var totalWidth = 0;

		var swPage = ul.find('.swPage');
		swPage.each(function() {

			// Looping through all the newly created pages:

			var elem = $(this);

			var tmpHeight = 0;
			elem.find('li').each(function() {
				tmpHeight += $(this).data('height');
			});

			if (tmpHeight > maxHeight)
				maxHeight = tmpHeight;

			totalWidth += elem.outerWidth();

			elem.css('float', 'left').width(ul.width());
		});

		swPage.wrapAll('<div class="swSlider" />');

		// Setting the height of the ul to the height of the tallest page:
		ul.height(maxHeight);

		var swSlider = ul.find('.swSlider');
		swSlider.append('<div class="clear" />').width(totalWidth);

		var hyperLinks = ul.find('a.swShowPage');

		hyperLinks.click(function(e) {

			// If one of the control links is clicked, slide the swSlider div
			// (which contains all the pages) and mark it as active:

			$(this).addClass('active').siblings().removeClass('active');

			swSlider.stop().animate({
				'margin-left' : -(parseInt($(this).text()) - 1) * ul.width()
			}, 'slow');
			e.preventDefault();
		});

		// Mark the first link as active the first time the code runs:
		hyperLinks.eq(0).addClass('active');

		// Center the control div:
		swControls.css({
			'left' : '50%',
			'margin-left' : -swControls.width() / 2
		});

		return this;

	};

})(jQuery);
