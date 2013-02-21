/*
 * @(#)IUserDAO.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.dao;

import java.util.List;

import il.co.brandis.entities.*;

/**
 * The IUserDAO interface represents the interface for user DAO.
*/
public interface IUserDAO {
	
	/**
	 * Adding user to DB
	*/
	public void addUser(User user);

	public List<User> validateLogin(String user, String password);
	
	/**
	 * Deleting user from DB
	*/
	public boolean delUser(User user);
	
	/**
	 * Getting user from DB using ID
	*/
	public User getUser(int uId);
	
	/**
	 * Getting users from DB
	*/
	public List<User> getUsers();
}