import java.sql.Array;
import java.util.*;  
public class arrays {
    public static void swap(int[]arr,int x,int y) {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
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

    public static int BinarySearch(int[]arr,int e,int s, int l){
        int start=s;
        int end=l;
        int mid=(end+start)/2; // or mid= start + (end-start)/2 if our array size is two large than start+end will result an error that sum is exceeding the int range. 
        while(start<=end){
            if(e==arr[mid]){
                return mid;
            }
            else if(e<arr[mid]){//searching in left sub-array
                end=mid-1;
            }
            else if(e>arr[mid]){//searching in right sub-array
                start=mid+1;
            }
            mid=(end+start)/2;
        }
        return -1;
    }

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
    //Problem 12: Swap alternate elements of array. O(N/2)
    public static void swapAlternatively(int[]a) {
        for(int i=0;i<a.length-1;i=i+2){
            swap(a, i, i+1);
        }
    }
    //Problem 13: Your are given an array of size N such that all elements are duplicate except one element. You need to find that one unique element.
    //Time complexity: O(N^2)
    public static int findUnique(int[] arr){
		int count;
        for(int i=0;i<arr.length;i++){
            count=1;
            for(int j=0;j<arr.length ;j++){
                if(arr[j]==arr[i] && j!=i){
                    count++;
                    break;
                }
            }
            if(count==1){
                return arr[i];
            }
        }
        return -1;
    } 
    //Optimized approach:
    /* XOR= gives 0 when two inputs are same
       suppose we have 1,2,3,2,1
       1 xor 1 = 0
       2 xor 2 = 0
       0 xor 3 xor 0 = 3 ANS
     */
    //Time complexity: O(N)
    public static int findUniqueSol2(int[] arr){
        int result=arr[0];
        for(int i=1;i<arr.length;i++){
            result=result^arr[i];
        }
       return result;
    } 
    // Leetcode 1207:
    //PROBLEM 14: Return true if all elements of array has unique occurances else false
    // Omptimized approach: using haskmap
    public static boolean hasUniqueOccurances(int[]a){
        if(a.length>=1 && a.length<=1000){
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            Set<Integer> set = new HashSet<Integer>();
            for(int i=0;i<a.length;i++){
                if(a[i]>=-1000 && a[i]<=1000)
                {
                    if(set.contains(a[i])){
                        map.put(a[i],map.get(a[i])+1);
                    }else{
                        map.put(a[i], 1);
                        set.add(a[i]);
                    }
                }
                //edge case
                else{
                    return false;
                }
            }
            Set<Integer> uniqueFreq=new HashSet<>();
            //Iterating over hashmap
            for(Map.Entry<Integer,Integer> m:map.entrySet()){    
                int frequency=m.getValue();
                System.out.println(frequency);
                boolean isadded=uniqueFreq.add(frequency);
                if(!isadded){ //it same frequency is already present in the set then it would not be added again to set so returning false.
                    return false;
                }     
            }
            return true;
        }
        //edge case (constraint)
        else{
            return false;
        }
    }
    //Problem 15: Your are given an array of size N which contains atleast one occurance of each element between 1 and N-1.
    // only one elemnt from that range is occured twice. find that element.
    //Example: [4,1,3,3,2] ==> N(size)=5

    public static int duplicate(int[]arr){
        int res=0;
        for(int i=0;i<arr.length;i++){
            System.out.println("Xoring "+arr[i]+" and "+res);
            res=res^arr[i];
            System.out.println(res);
        }
        System.out.println("Again XOR ing with N-1 elements");
        for(int i=1;i<arr.length;i++){

            res=res^i;
            System.out.println(res);
        }
        return res;
    }
    // gereric solution : if array contains random elements like [1,5,89,3,11,7]
    public static int genericDuplicate(int[]arr){
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            boolean isadded=set.add(arr[i]);
            if(!isadded){
                return arr[i];
            }
        }
        return -1;
    }

