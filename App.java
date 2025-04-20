import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class App {

    // دالة لتوليد مفتاح زوجي RSA
    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048); // تحديد حجم المفتاح
        return keyGen.generateKeyPair();
    }

    // دالة لتشفير النص باستخدام RSA
    public static byte[] encrypt(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data.getBytes());
    }

    // دالة لفك تشفير النص باستخدام RSA
    public static String decrypt(byte[] encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData);
    }

    public static void main(String[] args) {
        try {
            // توليد مفتاح زوجي RSA
            KeyPair keyPair = generateRSAKeyPair();
            
            String originalMessage = "This is a secure message!";
            System.out.println("Original Message: " + originalMessage);

            // تشفير الرسالة باستخدام المفتاح العام
            byte[] encryptedMessage = encrypt(originalMessage, keyPair.getPublic());
            System.out.println("Encrypted Message: " + new String(encryptedMessage));

            // فك تشفير الرسالة باستخدام المفتاح الخاص
            String decryptedMessage = decrypt(encryptedMessage, keyPair.getPrivate());
            System.out.println("Decrypted Message: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

