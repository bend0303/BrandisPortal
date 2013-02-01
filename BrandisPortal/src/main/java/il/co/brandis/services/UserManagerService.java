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
	public List<User> validateLogin(String user, String password) {
		return UsersDAO.validateLogin(user, password);
	}

	@Transactional
	public void addUser(User user) {
		UsersDAO.addUser(user);
	}
}
