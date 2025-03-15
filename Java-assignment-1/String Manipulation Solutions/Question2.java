//Implement a function to count the number of vowels in a string.

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.println("Enter the string");
        String str=sc.nextLine();
        sc.close();
        if(str==null||str.isEmpty()){
            System.out.println("the string is empty");
            return ;
        }
        char[] chr=str.toCharArray();
        int count=0;
        for(char ch: chr){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'|ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                count++;
            }
        }
        System.out.println(count);

    }
    
}
