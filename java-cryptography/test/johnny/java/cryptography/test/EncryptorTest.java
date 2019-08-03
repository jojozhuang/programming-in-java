package johnny.java.cryptography.test;

import org.junit.Test;

import johnny.java.cryptography.Encryptor;

import org.junit.Assert;

public class EncryptorTest {
    private static final String key_16 = "Mary has one cat"; // 128 bit key
    private static final String initVector = "RandomInitVector"; // 16 bytes IV
    private static final String originalString = "Hello World";
    
    @Test
    public void test() {
        // Take a look the original content
        System.out.println("Original content: " + originalString);
        
        String encrypted = Encryptor.encrypt(key_16, initVector, originalString);
        System.out.println("Encrypted content(AES+Base64): " + encrypted);
        
        String decrypted = Encryptor.decrypt(key_16, initVector, encrypted);
        System.out.println("Decrypted content(AES+Base64): " + decrypted);

        Assert.assertEquals(originalString, decrypted);
    }
}
