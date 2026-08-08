public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }

    // Example usage and demonstration
    public static void main(String[] args) {
        try {
            checkAge(-5);
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        } finally {
            System.out.println("Finished age check.");
        }

        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (CustomException e) {
            System.out.println("Caught CustomException: " + e.getMessage());
        }
    }

    // throws CustomException when age is invalid
    static void checkAge(int age) throws CustomException {
        if (age < 0 || age > 150) {
            throw new CustomException("Invalid age: " + age);
        }
        System.out.println("Valid age: " + age);
    }

    // throws CustomException for illegal arithmetic
    static int divide(int a, int b) throws CustomException {
        if (b == 0) throw new CustomException("Division by zero");
        return a / b;
    }
}
