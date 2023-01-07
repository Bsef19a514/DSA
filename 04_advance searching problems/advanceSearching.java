import java.util.Arrays;

public class advanceSearching {
    
    //Problem 28: Book alocation problem
    public static int bookAllocation(int[] nums, int k  ) {
        int min=0;
        int max=sumOfElements(nums);
        int mid=min+((max-min)/2);
        
        int sum,count;
        int ans=-1;
        while(min<=max){
            //checking whether mid is one of the possible solution or not.
            //System.out.println("mid is:"+mid);
            sum=0;
            count=0;
            
            for(int i=0;i<nums.length &&count<k;i++){
                // System.out.println("i is:"+i);
                // System.out.println(nums[i] +"+"+ sum +"="+(sum+nums[i]));
                
                //1) checking if remainig books <=remaining students and pages of ith book nums[i] are lesser than our mid value
                //in that case allocate only one book to one btudent. 
                if(nums.length-i+1<=k-count && nums[i]<=mid){
                    if(nums[i]<=mid){
                        count++;
                    }
                } 
                else if(nums[i]+sum<=mid){
                    sum=sum+nums[i];
                }else{
                    i--;
                    count++;
                    sum=0;
                    //System.out.println("Partition: "+count);
                }
            }
            if(count+1==k){ //means all the books are allocated to all the students.
                ans=mid;
                max=mid-1;
            }else if(count+1>k){ 
                min=mid+1;
            }else{
                max=mid-1;
            }
            mid=min+((max-min)/2);
        }
        return ans;
    }
    public static int sumOfElements(int[]arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        return sum;
    }

    //Problem 28: painter's partition problem
    public static int paintersPartition(int []nums, int k) {
        int min=nums[0];
        int max=0;
        int sum=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
            sum=sum+nums[i];
        }
       // System.out.println("min: "+min+" max: "+sum);
        int mid=min+((sum-min)/2);
        int ans=-1;
        while(min<=sum){
           // System.out.println("Mid: "+mid);
            if(isPossibleSolution(nums,mid,k)){
                ans=mid;
                //System.out.println("Ans: "+ans);
                sum=mid-1;
            }else{
                min=mid+1;
            }
           // System.out.println("Min: "+min+" Mid: "+mid+" max: "+sum);
            mid=min+((sum-min)/2);
        }
        return ans;
    }
    public static boolean isPossibleSolution(int []arr,int mid,int k) {
        int count=1;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }else{
                count++;
                //System.out.println("Count: "+count);
                if(count>k || arr[i]>mid){
                    return false;
                }
                sum=arr[i];
            }
        }
       // System.out.println(mid+" is a possible solution.");
        return true; 
    }

    //Problem 29:  Assigning slots to aggressive cows suvh that the distace between the slots is maximum.
    public static int aggressiveCows(int[]slots,int cows){
        Arrays.sort(slots);
        int min=slots[0];
        int max=0;
        for (int i=0;i<slots.length;i++){
            if(slots[i]<min){
                min=slots[i];
            }
            if(slots[i]>max){
                max=slots[i];
            }
        }
        max=max-min; //max distance between two slots can be maximum value minus minimum value present in array.
        min=0; //min distance between two slots can be zero like in array [1,2,2,3,4,5,6]
        // System.out.println("min: "+min+" max: "+max);
        int mid=min+((max-min)/2);
        int ans=-1;
        while(min<=max){
            // System.out.println("Mid: "+mid);
            if(isPossibleSolForCows(slots, mid, cows)){
                ans=mid;
                // System.out.println("Ans: "+ans);
                min=mid+1;
            }else{
                max=mid-1;
            }
            mid=min+((max-min)/2);
        }
        return ans;
    }
    public static boolean isPossibleSolForCows(int[]arr,int mid, int k){
        int count=1;
        int lastPosition=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]-lastPosition>=mid){
                count++;
                // System.out.println("Count: "+count);
                if(count==k){
                    return true;
                }
                lastPosition=arr[i];
            }
        }
        return false;
    }
    //Problem 30: EKO - Eko problem
    public static int eko_Spoj(int []arr,int target) {
        Arrays.sort(arr);
        int minHeight=arr[0];
        int maxHeight=arr[arr.length-1];
        int mid=minHeight+((maxHeight-minHeight)/2);
        int ans=-1;
        while(minHeight<=maxHeight){
            // System.out.println("Mid: "+mid);
            if(isPossibleSawBladeHeight(arr, mid, target)){
                ans=mid;
                // System.out.println("Ans: "+ans);
                minHeight=mid+1;
            }else{
                maxHeight=mid-1;
            }
            mid=minHeight+((maxHeight-minHeight)/2);
        }
        return ans;
    }
    public static boolean isPossibleSawBladeHeight(int []arr,int mid,int target) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>mid){
                sum=sum+(arr[i]-mid);
            }
        }
        if(sum>=target){
            return true;
        }else{
            return false;
        }
    }
        
    public static void main(String[] args) {
        int books[]={2,1,4,1,1,1};
        int result=bookAllocation(books, 5);
        System.out.println(result);
        int result2=paintersPartition(books, 5);
        System.out.println(result2);
        int slots[]={4 ,2 ,1 ,3 ,6};
        int maximumDistance=aggressiveCows(slots,2 );
        System.out.println(maximumDistance);
        int trees[]={4 ,42 ,40, 26, 46};
        int scaleHeight=eko_Spoj(trees,20 );
        System.out.println(scaleHeight);
    }   
}
//31:
//2,3,1,2,4,3
//0,8,1,4
//{1,2,3,4,6}