public class numberSystem {

    // PROBLEM 1: you are given a number N , print all the decimals of that number seperately. like 237 ---> 2,3,7
    public static void problem1 (int N){
        int reminder;
        int quotient;
        while(N>0){ //N%1==0 (to check if N is a decimal or integer)
            reminder=N%10;
            quotient=N/10;
            System.out.println(reminder);
            N=quotient;
        }
    }
    // PROBLEM 2: you are given a number N , reverse the number like 123-->321, 690-->96 etc
    // leetcode:07
    public static void problem2(int N){
        int reminder;
        int quotient;
        String reverse="";
        while(N>0){ //N%1==0 (to check if N is a decimal or integer)
            reminder=N%10;
            quotient=N/10;
            reverse+=reminder;
            N=quotient;
        }
        System.out.println(reverse);
        int reversedNumber=Integer.parseInt(reverse);
        System.out.println(reversedNumber);
    }
    //better approach (without using String)
    public static int problem2_Sol2(int N){
        int min=(int)Math.pow(-2, 31);
        int max=(int)Math.pow(2, 31)-1;
        System.out.println(max);
        int reminder;
        int quotient;
        int ans=0;
        while(N!=0){ //N%1==0 (to check if N is a decimal or integer)
            reminder=N%10;
            quotient=N/10;
            if(ans>max/10||ans<min/10){ //out of range of int32
                return 0;
            }
            ans=(ans*10)+reminder; //formula
            N=quotient;
        }
        return ans;
    }

    //problem 3: find complement of an integer
    //leetcode: 1009
    public static int complement(int x){
        int complement=0;
        int result=0;
        if(x>0 && x<Math.pow(10,9)){
            //converting decimal number to binary and replacing 1 with 0 and 0 with 1
            int reminder=0;
            int bitNo=0;
            while(x>0){
                reminder=x%2;
                x=x/2;
                System.out.println(reminder);
                if(reminder==1){
                    complement=0;
                }else{
                    complement=1;
                }
                if(complement==1){
                    result=result+(int)Math.pow(2,bitNo); //converting binary to decimal
                }
               
                bitNo++;
            }
        }
        else if(x==0){
            return 1;
        }
        return result;
    }
   public static void main(String[] args) {
        numberSystem.problem1(29);
        System.out.println("-------------------");
        numberSystem.problem2(340);
        System.out.println("-------------------");
        int result=numberSystem.problem2_Sol2(1534236469);
        System.out.println(result);
        System.out.println("-------------------");
        int comp= numberSystem.complement(0);
        System.out.println(comp);
    }
}