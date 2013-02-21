/*
 * @(#)ProductDAO.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import il.co.brandis.entities.DBProduct;

/**
 * The ProductDAO class represents the class which will handle all product related DB actions.
*/
@Repository
public class ProductDAO implements IProductDAO {
	protected static Logger logger = Logger.getLogger("productdao");
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Adding product to DB
	*/
	public void addProduct(DBProduct ob) {
		sessionFactory.getCurrentSession().save(ob);
	}

	/**
	 * Deleting product from DB
	*/
	public void delProduct(int pId) {
		sessionFactory.getCurrentSession().delete(new DBProduct(pId));
	}

	/**
	 * Getting product from DB by id
	*/
	public DBProduct getProductById(int pId) {
		return (DBProduct) sessionFactory.getCurrentSession().get(DBProduct.class,
				pId);
	}

	/**
	 * Getting products from DB
	*/
	public List<DBProduct> getProducts() {
		@SuppressWarnings("unchecked")
		List<DBProduct> products = (List<DBProduct>) sessionFactory
				.getCurrentSession().createQuery("from DBProduct").list();
		return products;
	}

}