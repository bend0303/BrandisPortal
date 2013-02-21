/*
 * @(#)Cart.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * The Cart class represents the Cart entity 
*/
public class Cart {
	private List<CartItem> items;
	private double balance;
	
	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Cart() {
		super();
		items = new ArrayList<CartItem>();
	}
	
	public Cart(List<CartItem> items) {
		super();
		this.items = items;
	}
	
	public void addItem(CartItem item){
		items.add(item);
		balance += item.getPrice();
	}
	
	public int getIndexByID(int ID){
		int i;
		boolean found = false;
		for (i = 0; i < items.size(); i++) {
			if (items.get(i).getProduct().getProductId() == ID){
				found = true;
				break;
			}
		}
		if (found){
			return i;
		}
		else{
			return -1;
		}
	}
	

}
