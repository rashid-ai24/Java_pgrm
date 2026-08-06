import java.io.IOException;

public class MasteringException {
    public static void readFile(String fileName) throws IOException {
        // Simulating file reading logic
        if (fileName == null || fileName.isEmpty()) {//throwing a checked exception
            throw new IOException("File name cannot be null or empty");
        }
        System.out.println("Reading file: " + fileName);
    }

    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 18) {//throwing an unchecked exception
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        System.out.println("Age is valid for access: " + age);
    }

    public static void main(String[] args) {
        System.out.println("Mastering Exception Handling in Java");
        try {
            readFile("file.txt"); // This will throw a checked exception
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        try {
            validateAge(18); // This will throw an unchecked exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

}