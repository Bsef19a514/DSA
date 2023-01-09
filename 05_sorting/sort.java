import java.util.*;


public class sort {
    public static void swap(int[]arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void bubbleSort(int[]arr){
        int n=arr.length;
        boolean isSwapped=false;
        for(int i=1;i<n;i++){
            System.out.println("Round: "+i);
            for(int j=0;j<=n-i-1;j++){
                System.out.println("arr[j]: "+arr[j]+" arr[j+1]: "+arr[j+1]);
                if(arr[j+1]<arr[j]){
                    swap(arr,j,j+1);
                    isSwapped=true;
                }
            }
            //if at any round array is already sorted then simply break the loop
            if(isSwapped==false){
                break;
            }
        }
    }
    public static void printArray(int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.print(" ");
    }
    public static void main(String[] args) {
        int []arr={6,5,4,3,2,1};
        bubbleSort(arr);
        printArray(arr);

    }
}
