import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BR {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        try {
            String name = br.readLine();
            System.out.println("Hello, " + name + "!");
        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}