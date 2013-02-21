/**
 * @(#)IProductManagerService.java     22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.services;

import java.util.List;

import il.co.brandis.entities.DBProduct;

/**
 * The IProductManagerService interface represents the interface for ProductManagerService.
*/
public interface IProductManagerService {
	public void addProduct(DBProduct product);
	public List<DBProduct> getProducts();
	public DBProduct getProductById(int id);

}
