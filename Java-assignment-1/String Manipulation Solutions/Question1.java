// program to reverse a given string.


import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {
    public static String reverseString(String input){
        // Edge case: Null or empty string
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] charArray = input.toCharArray(); // Convert to character array
        int left = 0, right = charArray.length - 1;

        while (left < right) {
            // Swap characters
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            // Move pointers
            left++;
            right--;
        }

        return new String(charArray); // Convert back to string

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Test cases
        System.out.println("Enter a string to reverse:");
        String userInput = sc.nextLine();

        String reversedString = reverseString(userInput);
        System.out.println("Reversed String: " + reversedString);
        sc.close();
        
     
        
    }
}
