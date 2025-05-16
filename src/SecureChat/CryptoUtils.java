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
}
