import java.util.Scanner;
//program to find the factorial of a given number.

public class Question3 {
    public static void main(String[] args) {
        int number=0;
        System.out.println("enter the number ");
        Scanner sc= new Scanner(System.in);
        number=sc.nextInt();
        int ans=1;
        while (number>0){
            ans*=number;
            number--;
        }
        System.out.println("the factorial of number is "+ans);
        sc.close();
    }
}
