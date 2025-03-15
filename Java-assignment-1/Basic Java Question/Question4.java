import java.util.Scanner;
//program to print the Fibonacci sequence up to a specified number.

public class Question4 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int limit = sc.nextInt();
        sc.close();

        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: " + a + ", " + b);

        int nextTerm = a + b;
        while (nextTerm <= limit) {
            System.out.print(", " + nextTerm);
            a = b;
            b = nextTerm;
            nextTerm = a + b;
        }
    }
}