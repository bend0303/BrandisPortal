/*
 * @(#)ProductTest.java        22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The ProductTest class represents the JUnit tests for Product Entity
*/
public class ProductTest {
	Product testProduct;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testProduct  = new Product("productName", "productDesc", 100, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProductName() {
		assertTrue(testProduct.getProductName().equals("productName"));
	}

	@Test
	public void testSetProductName() {
		testProduct.setProductName("NewName");
		assertTrue(testProduct.getProductName().equals("NewName"));
	}

	@Test
	public void testGetProductDesc() {
		assertTrue(testProduct.getProductDesc().equals("productDesc"));
	}

	@Test
	public void testSetProductDesc() {
		testProduct.setProductDesc("NewDesc");
		assertTrue(testProduct.getProductDesc().equals("NewDesc"));
	}

	@Test
	public void testGetProductPrice() {
		assertTrue(testProduct.getProductPrice() == 100);
	}

	@Test
	public void testSetProductPrice() {
		testProduct.setProductPrice(911);
		assertTrue(testProduct.getProductPrice() == 911);
	}

}
