//program to calculate the sum of even numbers from 1 to 10 using a while loop.

import java.util.Scanner;

public class Question4 {
 
public static void main(String[] args) {
    int number=1;
   int sum=0;
    while (number<=10) {
        sum=number%2==0?sum+number:sum+0;
        number++;
    }
    System.out.println("the sum of even number from 1-10 is "+sum);
  }  
}
