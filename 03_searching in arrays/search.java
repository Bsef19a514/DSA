import java.util.*;
public class search {
    public static void printArray(int[]a) {
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static void printList(List<Integer> list) {
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }


    //Problem 21: Your are given a sorted array  and a number n. You need to find the fist and last occurance of that number in the array.
    public static int[] findFirstAndLastOccurance(ArrayList<Integer> arr, int n, int k){
        //n is sizeof array list
        // k is our key that we need to find
        int result[]=new int[2];
        result[0]=findIstOccurance(arr, k, 0, arr.size()-1);
        result[1]=findLastOccurance(arr, k, 0, arr.size()-1);
        return result;
    }


    public static int findIstOccurance(ArrayList<Integer>arr,int key,int start,int end){
        int index=-1;
        int mid=start+((end-start))/2; // mid= start + (end-start)/2 if our array size is two large than start+end will result an error that sum is exceeding the int range. 
        while(start<=end){
            if(key==arr.get(mid)){ 
                index=mid;
                end=mid-1; //if key is found at mid then searching in left sub array for first occurance
            }
            else if(key<arr.get(mid)){//searching in left sub-array
                end=mid-1;
            }
            else if(key>arr.get(mid)){//searching in right sub-array
                start=mid+1;
            }
            mid=(end+start)/2;
        }
        return index;
    }
    public static int findLastOccurance(ArrayList<Integer>arr,int key,int start,int end){
        int index=-1;
        int mid=start+((end-start))/2; // mid= start + (end-start)/2 if our array size is two large than start+end will result an error that sum is exceeding the int range. 
        while(start<=end){
            if(key==arr.get(mid)){ 
                index=mid;
                start=mid+1; //if key is found at mid then searching in right sub array for last occurance
            }
            else if(key<arr.get(mid)){//searching in left sub-array
                end=mid-1;
            }
            else if(key>arr.get(mid)){//searching in right sub-array
                start=mid+1;
            }
            mid=(end+start)/2;
        }
        return index;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        // arr.add(3);
        // arr.add(4);
        // arr.add(4);
        // arr.add(6);
        int []result=findFirstAndLastOccurance(arr, arr.size(), 0);
        printArray(result);
    }
}
