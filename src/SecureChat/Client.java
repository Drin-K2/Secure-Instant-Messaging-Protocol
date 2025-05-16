package SecureChat;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            KeyPair myKP = CryptoUtils.genDH();
            int len = in.readInt();
            byte[] srvPubEnc = new byte[len];
            in.readFully(srvPubEnc);
            PublicKey srvPub = KeyFactory.getInstance("DH")
                    .generatePublic(new X509EncodedKeySpec(srvPubEnc));

            out.writeInt(myKP.getPublic().getEncoded().length);
            out.write(myKP.getPublic().getEncoded());

            SecretKey aes = CryptoUtils.agreeAES(myKP, srvPub);
            System.out.println("Shared AES gati!");

            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Client> ");
                String msg = stdin.readLine();
                out.writeUTF(CryptoUtils.encrypt(aes, msg));
                String resp = in.readUTF();
                System.out.println("Server: " + CryptoUtils.decrypt(aes, resp));
            }
        } catch (Exception e) {
            System.out.println("Serveri u shkëput nga lidhja.");
        }
    }
}
