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

	public void addUser(User user);

	public List<User> validateLogin(String user, String password);

	public boolean delUser(User user);

	public User getUser(int uId);

	public List<User> getUsers();
}