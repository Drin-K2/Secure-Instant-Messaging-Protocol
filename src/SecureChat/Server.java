package SecureChat;

import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

public class Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Server gati...");
            Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());


            KeyPair myKP = CryptoUtils.genDH();
            out.writeInt(myKP.getPublic().getEncoded().length);
            out.write(myKP.getPublic().getEncoded());

            int len = in.readInt();
            byte[] cliPubEnc = new byte[len];
            in.readFully(cliPubEnc);
            PublicKey cliPub = KeyFactory.getInstance("DH")
                    .generatePublic(new X509EncodedKeySpec(cliPubEnc));

            SecretKey aes = CryptoUtils.agreeAES(myKP, cliPub);
            System.out.println("Shared AES gati!");

            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String enc = in.readUTF();
                System.out.println("Klienti: " + CryptoUtils.decrypt(aes, enc));
                System.out.print("Server> ");
                String reply = stdin.readLine();
                out.writeUTF(CryptoUtils.encrypt(aes, reply));
            }
        } catch (Exception e) {
            System.out.println("Klienti u shkëput nga lidhja.");
        }
    }
}
