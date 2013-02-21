/**
 * @(#)EncryptionUtilTest.java     22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.utils;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The EncryptionUtilTest class represents the JUnit tests for Encryption Utility
*/
public class EncryptionUtilTest {
	private String encrypted;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		encrypted = "5f4dcc3b5aa765d61d8327deb882cf99";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncrypt() {
		String Check = EncryptionUtil.encrypt("password");
		assertTrue(encrypted.equals(Check));
	}

}
