import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
       
        int arr[] ={-10,20,30,-40,50,60};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int len=arr.length;
        double avg =(double)sum/len;

        System.out.println("the average of elements of arrays is "+avg);
    }    
}
