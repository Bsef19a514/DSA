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
        // edge case
        else if(x==0){
            return 1;
        }
        return result;
    }

    // optimised solution
    public static int complement_Sol2(int n){
        // edge case
        if(n==0){
            return 1;
        }
        // 1) Find not of n
        // 2) making the mask 
        // 3) And the not of n with mask

        //making the mask (mask is like 000000000111 )
        int m=n;
        int mask=0;
        while(m!=0){
            System.out.println("while: "+m);
            m=m>>1; //right shift bits of m 1 time
            mask=mask<<1; //shifting bits of mask to the left 1 time
            mask=mask|1; //performing mask OR 1
        }
        //finding not of n
        int notN=~n;
        //And notN with mask
        int compliment= notN & mask;
        return compliment;
    }

    //problem 4: Given a number find whether it is the power of 2 or not.
    //leetcode: 231
    public static boolean isPowerOfTwo(int n) {
        int reminder=0;
        if(n<1){
            return false;
        }
        while(n>1 & reminder==0){
            reminder=n%2;
            n=n/2;
        }
        
        if(reminder==1){
            return false;
        }else{
            return true;
        }
    }
    //optimised solutoin:
    public static boolean isPowerOfTwo_Sol2(int n) {
        if(n<1){
            return false;
        }
        /*  A number is exp of 2 if N AND N-1 is 0.
        Example:
        N = 4 
        4 in binary = 100
        N-1 => 4-1 => 3 in binary = 11
         now, (4 & (3)) => will be equal to 0, thats why N = 4 is a power of 2.*/
        int result=n & n-1;
        if(result==0){
            return true;
        }else{
            return false;
        }
        
    }

    //problem 5:
    public static void coinChangeProblem(int amount){
        int c1=100;
        int c2=50;
        int c3=20;
        int c4=10;
        int c5=1;
        int notes=0;
        if(amount>=c1){
            notes=amount/c1;
            amount=amount%c1;
            System.out.println(notes+" notes of "+c1+" are needded");
        }
        if(amount>=c2){
            notes=amount/c2;
            amount=amount%c2;
            System.out.println(notes+" notes of "+c2+" are needded");
        }
        if(amount>=c3){
            notes=amount/c3;
            amount=amount%c3;
            System.out.println(notes+" notes of "+c3+" are needded");
        }
        if(amount>=c4){
            notes=amount/c4;
            amount=amount%c4;
            System.out.println(notes+" notes of "+c4+" are needded");
        }
        if(amount>=c5){
            notes=amount/c5;
            amount=amount%c5;
            System.out.println(notes+" notes of "+c5+" are needded");
        }
    }

    // Problem 6: Find factorial of a number using recursion.
    public static int factorial(int n){
        if(n==1 ||n==0){
            return 1;
        }
        return n*factorial(n-1);
    }

    // Problem 7: You are given two numbers n and r. Find nCr?
    public static int nCr(int n, int r){
        if(n>0 && n>=r){
            int nfactorial=numberSystem.factorial(n);
            int rfactorial=numberSystem.factorial(r);
            int n_rFactorial=numberSystem.factorial(n-r);
            int result=nfactorial/(rfactorial*n_rFactorial);
            return result;
        }else{
            return 0;
        }
    }

    //Problem 8: Find total number of set bits in n
    public static int countSetBits(int n){
        //converting the number into binary
        if(n>=0){
            int quotient=0;
            int reminder=0;
            int count=0;
            while (n>=1) {
                if(n%2==1){
                    count++;
                }
                n=n/2;
            }
            return count;
        }
        //edge case
        else{
            return -1;
        }
    }

    //Problem 9: Find the value of nth item in fibonaci series using recursion.
    public static int fibonaciValue(int n){
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        
        return fibonaciValue(n-1)+fibonaciValue(n-2);
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
        System.out.println("-------------------");
        int res= numberSystem.complement_Sol2(1);
        System.out.println("Compliment is: "+res);
        System.out.println("-------------------");
        System.out.println(numberSystem.isPowerOfTwo(128));
        System.out.println("-------------------");
        System.out.println(numberSystem.isPowerOfTwo_Sol2(6));
        System.out.println("-------------------");
        numberSystem.coinChangeProblem(1);
        System.out.println("-------------------");
        int fact=numberSystem.factorial(3);
        System.out.println(fact);
        System.out.println("-------------------");
        int ncr=numberSystem.nCr(5,3);
        System.out.println(ncr);
        System.out.println("-------------------");
        int count=numberSystem.countSetBits(-1);
        System.out.println(count);
        System.out.println("-------------------");
        int value=numberSystem.fibonaciValue(5);
        System.out.println(value);
    }
}