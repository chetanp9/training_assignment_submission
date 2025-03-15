// ) Create a program to search for a specific element within an array using linear search.

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={7,9,8,4,5,6,3,2,1};
        int target=0;
        System.out.println("enter the element that you want to search");
        target=sc.nextInt();
        sc.close();
        boolean ans=false;
        for(int i=0;i<arr.length;i++){
           if(arr[i]==target){
            ans=true;
            System.out.println("element found at index "+i);
            break;
           }
        }
        if(!ans){
            System.out.println("element is not present in array");
        }
        
    }
    
}
