//  function to sort an array in ascending order using bubble sort or selection sort
public class Question2 {
   
    public static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>=arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int minindex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minindex]){
                    minindex=j;
                }
            }
            int temp=arr[minindex];
            arr[minindex]=arr[i];
            arr[i]=temp;
        }

    }
public static void main(String[] args) {
    int arr[]={5,7,-9,4,6};
    System.out.println("array before sort");
    for(int x:arr){
        System.out.println(x);
    }
    System.out.println("array after bubble sort:");
    bubbleSort(arr);
    for(int x:arr){
        System.out.println(x);
    }
    System.out.println("array after selection sort:");
    selectionSort(arr);
    for(int x:arr){
        System.out.println(x);
    }

}   
}
