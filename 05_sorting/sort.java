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
           // System.out.println("Round: "+i);
            for(int j=0;j<=n-i-1;j++){
                //System.out.println("arr[j]: "+arr[j]+" arr[j+1]: "+arr[j+1]);
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
    //cards sorting
    public static void insertionSort(int []arr){
        int j;
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp=arr[i];
            j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    //selection sort
    public static void selectionSort(int[] arr) {
        int minValueIndex;
        for(int i=0;i<arr.length;i++){
            minValueIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    minValueIndex=j;
                }
            }
            System.out.println("swapping "+arr[i]+" with "+arr[minValueIndex]);
            swap(arr,i,minValueIndex);
        }   
    }
    //leetcode: 88
    //Problem 31: given two sorted arrays and two integers m and n, representing size of each array. your task is to merge 2nd array into first one.
    //Example: a1=[1,3,4,5,0,0], a2=[2,6,7], m=4, n=3 , result==> a1[1,2,3,4,5,6,7]
    public static void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
            while(i<m &&j<n){
                System.out.println("comparing "+nums1[i]+" with "+nums2[j]);
                if(nums1[i]<=nums2[j]){
                    i++;
                }else{
                    int min=nums2[j];
                    int temp1=nums1[i];
                    int temp2=0;
                    for(int k=i+1;k<=m;k++){
                        temp2=nums1[k];
                        nums1[k]=temp1;
                        temp1=temp2;
                    }
                    nums1[i]=min;
                    m++;
                    j++;
                    i++;
                }
            }
            for(int x=m;x<nums1.length;x++){
                nums1[x]=nums2[j];
                j++;
            }
    }   
    //leetcode 283:
    /*  Problem 32:
        Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        Note that you must do this in-place without making a copy of the array.
     */
    public static void moveZeroes(int[] nums) {
        
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]==0){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[k]!=0){
                        swap(nums, j, k);
                        break;
                    }
                }
            }
        }
    }
    //better solution--> moving non zeroes elements to left
    public static void moveZeroesSol2(int[] nums) {
        
        int pos=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,pos,i);
                pos++;
            }
            
        }
    }
    // problem 33:
    public static void rotateArray(int []nums, int k) {
        int startIndex=0;
        int targetIndex=(startIndex+k)%nums.length;
        int temp1=nums[startIndex];
        int temp2=0;
        int i=0;
        while(i<nums.length && k!=nums.length && k>0 && nums.length>1){
            if(targetIndex!=startIndex){
                temp2=nums[targetIndex];
                System.out.println("If: temp1: "+temp1+" temp2: "+temp2+" targetIndex: "+targetIndex);
                nums[targetIndex]=temp1;
                temp1=temp2;
                targetIndex=(targetIndex+k)%nums.length;
            }else{
                temp2=nums[targetIndex+1];
                System.out.println("Else: temp1: "+temp1+" temp2: "+temp2+" targetIndex: "+(targetIndex+1));
                nums[targetIndex]=temp1;
                temp1=temp2;
                targetIndex=(targetIndex+1+k)%nums.length;
                startIndex++;
            }
            
            i++;
        }
    }

    //Problem 34: Check if the given array is sorted or not.
    public static boolean checkSortedAndRotated(int[] nums) {
        int i=0;
        int largerElementCount=0; //counts that pair  such that current element is bigger than next elment.
        while(i<nums.length){
            if(nums[i]>nums[(i+1)%nums.length]){
                largerElementCount++;
            }
            i++;
        }
        if(largerElementCount==1){ //[4,5,1,2,3] --> one 1 pair exists like (5,1)
            return true;
        }else if(largerElementCount==0){ //means no pair is found whose first elemnt is larger than the second element like [1,1,1,1]
            return true;
        }else{ //[3,5,7,1,6]--> more than one pair exists like (7,1) and (6,3)
            return false;
        }
    }
    public static void printArray(int arr[]) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        int []arr={6,5,4,3,2,1};
        bubbleSort(arr);
        printArray(arr);
        int []arr2={6,5,4,3,2,1};
        insertionSort(arr2);
        printArray(arr2);
        // int key=Arrays.binarySearch(arr2, 0, arr2.length-1, 4);
        // System.out.println(key);
        int []arr3={1,5,6,4,3,2,1};
        selectionSort(arr3);
        printArray(arr3);
        int []a1={1,3,4,5,0,0,0};
        int []a2={2,6,7};
        mergeSortedArrays(a1, 4, a2, 3);
        printArray(a1);
        int a3[]={1,3,0,0,2,1,0};
        int a4[]={1,3,0,0,2,1,0};
        moveZeroes(a3);
        printArray(a3);
        moveZeroesSol2(a4);
        printArray(a4);
        int []a5={-1,-100,3,99};
        int []a6={1,2,1,4,1,6};
        rotateArray(a6, 2);
        printArray(a6);
        int a7[]={2,3,1,3};
        boolean res=checkSortedAndRotated(a7);
        System.out.println(res);
    }
}
