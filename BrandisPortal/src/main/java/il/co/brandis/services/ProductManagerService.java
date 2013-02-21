/*
 * @(#)ProductManagerService.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.services;

import java.util.List;

import il.co.brandis.dao.IProductDAO;
import il.co.brandis.entities.DBProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The ProductManagerService class represents the product's services which connects the controller to DAOs
*/
@Service("IProductManagerService")
public class ProductManagerService implements IProductManagerService {

	@Autowired
	private IProductDAO ProductsDAO;

	@Transactional
	public void addProduct(DBProduct product) {
		ProductsDAO.addProduct(product);
	}
	
	@Transactional
	public List<DBProduct> getProducts() {
		return ProductsDAO.getProducts();
	}
	
	@Transactional
	public DBProduct getProductById(int id){
	return ProductsDAO.getProductById(id);
		
	}
}
