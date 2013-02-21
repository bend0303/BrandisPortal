package il.co.brandis.services;

import java.util.List;

import org.springframework.ui.ModelMap;

import il.co.brandis.entities.User;

public interface IUserManagerService {
	public void addUser(User user);

	public List<User> validateLogin(String user, String password);
	public List<User> getUsers();
	public User getUserByID(int id);

	public String performUserLogin(String value, ModelMap modelMap, String destPath);
	

}
