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
        
    }
}
