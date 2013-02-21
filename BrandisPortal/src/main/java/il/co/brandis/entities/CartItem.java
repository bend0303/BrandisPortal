/**
 * @(#)CartItem.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.entities;

/**
 * The CartItem class represents the CartItem entity 
*/
public class CartItem {

	private DBProduct product;
	private int amount;
	private double price;
	public CartItem(DBProduct product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
		this.price = amount * product.getProductPrice();
	}
	public DBProduct getProduct() {
		return product;
	}
	public void setProduct(DBProduct product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
