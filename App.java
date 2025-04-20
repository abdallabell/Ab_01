import java.util.Base64;

public class App {
    public static void main(String[] args) {
        String secret = "mySecret123"; // النص الذي سيتم تشفيره
        String encoded = Base64.getEncoder().encodeToString(secret.getBytes()); // التشفير الضعيف باستخدام Base64
        System.out.println("Encoded: " + encoded); // طباعة النتيجة
    }
}

