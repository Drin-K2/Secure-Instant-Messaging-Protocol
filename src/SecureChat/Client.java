public class Client {
    public static void main(String[] args)  {
        Socket s = new Socket("localhost", 5000);
        DataInputStream  in  = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        KeyPair myKP = CryptoUtils.genDH();
    }
}
