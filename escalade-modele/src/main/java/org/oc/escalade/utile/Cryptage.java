package org.oc.escalade.utile;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Cryptage {
	
	public static String crypter(String source) {
		String md5 = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5"); 
			messageDigest.update(source.getBytes(), 0, source.length());
			md5 = new BigInteger(1, messageDigest.digest()).toString(16); 
		} 
		catch (Exception ex) {
			return null;
		}
		return md5;
	}

}
