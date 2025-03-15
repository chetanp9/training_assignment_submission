// program to check if a given number is prime using an if-else statement.


import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number to check if it's prime: ");
        int num = scanner.nextInt();
        
        
        if (num < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            boolean isPrime = isPrime(num);
            
            if (isPrime) {
                System.out.println(num + " is a prime number.");
            } else {
                System.out.println(num + " is not a prime number.");
            }
        }
        
        scanner.close();
    }

  
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
