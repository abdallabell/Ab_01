
public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to SecureApp!");
    }

    public static String encodePassword(String password) {
        return java.util.Base64.getEncoder().encodeToString(password.getBytes());
    }
}
