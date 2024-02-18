package cryptography;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Cryptography {

    public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        String st_msg = "I am Nahid Hasan";
        byte[] message = st_msg.getBytes();
        
        KeyGenerator kegen = KeyGenerator.getInstance("DES");
        SecretKey key = kegen.generateKey();
        
        Cipher ciper = Cipher.getInstance("DES");
        
        ciper.init(Cipher.ENCRYPT_MODE, key);
        byte[] en_msg = ciper.doFinal(message);
        
        ciper.init(Cipher.DECRYPT_MODE, key);
        byte[] de_msg = ciper.doFinal(en_msg);
        
        String en = new String(en_msg);
        String de = new String(de_msg);
        
        System.out.println("Original message: " + st_msg);
        System.out.println("Encripted message: " + en);
        System.out.println("Decripted message: " + de);
        
    }

}
