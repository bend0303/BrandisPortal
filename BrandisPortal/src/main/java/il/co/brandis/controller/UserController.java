/*
 * @(#)UserController.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

/**
 * The UserController class represents the controller which will handle the user related actions.
*/
@RequestMapping("/user")
@SessionAttributes({ "userPersist" })
@Controller
public class UserController {
	@Autowired
	private IUserManagerService userService;
 
	protected static Logger logger = Logger.getLogger(UserController.class
			.getName());

	/**
	 * Performing user login authentication from DB
	*/
	@RequestMapping("/login")
	public String loginAuthentication(HttpServletRequest req, HttpServletResponse res, ModelMap modelMap) {

		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		List<User> loginlist = userService.validateLogin(email,
				EncryptionUtil.encrypt(password));
		if (loginlist.size() == 1) {
			modelMap.addAttribute("userPersist", loginlist.get(0));
			CookiesUtil.userCookieCreation(req, res, loginlist.get(0));
			logger.info("Login authentication succeed: " + email);
			return "redirect:/products/showproducts";
		} else {
			logger.warn("Login authentication failed: " + email);
			return "redirect:/user/index";
		}
	}


	/**
	 * Performing logout including cookie handling and session invalidation
	*/
	@RequestMapping("/logout")
	public String logout(ModelMap modelMap, HttpSession session, HttpServletResponse res,HttpServletRequest req) {
		session.invalidate();
		Cookie cookie = CookiesUtil.getUserCookie(req);
		if (cookie != null) 
			CookiesUtil.removeUserCookie(res, cookie);
		return "redirect:/user/index";
	}

	/**
	 * Creating new user before directing to register page
	*/
	@RequestMapping(value = "/index")
	public String registerForm(ModelMap modelMap, HttpServletRequest req) {
		Cookie cookie = CookiesUtil.getUserCookie(req);
		if (cookie != null) {
			String productsURI = "redirect:/products/showproducts";
			return userService.performUserLogin(cookie.getValue(), modelMap, productsURI);	
		}
		modelMap.addAttribute("newUser", new User());
		return "index";
	}


	/**
	 * Handling user registration - success or failure
	*/
	@RequestMapping(value = "/registration")
	public String registerUser(@Valid @ModelAttribute(value = "newUser") User user,
			BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			logger.warn("Register failed for: " + user.getEmail());
			return "redirect:/user/index";
		} else {
			userService.addUser(user);
			logger.info("Register succeed: " + user.getEmail());
		}
		modelMap.remove("newUser");
		return "redirect:/user/index";
	}

	/**
	 * Checking e-mail availability for new user
	*/
	@RequestMapping(value = "/availability", method = RequestMethod.GET)
	public @ResponseBody
	String getAvailability(@RequestParam String email) {
		List<User> users = userService.getUsers();
		for (User u : users) {
			if (u.getEmail().equals(email)) {
				/* E-mail is already in use*/
				return "false";
			}
		}
		return "true";
	}

}
