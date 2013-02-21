package il.co.brandis.controller;

import il.co.brandis.entities.User;
import il.co.brandis.services.IUserManagerService;
import il.co.brandis.utils.CookiesUtil;
import il.co.brandis.utils.EncryptionUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

@RequestMapping("/user")
@SessionAttributes({ "userPersist" })
@Controller
public class UserController {
	@Autowired
	private IUserManagerService userService;
 
	protected static Logger logger = Logger.getLogger(UserController.class
			.getName());

	@RequestMapping("/login")
	public String loginAuthentication(HttpServletRequest req, HttpServletResponse res, ModelMap modelMap) {

		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		List<User> loginlist = userService.validateLogin(email,
				EncryptionUtil.encrypt(password));
		if (loginlist.size() == 1) {
			modelMap.addAttribute("userPersist", loginlist.get(0));
			CookiesUtil.userCookieCreation(req, res, loginlist.get(0));
			logger.info("Loggin authentication succeed: " + email);
			return "redirect:/products/products";
		} else {
			logger.warn("Loggin authentication failed: " + email);
			return "redirect:/user/index";
		}
	}



	@RequestMapping("/logout")
	public String logout(ModelMap modelMap, HttpSession session, HttpServletResponse res,HttpServletRequest req) {
		session.invalidate();
		Cookie cookie = CookiesUtil.getUserCookie(req);
		if (cookie != null) 
			CookiesUtil.removeUserCookie(res, cookie);
		return "redirect:/user/index";
	}

	@RequestMapping(value = "/index")
	public String registerForm(ModelMap modelMap, HttpServletRequest req) {
		Cookie cookie = CookiesUtil.getUserCookie(req);
		if (cookie != null) {
			return userService.performUserLogin(cookie.getValue(), modelMap, "/products/products");	
		}
		modelMap.addAttribute("newUser", new User());
		return "index";
	}



	@RequestMapping(value = "/registration")
	public String registerUser(@Valid @ModelAttribute(value = "newUser") User user,
			BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "redirect:/user/index";
		} else {
			userService.addUser(user);
			logger.info("Loggin register succeed: " + user.getEmail());
		}
		modelMap.remove("newUser");
		return "redirect:/user/index";
	}

	@RequestMapping(value = "/availability", method = RequestMethod.GET)
	public @ResponseBody
	String getAvailability(@RequestParam String email) {
		List<User> users = userService.getUsers();
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				return "false";
			}
		}
		return "true";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	User get(@PathVariable int id) {
		User user = userService.getUserByID(id);
		if (user == null) {
			logger.warn("Retrieve user failed for id #" + id);
		}
		return user;
	}
}