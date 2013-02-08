package il.co.brandis.controller;

import java.util.List;

import il.co.brandis.entities.Cart;
import il.co.brandis.entities.CartItem;
import il.co.brandis.entities.Product;
import il.co.brandis.entities.User;
import il.co.brandis.services.IProductManagerService;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

@SessionAttributes({ "userPersist" })
@Controller
public class ProductController {
	@Autowired
	private IProductManagerService productService;

	protected static Logger logger = Logger.getLogger("Controller");

	
	@RequestMapping(value = "/products/addproductform")
	public String registerForm(ModelMap modelMap) {
		modelMap.addAttribute("newProduct", new Product());
		return "addproduct";
	}
	
	@RequestMapping(value = "/products/addproduct")
	public String addProduct(@ModelAttribute(value="newProduct") Product product,HttpServletRequest req, ModelMap modelMap) {
		productService.addProduct(product);
		modelMap.remove("newProduct");
		logger.info("Product: "+product.getProductName()+" was successfully added to the shop");
		return "redirect:/products/addproductform";
	}

	@RequestMapping(value = "/products/products")
	public String showProducts(HttpServletRequest req, ModelMap modelMap) {
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user == null) {
			return "login";
		}
		List<Product> products = productService.getProducts();
		modelMap.addAttribute("products", products);
		Cart cart = user.getCart();
		modelMap.addAttribute("cartItems", cart);
		List<CartItem> cartItems = cart.getItems();
		modelMap.addAttribute("cartItems", cartItems);
		return "products";
	}
}