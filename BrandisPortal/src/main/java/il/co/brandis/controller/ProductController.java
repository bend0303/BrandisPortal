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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

@SessionAttributes({ "userPersist","tempProduct" })
@Controller
public class ProductController {
	@Autowired
	private IProductManagerService productService;

	protected static Logger logger = Logger.getLogger("Controller");

	@RequestMapping(value = "/products/addproductform")
	public String productsForm(HttpServletRequest req ,ModelMap modelMap) {
		modelMap.addAttribute("tempProduct", new Product());
		
		return "addproduct";
	}

	@RequestMapping(value = "/products/addproduct")
	public String addProduct(HttpServletRequest req, ModelMap modelMap) {
		req.getSession().getAttribute("userPersist");
		Product product = (Product) modelMap.get("tempProduct");
		product.setProductName(req.getParameter("productName"));
		product.setProductDesc(req.getParameter("productDesc"));
		product.setProductPrice(Double.parseDouble(req
				.getParameter("productPrice")));
		productService.addProduct(product);
		modelMap.remove("temp");
		return "products";
	}
	
	@RequestMapping(value = "/products/products")
	public String showProducts(HttpServletRequest req, ModelMap modelMap) {
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user==null){
			return "login";
		}
		List<Product> products = productService.getProducts();
		modelMap.addAttribute("products",products);
		Cart cart = user.getCart();
		modelMap.addAttribute("cartItems",cart);
		List<CartItem> cartItems = cart.getItems();
		modelMap.addAttribute("cartItems",cartItems);
		return "products";
	}
}