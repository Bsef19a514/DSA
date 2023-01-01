public class arrays {

    //Problem 10: Find the min and max value in an array in O(N)
    public static void minMax(int[]a){
        int min=a[0];
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>max){
                max=a[i];
            }
            if(a[i]<min){
                min=a[i];
            }
        }
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
    }
    //Problem 11: Reverse the array. O(N/2)
    public static void Reverse(int[]a){
        int i=0;
        int j=a.length-1;
        while (i<j) {
            swap(a,i,j);
            i++;
            j--;
        }
    }
    public static void swap(int[]arr,int x,int y) {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static void printArray(int[]a) {
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        int a[]={4,2,3,1,5,6,7,2,9};
        arrays.minMax(a);
        System.out.println("----------------------------");
        arrays.Reverse(a);
        arrays.printArray(a);
    }
}
