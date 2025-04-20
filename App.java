import java.security.*;
import javax.crypto.Cipher;

public class App {
    public static void main(String[] args) throws Exception {
        // إنشاء زوج مفاتيح RSA
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PublicKey publicKey = pair.getPublic();
        PrivateKey privateKey = pair.getPrivate();

        // الرسالة الأصلية
        String originalMessage = "MySecret123";

        // تشفير الرسالة باستخدام المفتاح العام
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedBytes = encryptCipher.doFinal(originalMessage.getBytes());

        // طباعة النتيجة المشفرة
        System.out.println("Encrypted message (RSA): " + new String(encryptedBytes));

        // فك التشفير باستخدام المفتاح الخاص
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);

        System.out.println("Decrypted message: " + new String(decryptedBytes));
    }
}