    //Problem 16:
    /* Leetcode 442:
     * Given an integer array nums of length n where all the integers of nums are in the range [1, n]
     * and each integer appears once or twice, return an array of all the integers that appears twice.
     * You must write an algorithm that runs in O(n) time and uses only constant extra space. */
    public static List<Integer> duplicateAll(int[]arr){
        List<Integer> duplicates=new ArrayList<Integer>();
        int value;
        int targetIndex;
        for(int i=0;i<arr.length;i++){
            value=arr[i];
            if(value<0){ //if value at current index is negatice  then making it positive.
                value=-value;
            }
            targetIndex=value-1;
            if(arr[targetIndex]<0){ //if value at target index is negative then it means it is already visited.
                duplicates.add(value);
            }else{
                arr[targetIndex]=-arr[targetIndex];
            }
        }
        return duplicates;
    }
    //Problem 17:
    //You are given two arrays A and B of size N amd M. Both arrays are sorted in increasing order.
    // Return an array containing elements that are common in both A and B.

    //Using binary search --> Time Complexity O(n log m)
    public static List<Integer> arrayIntersection(int[]A,int[]B){
        List<Integer> result=new ArrayList<Integer>();

        int index;
        if(A.length>B.length){
            for(int i =0;i<B.length;i++){
                index=BinarySearch(A, B[i],0,A.length-1);
                if(index!=-1){
                    A[index]=-A[index];
                    result.add(B[i]);
                }
            }
        }else{
            for(int i =0;i<A.length;i++){
                index=BinarySearch(B, A[i],0,A.length-1);
                if(index!=-1){
                    B[index]=-B[index];
                    result.add(A[i]);
                }
            }
        }
        return result;
    } 
    

