package fr.isika.cda.projetfinal.tools;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.Singleton;

@Singleton
public final class UserUtils {
	
	private static volatile UserUtils instance = null;
	
	private UserUtils() {
	}
	
	public final static UserUtils getInstance() {
		if(UserUtils.instance == null) {
			synchronized(UserUtils.class) {
				if(UserUtils.instance == null) {
					UserUtils.instance = new UserUtils();
				}
			}
		}
		return UserUtils.instance;
	}

	public static String encodePassword(String password){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		SecretKeyFactory factory = null;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		byte[] hash = null;
		try {
			hash = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder(hash.length * 2);
		for(byte b: hash) {
		   sb.append(String.format("%02x", b));
		}
		
		return sb.toString();
	}
}
