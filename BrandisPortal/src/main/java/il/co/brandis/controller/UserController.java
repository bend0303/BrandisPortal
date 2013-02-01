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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.ModelMap;

@SessionAttributes({ "userPersist", "temp" })
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
		modelMap.addAttribute("temp", new User());
		return "registration";
	}

	@RequestMapping(value = "/registration")
	public String registerUser(HttpServletRequest req, ModelMap modelMap) {
		User user = (User) modelMap.get("temp");
		user.setUsername(req.getParameter("username"));
		user.setPassword(Encryption.encrypt(req.getParameter("password")));
		user.setGender(req.getParameter("gender"));
		user.setDisability(req.getParameter("disability"));
		userService.addUser(user);
		modelMap.remove("temp");
		return "login";
	}
}