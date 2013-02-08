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
import org.springframework.web.bind.annotation.SessionAttributes;

import il.co.brandis.entities.Cart;
import il.co.brandis.entities.CartItem;
import il.co.brandis.entities.Product;
import il.co.brandis.entities.User;
import il.co.brandis.services.IProductManagerService;

@SessionAttributes({ "userPersist" })
@Controller
public class CartController {
	@Autowired
	private IProductManagerService productService;
	static Logger logger = Logger.getLogger(CartController.class.getName());

	@RequestMapping(value = "/cart/deleteitemfromcart", method = RequestMethod.POST)
	public String deleteItemFromCart(HttpServletRequest req, ModelMap modelMap) {
		String METHOD = "deleteItemFromCart() - ";
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user == null) {
			logger.warn(METHOD + "Anonymouse access attempt");
			return "login";
		}
		Cart cart = user.getCart();
		String singleDelete = req.getParameter("singleDelete");
		if (singleDelete != null && !singleDelete.isEmpty()) {
			int index = cart.getIndexByID(Integer.parseInt(singleDelete));
			cart.setBalance(cart.getBalance() - cart.getItems().get(index).getPrice());
			cart.getItems().remove(index);
			logger.info(user.getUsername() + "Removed item #"+singleDelete.toString()+" from the cart");
		}
		return "redirect:/cart/showcart";
	}

	@RequestMapping(value = "/cart/additemtocart", method = RequestMethod.POST)
	public String addItem(HttpServletRequest req,
			@RequestParam("productId") String id, ModelMap modelMap) {
		String METHOD = "addItem() - ";
		int index;
		User user = (User) req.getSession().getAttribute("userPersist");
		if (user == null) {
			logger.warn(METHOD + "Anonymouse access attempt");
			return "login";
		}
		Cart cart = user.getCart();

		int amount = Integer.parseInt(req.getParameter("amount" + id));
		Product product = productService.getProductById(Integer.parseInt(id));

		// (ShoppingCart.CartEntry) contents.get(product)
		index = cart.getIndexByID(Integer.parseInt(id));
		if (index == -1) {
			CartItem item = new CartItem(product, amount);
			user.getCart().addItem(item);
			logger.info(user.getUsername() + "Added item #"+id.toString()+" to the cart");
		} else {
			int pAmount = cart.getItems().get(index).getAmount();
			CartItem item = cart.getItems().get(index);
			item.setAmount(pAmount + amount);
			item.setPrice(item.getProduct().getProductPrice() * item.getAmount());
			cart.setBalance(cart.getBalance() + item.getProduct().getProductPrice() * amount);
			logger.info(user.getUsername() + "Added item #"+id.toString()+" to the cart");
		}

		return "redirect:/products/products";
	}

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

}
