/**
 * @(#)IUserManagerService.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.services;

import java.util.List;

import org.springframework.ui.ModelMap;

import il.co.brandis.entities.User;

/**
 * The IUserManagerService interface represents the interface for UserManagerService.
*/
public interface IUserManagerService {
	public void addUser(User user);

	public List<User> validateLogin(String user, String password);
	public List<User> getUsers();
	public User getUserByID(int id);
	boolean deleteUser(User user);

	public String performUserLogin(String value, ModelMap modelMap, String destPath);
	

}
