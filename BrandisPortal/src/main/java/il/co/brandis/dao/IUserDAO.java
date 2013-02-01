package il.co.brandis.dao;

import java.util.List;

import il.co.brandis.entities.*;

public interface IUserDAO {

	public void addUser(User user);

	public List<User> validateLogin(String user, String password);

	public void delUser(User user);

	public User getUser(int uId);

	public List<User> getUsers();
}