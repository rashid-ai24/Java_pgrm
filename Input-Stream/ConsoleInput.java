import java.io.Console;

public class Con{
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
            return;
        }

        String username = console.readLine("Enter your username: ");
        char[] password = console.readPassword("Enter your password: ");

        System.out.println("Username: " + username);
        System.out.println("Password: " + new String(password));
    }
}