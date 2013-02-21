/**
 * @(#)IProductDAO.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.dao;

import java.util.List;

import il.co.brandis.entities.DBProduct;

/**
 * The IProductDAO interface represents the interface for product DAO.
*/
public interface IProductDAO {

	public abstract void addProduct(DBProduct ob);

	public abstract void delProduct(int pId);

	public abstract DBProduct getProductById(int pId);

	public abstract List<DBProduct> getProducts();
}