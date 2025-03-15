import java.util.Scanner;
//a for loop to print a multiplication table.
public class Question3 {
    public static void main(String[] args) {
        int number=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number for table");
        number=sc.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(number+" x "+i+" = "+(number*i));
        }
        sc.close();
    }
}
