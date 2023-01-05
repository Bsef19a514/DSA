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

    //Problem 22: Find total occurances of an element in an array in O(log n).

    public static int findTotalOccurances(ArrayList<Integer> arr, int n, int k){
        int firstOccurance=findIstOccurance(arr, k, 0, arr.size()-1);
        int lastOccurance=findLastOccurance(arr, k, 0, arr.size()-1);
        int totalOccurances= lastOccurance-firstOccurance+1;
        return totalOccurances;
    }

    //Problem 23: Find index of peak element in a mountain array in O(n/2) time.
    public static int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            if(arr[start+1]>=arr[start]){ //if next elemnt to start pointer is greater then move start pointer 1 step forward.
                start++;
            }else{ // else element at start is the peak(largest) element.
                return start;
            }
            if(arr[end-1]>=arr[end]){ //if previous elemnt to end pointer is greater then move start pointer 1 step backward.
                end--;
            }else{ // else element at end is the peak(largest) element.
                return end;
            }
        }
        return -1;
    }
    //Optimized solution: O(log n)--> using binary
    public static int peakIndexInMountainArrayUsingBinarySearch(int[] arr) {
        int start=0;
        int end=arr.length-1;
        int mid=start+((end-start)/2);
        while(start<end){
            //System.out.println("Start :"+start+" Mid: "+mid+" End: "+end);
            if(arr[mid-1]<arr[mid]&&arr[mid+1]<arr[mid]){
                return mid;
            }else if(arr[mid-1]>arr[mid]){
                end=mid;
            }
            else{
                start=mid;
            }
            mid=start+((end-start)/2);
        }
        return -1;
    }
    //Problem 24: Pivot sum
    //Time complexity O(n^2)
    public static int PivotIndex(int[]arr){
        int pivot=0;
        int leftSum=0;
        int rightSum=0;
        while(pivot<arr.length){
            //System.out.println(pivot);
            leftSum=findSum(arr, 0, pivot-1);
            rightSum=findSum(arr, pivot+1, arr.length-1);
            if(leftSum==rightSum){
                return pivot;
            }
            pivot++;
        }
        return -1;
    }
    public static int findSum(int[]arr,int start, int end){
        int sum=0;
        while(start<=end){
            sum=sum+arr[start];
            start++;
        }
        return sum;
    }
    //time complexity= O(n)
    public static int PivotIndexSol2(int []nums){
        int rightSum=0;
        int leftSum=0;
        for (int i=0;i<nums.length;i++){
            rightSum=rightSum+nums[i];
        }
        for(int i=0;i<nums.length;i++){
            rightSum=rightSum-nums[i];
            if(rightSum==leftSum){
                return i;
            }
            leftSum=leftSum+nums[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(0);
        arr.add(3);
        arr.add(4);
        arr.add(4);
        arr.add(6);
        int []result=findFirstAndLastOccurance(arr, arr.size(), 3);
        printArray(result);
        System.out.println("----------------------------");
        int occurances=findTotalOccurances(arr, arr.size(), 3);
        System.out.println("total occurances:"+occurances);
        System.out.println("----------------------------");
        int []mountainarr={1,2,3,5,1};
        int index=peakIndexInMountainArray(mountainarr);
        System.out.println("Index of Peak element is: "+index);
        System.out.println("----------------------------");
        int index2=peakIndexInMountainArrayUsingBinarySearch(mountainarr);
        System.out.println("Index of Peak element is: "+index2);
        System.out.println("----------------------------");
        int []arr2={1,0,-1,-1,-1,-1};
        int []arr3={2,1,-1};
        int index3=PivotIndex(arr2);
        int index4=PivotIndexSol2(arr3);
        System.out.println("Pivot index is: "+index3);
        System.out.println("Pivot index is: "+index4);
    }
}
