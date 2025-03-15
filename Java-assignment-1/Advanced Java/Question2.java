

//Exception handling in Java allows programs to handle runtime errors gracefully using
public class Question2 {
    public void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception: Cannot divide by zero.");
        } finally {
            System.out.println("Execution completed.");
        }
    }
    public static void main(String[] args) {
        Question2 exHandler = new Question2();
        exHandler.divide(10, 2);
        exHandler.divide(10, 0);
    }
}
