

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
    public static void main(String[] args) {
        int books[]={0,8,1,4};
        int result=bookAllocation(books, 4);
        System.out.println(result);
    }
}
//31:
//2,3,1,2,4,3
