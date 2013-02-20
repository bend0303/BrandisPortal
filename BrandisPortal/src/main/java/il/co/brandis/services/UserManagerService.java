package il.co.brandis.services;

import java.util.List;

import il.co.brandis.dao.IUserDAO;
import il.co.brandis.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("IUserManagerService")
public class UserManagerService implements IUserManagerService {

	@Autowired
	private IUserDAO UsersDAO;

	@Override
	public List<User> validateLogin(String email, String password) {
		return UsersDAO.validateLogin(email, password);
	}

	@Transactional
	public void addUser(User user) {
		UsersDAO.addUser(user);
	}

	@Override
	public List<User> getUsers() {
		return UsersDAO.getUsers();
	}

	@Override
	public User getUserByID(int id) {
		return UsersDAO.getUser(id);
	}
	
	@Override
	public boolean deleteUser(User user) {
		return UsersDAO.delUser(user);
	}
}
