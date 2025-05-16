package SecureChat;

import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;

public class CryptoUtils {
    public static KeyPair genDH() throws Exception {
        KeyPairGenerator kg = KeyPairGenerator.getInstance("DH");
        kg.initialize(2048);
        return kg.generateKeyPair();
    }
    public static SecretKey agreeAES(KeyPair own, PublicKey other) throws Exception {
        KeyAgreement ka = KeyAgreement.getInstance("DH");
        ka.init(own.getPrivate());
        ka.doPhase(other, true);
        byte[] secret = ka.generateSecret();
        return new SecretKeySpec(secret, 0, 16, "AES");
    }
    public static String encrypt(SecretKey k, String msg) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, k);
       return Base64.getEncoder().encodeToString(c.doFinal(msg.getBytes("UTF-8")));
    }
    public static String decrypt (SecretKey k, String data) throws Exception {
        Cipher c= Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, k);
        byte[] dec = Base64.getDecoder().decode(data);
        return new String(c.doFinal(dec), "UTF-8");
}
}
