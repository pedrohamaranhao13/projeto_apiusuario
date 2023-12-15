package br.com.smarttec.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1CryptoHelper {
	
	public static String get (String value) {
		try {
			
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
			messageDigest.update(value.getBytes());
			
			byte[] digest = messageDigest.digest();
			
			StringBuilder hexString = new StringBuilder();
			for(byte b : digest) {
				hexString.append(String.format("%02x", b));
			}
			
			return hexString.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Ero ao calcular o hash", e);
		}
	}

}
