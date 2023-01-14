import java.util.*;

public class strings {

    //problem 36: 
    //leetcode 125: (Valid palindrome or not)
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        char leftElement='a';
        char rightElement='a';
        //System.out.println(s[0]);
        while(i<j){
            leftElement=s.charAt(i);
            rightElement=s.charAt(j);
            //System.out.println("left: "+leftElement+" right: "+rightElement);
            leftElement= Character.toLowerCase(leftElement);
            rightElement=Character.toLowerCase(rightElement);
            //if both left and right elements are numbers or alphabets.
            boolean leftIsAlphanumeric=false;
            boolean rightIsAlphanumeric=false;

            //check if left element is alphanumeric or not
            if((leftElement>='a' && leftElement<='z') || (leftElement>='0' && leftElement<='9')){
                leftIsAlphanumeric=true;
            }
            //check if right element is alphanumeric or not
            if((rightElement>='a' && rightElement<='z')|| (rightElement>='0' && rightElement<='9')){
                rightIsAlphanumeric=true;
            }
            // if both left and right are alphanumeric then compare if they are equal or not
            if((leftIsAlphanumeric) && (rightIsAlphanumeric)){
                //System.out.println("comaring left with right");
                if(leftElement!=rightElement){
                    return false;
                }else{
                    i++;
                    j--;
                }
            }else{
                if(!leftIsAlphanumeric){
                    i++;
                }
                if(!rightIsAlphanumeric){
                    j--;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean isValidPalindrome= isPalindrome(" ");
        System.out.println(isValidPalindrome);
    }
    
}
