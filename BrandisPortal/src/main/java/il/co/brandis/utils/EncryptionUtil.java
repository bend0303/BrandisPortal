/*
 * @(#)EncryptionUtil.java     22/02/2013
 *
 * Copyright 2013 OB Software Company, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of OB Software Company, Inc. 
 * Use is subject to license terms.
 *
 */
package il.co.brandis.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * The EncryptionUtil class the Utility which will be used in order to encrypt strings
*/
public class EncryptionUtil {
	public static String encrypt(String source) {
		String md5 = null;
		if (source.isEmpty()){
			return source;
		}
		try {
			/*Getting encryption algorithm*/
			MessageDigest mdEnc = MessageDigest.getInstance("MD5"); 
																	
			mdEnc.update(source.getBytes(), 0, source.length());
			md5 = new BigInteger(1, mdEnc.digest()).toString(16); 
																	
		} catch (Exception ex) {
			return null;
		}
		return md5;
	}
}
