//a program to calculate the area of a circle, rectangle, or triangle based on user input.


import java.util.Scanner;

public  class Question1{
    public static float circleArea(float r){
        return (float) (3.14*r*r);
    }
    public static float triangleArea(float base,float height){
        return (float) (0.5*base*height);
    }
    public static float rectangleArea(float length,float width){
        return (float) (length*width);
    }
    public static void main(String args[]){
        System.out.println("Select The Figure");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");
        Scanner sc= new Scanner(System.in);
        int choice= sc.nextInt();
        if(choice==1){
            float r=0;
            System.out.println("Enter The radius of circle");
            r=sc.nextInt();
            System.out.println("The area of Circle is "+ circleArea(r));
        }
        else if(choice==2){
            float base,height=0;
            System.out.println("enter the base of triangle");
            base=sc.nextInt();
            System.out.println("enter the height of  triangle");
            height=sc.nextInt();
            System.out.println("the area of triangle is "+triangleArea(base,height));
        }
        else if(choice==3){
            float length,width=0;
            System.out.println("enter the length of rectangle ");
            length=sc.nextInt();
            System.out.println("enter the width of rectangle ");
            width=sc.nextInt();
            System.out.println("the area of rectangle is "+rectangleArea(length,width));
        }
        else{
            System.out.println("please select the correct option");
        }
        sc.close();
    }
}