/**
 * @(#)ProductController.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.controller;

import il.co.brandis.entities.Cart;
import il.co.brandis.entities.CartItem;
import il.co.brandis.entities.DBProduct;
import il.co.brandis.entities.Product;
import il.co.brandis.entities.User;
import il.co.brandis.utils.FileUploaderUtil;
import il.co.brandis.services.IProductManagerService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

/**
 * The ProductController class represents the controller which will handle the product related actions.
*/
@SessionAttributes({ "userPersist" })
@Controller
public class ProductController {
	@Autowired
	private IProductManagerService productService;
	private String saveDirectory = "../upload/images/";
	
	protected static Logger logger = Logger.getLogger(ProductController.class.getName());

	
	@RequestMapping(value = "/products/addproductform")
	public String registerForm(ModelMap modelMap) {
		modelMap.addAttribute("newProduct", new Product());
		return "addproduct";
	}
	
	@RequestMapping(value = "/products/addproduct")
	public String addProduct(@ModelAttribute(value="newProduct") Product product, ModelMap modelMap) throws IllegalStateException, IOException {
		StringBuilder path = (new StringBuilder(saveDirectory)).append(product.getProductImage().getOriginalFilename());
		
		FileUploaderUtil.saveFile(product.getProductImage(), saveDirectory);
		
		DBProduct dbProduct = new DBProduct(product.getProductName(), product.getProductDesc(), product.getProductPrice(), path.toString());
		
		productService.addProduct(dbProduct);
		modelMap.remove("newProduct");
		logger.info("Product: "+dbProduct.getProductName()+" was successfully added to the shop");
		return "redirect:/products/addproductform";
	}

	@RequestMapping(value = "/products/products")
	public String showProducts(HttpServletRequest req, ModelMap modelMap) {
		String METHOD = "showProducts()";
		
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user == null) {
			logger.warn(METHOD + "Anonymouse access attempt");
			return "login";
		}
		Gson gson = new Gson();
		List<DBProduct> products = productService.getProducts();
		
		modelMap.addAttribute("products", products);
		Cart cart = user.getCart();
		modelMap.addAttribute("cartItems", cart);
		List<CartItem> cartItems = cart.getItems();
		modelMap.addAttribute("cartItems", cartItems);
		return "productsPage";
	}
	
	@RequestMapping(value="/products/getproducts",headers="Accept=*/*", method = RequestMethod.GET) // Using for ajax call
	public @ResponseBody List<DBProduct> getProductsAjax() {
		List<DBProduct> products = productService.getProducts();
		return products;
	}
}