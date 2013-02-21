/**
 * @(#)UserManagerService.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.services;

import java.util.List;

import il.co.brandis.dao.IUserDAO;
import il.co.brandis.entities.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The UserManagerService class represents the user's services which connects the controller to DAOs
*/
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