    //Solution 2:
    //Using two pointer --> Time Complexity O(n) or O(m)
    public static List<Integer> arrayIntersectionSol2(int[]A,int[]B){
        List<Integer> result=new ArrayList<Integer>();
        int p1=0;
        int p2=0;
        if(A.length>B.length){
            while(p1<A.length||p2<B.length){
                // System.out.println("Comparing B's "+B[p2]+" with A's "+A[p1]);
                if(A[p1]==B[p2]){
                    result.add(A[p1]);
                    p1++;
                    p2++;
                }
                else if(A[p1]<B[p2]){
                    p1++;
                }else{
                    p2++;
                }
            }
        }else{
            while(p1<A.length||p2<B.length){
                // System.out.println("Comparing A's  "+A[p1]+" with B's "+B[p2]);
                if(A[p1]==B[p2]){
                    result.add(A[p1]);
                    p1++;
                    p2++;
                }
                else if(A[p1]<B[p2]){
                    p1++;
                }else{
                    p2++;
                }
            }
        }
        return result;
    }
    //Problem 18: You are given an array of integers and a value V. Your need to find pairs whose sum is equal to the given value V.
    //Example Arr=[1,4,3,7,9,6], value=10 result=[[1,9],[3,7]] as sum of 1+9=10 and 3,7=10
    public  static List<int[]> pairSum(int[] arr, int s) {
        
        List<int[]> list=new ArrayList<int[]>();
        int firstVal;
        int secValIndex;
        int secVal;

        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int []pair={0,0};
            firstVal=arr[i];
            secValIndex=BinarySearch(arr, s-arr[i],i+1,arr.length-1);

            // if 2nd value founds in arr
            if(secValIndex>-1 && secValIndex!=i){
                secVal=arr[secValIndex];
                if(firstVal<secVal){
                    pair[0]=firstVal;
                    pair[1]=secVal;
                }else{
                    pair[0]=secVal;
                    pair[1]=firstVal;
                }

                if((!list.isEmpty()) && pair[0]<list.get(list.size()-1)[0]){
                    list.add(list.size(),list.get(list.size()-1));
                    list.add(list.size()-1,pair);
                }else{
                    list.add(pair);
                }
                
            } 
        }       
        return list;
    }

    public static void printListOfArrays(List<int[]> list){
        int[] arr;
        for(int i=0;i<list.size();i++){
            arr=list.get(i);
            System.out.println(arr[0]+" , "+arr[1]);
        }
    }
    //Problem 19: Sort 01: Given an array which only contains 0s and 1s. sort the array in O(N)
    public static int[] sort01(int[]arr){
        int p0=0;
        int p1=arr.length-1;
        
        while(p0<p1){
            if(arr[p0]==0 && arr[p1]==1){
                p0++;
                p1--;
            }
            else if(arr[p0]==1 && arr[p1]==0){
                swap(arr, p0, p1);
                p0++;
                p1--;
            }
            else if(arr[p0]==1 && arr[p1]==1){
                p1--;
            }else if(arr[p0]==0 && arr[p1]==0){
                p0++;
            }
        }
        return arr;
    }
    
     //Problem 20: Sort 012: Given an array which only contains 0s 1s and 2s. sort the array in O(N)
     /* Solution1: using any sorting algorithm like heap, merge, count. Time complexity O(n log n)
      * Solution2: first iteration over the array and get count of each value. Then make a new array and store the values according to their counts.
      * Time complexity: 2 O(n) as two loop are being used. 2O(n) ~~  O(n)
      * Solution 3: Thre pointer approach: iteration single time . Time complexity --> O(n)
      */
    public static int[] sort012(int[] arr){
        int p0=0;
        int p2=arr.length-1;
        int current=0;
        while(current<=p2){
            //if current element is 0
            if(arr[current]==0){
                //push it to the start of array
                swap(arr, p0, current);
                p0++; //move zero pointer 1 step forward
                current++; //move zero pointer 1 step forward
            }
            //if current element is 2
            else if(arr[current]==2){
                //push it to the end of array
                swap(arr, p2, current);
                p2--; //move zero pointer 1 step (backward) towards head     
            }
            //if current element is 1
            else{
                current++;
            }
        }
        return arr;
    }
    //Problem 20: Sort 012
    public static void main(String[] args) {
        int a[]={4,2,3,1,5,6,7,2,9,3};
        arrays.minMax(a);
        System.out.println("----------------------------");
        // arrays.Reverse(a);
        // arrays.printArray(a);
        System.out.println("----------------------------");
        arrays.swapAlternatively(a);
        arrays.printArray(a);
        System.out.println("----------------------------");
        int b[]={1,2,2,3,3,3};
        System.out.println(findUnique(b));
        System.out.println("----------------------------");
        System.out.println(findUniqueSol2(b));
        System.out.println("----------------------------");
        boolean unique= hasUniqueOccurances(b);
        System.out.println(unique);
        System.out.println("----------------------------");
        int c[]={4,1,3,3,2};
        int dup= duplicate(c);
        System.out.println("Duplicate element is: "+ dup);
        System.out.println("----------------------------");
        int d[]={4,1,56,2,8,3,2};
        int dup2=genericDuplicate(d);
        System.out.println("Duplicate element is: "+ dup2);
        System.out.println("----------------------------");
        int e[]={4,3,2,8,2,3,1,5};
        List<Integer> dup3=duplicateAll(e);
        printList(dup3);
        System.out.println("----------------------------");
        int[]f={3,3,4,5,8,8};
        int index=BinarySearch(f,8,0,f.length);
        System.out.println(index);
        System.out.println("----------------------------");
        int[]g={1,2,2,3,6,7,8,9};
        List<Integer> common=arrayIntersection(f, g);
        printList(common);
        System.out.println("----------------------------");
        int[]h={2,3,3,5,8,9};
        int[]i={1,2,2,3,6,7,8,9};
        List<Integer> common2=arrayIntersectionSol2(h, i);
        printList(common2);
        System.out.println("----------------------------");
        int[] j={2,-3,3,3,-2};
        List<int[]> result=pairSum(j, 0);
        System.out.println("List contains: "+result.size()+ " arrays.");
        printListOfArrays(result);
        System.out.println("----------------------------");
        int []zeroOne={1,1,0,1,0,1,0,1};     
        int sortedarr[]=sort01(zeroOne);
        printArray(sortedarr);
        System.out.println("----------------------------");
        int []zeroOneTwo={0, 1 ,1 ,0 ,0 ,1 ,1 ,0 ,1 ,0};     
        int sortarr2[]=sort012(zeroOneTwo);
        printArray(sortarr2);
//0 0 0 1 2 1 1 1 1 2 2 2
//{2,1,2,1,0,0,0,1,2,1,1,2};
    }
}
