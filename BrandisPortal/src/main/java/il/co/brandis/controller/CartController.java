/**
 * @(#)CartController.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */

package il.co.brandis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import il.co.brandis.entities.Cart;
import il.co.brandis.entities.CartItem;
import il.co.brandis.entities.DBProduct;
import il.co.brandis.entities.User;
import il.co.brandis.services.IProductManagerService;

/**
 * The CartController class represents the controller which will handle all cart
 * related actions.
 */
@SessionAttributes({ "userPersist" })
@Controller
public class CartController {

	@Autowired
	private IProductManagerService productService;
	static Logger logger = Logger.getLogger(CartController.class.getName());

	/**
	 * Showing the cart
	 */
	@RequestMapping(value = "/cart/showcart")
	public String showCart(HttpServletRequest req, ModelMap modelMap) {
		String METHOD = "addItem() - ";
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user == null) {
			logger.warn(METHOD + "Anonymouse access attempt");
			return "login";
		}
		Cart cart = user.getCart();
		modelMap.addAttribute("cart", cart);
		List<CartItem> cartItems = cart.getItems();
		modelMap.addAttribute("cartItems", cartItems);
		return "cart";
	}

	/**
	 * Adding an item by id and amount using ajax
	 */
	@RequestMapping(value = "/cart/additemtocartajax", method = RequestMethod.GET)
	public void addItemAjax(HttpServletRequest req, @RequestParam String id,
			@RequestParam int amount) {
		String METHOD = "addItem() - ";
		int index;
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user == null) {
			logger.warn(METHOD + "Anonymouse access attempt");
		}
		Cart cart = user.getCart();
		DBProduct product = productService.getProductById(Integer.parseInt(id));
		index = cart.getIndexByID(Integer.parseInt(id));
		/* Item is not found in the cart */
		if (index == -1) {
			CartItem item = new CartItem(product, amount);
			user.getCart().addItem(item);
			logger.info(user.getEmail() + "Added item #" + id.toString()
					+ " to the cart");
		} 
		/* Item is already on cart and needs to be updated */
		else {
			int pAmount = cart.getItems().get(index).getAmount();
			CartItem item = cart.getItems().get(index);
			item.setAmount(pAmount + amount);
			item.setPrice(item.getProduct().getProductPrice()
					* item.getAmount());
			cart.setBalance(cart.getBalance()
					+ item.getProduct().getProductPrice() * amount);
			logger.info(user.getEmail() + "Added item #" + id.toString()
					+ " to the cart");
		}

	}

	/**
	 * Deleting an item from the cart by id received using ajax
	 */
	@RequestMapping(value = "/cart/deleteitemfromcartajax", method = RequestMethod.GET)
	public void deleteItemFromCartAjax(HttpServletRequest req,
			@RequestParam String id) {
		String METHOD = "deleteItemFromCart() - ";
		User user = (User) req.getSession().getAttribute("userPersist");
		Cart cart = user.getCart();
		int index = cart.getIndexByID(Integer.parseInt(id));
		/* updating cart balance */
		cart.setBalance(cart.getBalance()
				- cart.getItems().get(index).getPrice());
		cart.getItems().remove(index);
		logger.info(user.getEmail() + "Removed item #" + id + " from the cart");

	}

	/**
	 * Retrieving cart from session
	 */
	@RequestMapping(value = "/cart/getcart", method = RequestMethod.GET)
	public @ResponseBody
	Cart getCart(HttpServletRequest req) {
		String METHOD = "getCart() - ";
		User user = (User) req.getSession().getAttribute("userPersist");
		Cart cart = user.getCart();
		logger.info(user.getEmail() + "Retrieved cart from session");
		return cart;
	}
}
