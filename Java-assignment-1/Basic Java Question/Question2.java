import java.util.Scanner;

//Create a program to check if a number is even or odd.
@SuppressWarnings("ALL")
public  class Question2 {
    public static void main(String args[]){
        int number=0;
        System.out.println("Enter the Number");
        Scanner sc=new Scanner(System.in);
        number=sc.nextInt();
        sc.close();
        System.out.println(number+" is "+ (number%2==0?"Even":"Odd")+" Number.");


    }

}