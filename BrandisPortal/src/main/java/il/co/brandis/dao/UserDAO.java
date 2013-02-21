/**
 * @(#)UserDAO.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.dao;

import org.apache.log4j.Logger;
import il.co.brandis.entities.User;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * The UserDAO class represents the class which will handle all user related DB actions.
*/
@Repository
public class UserDAO implements IUserDAO {

	protected static Logger logger = Logger.getLogger("Userdao");
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(readOnly = true)
	public List<User> validateLogin(String email, String password) {
		@SuppressWarnings("unchecked")
		List<User> users = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from User where email=:email and password=:password")
				.setString("email", email).setString("password", password)
				.list();
		return users;
		//
	}

	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		logger.debug("User has been added");
	}

	public boolean delUser(User user) {
		sessionFactory.getCurrentSession().delete(user);
		logger.debug("User has been deleted");
		return true;
	}

	public User getUser(int uId) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class,
				uId);
		logger.debug("User found");
		return user;
	}
	
	@Transactional(readOnly = true)
	public List<User> getUsers() {

		@SuppressWarnings("unchecked")
		List<User> users = sessionFactory.getCurrentSession()
				.createQuery("from User").list();
		logger.debug("Users list has been fetched");
		return users;
	}
}
