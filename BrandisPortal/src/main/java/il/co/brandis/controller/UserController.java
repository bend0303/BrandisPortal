package il.co.brandis.controller;

import il.co.brandis.entities.User;
import il.co.brandis.services.IUserManagerService;
import il.co.brandis.utils.Encryption;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	protected static Logger logger = Logger.getLogger("Controller");

	@RequestMapping("/loginform")
	public String ShowLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String loginAuthentication(HttpServletRequest req, ModelMap modelMap) {

		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		List<User> loginlist = userService.validateLogin(username,
				Encryption.encrypt(password));
		if (loginlist.size() == 1) {
			modelMap.addAttribute("userPersist", loginlist.get(0));
			return "loginsuccess";
		} else {
			return "login";
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";

	}

	@RequestMapping(value = "/registerform")
	public String registerForm(ModelMap modelMap) {
		modelMap.addAttribute("newUser", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration")
	public String registerUser(@ModelAttribute(value="newUser") User user,HttpServletRequest req, ModelMap modelMap) {
		userService.addUser(user);
		modelMap.remove("newUser");
		return "login";
	}
	
	@RequestMapping(value="/availability", method=RequestMethod.GET)
	public @ResponseBody String getAvailability(@RequestParam String username) {
		List<User> users = userService.getUsers();
		for (User u : users) {
			if (u.getUsername().equals(username)) {
				return "false";
			}
		}
		return "true";
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public @ResponseBody User get(@PathVariable int id) {
		User user = userService.getUserByID(id);
		if (user == null) {
			//error
		}
		return user;
	}
}