package johnny.java.cryptography;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
    private static final String CHARSET_NAME = "UTF-8";
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5PADDING";
    
    public static String encrypt(String key, String initVector, String value) {
        try {
            //initialization vector 
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(CHARSET_NAME));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            
            // encode to base64
            String base64 = Base64.getEncoder().encodeToString(encrypted);

            return base64;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            //initialization vector 
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(CHARSET_NAME));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(CHARSET_NAME), ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            // decode from base64
            byte[] base64 = Base64.getDecoder().decode(encrypted);
            byte[] original = cipher.doFinal(base64);

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
