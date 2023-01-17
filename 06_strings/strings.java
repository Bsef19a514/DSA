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
    //problem 37: Reverse order of words in a string II
    //Example: "I love java"---> "java love I"
    //leetcode: 186
    public static String reverseWordsOrder(String s){
        String[] arr=s.split(" ");
        int i=arr.length-1;
        String res="";
        while(i>0){
            res=res.concat(arr[i]);
            res=res.concat(" ");
            i--;
        }
       res= res.concat(arr[i]);
        return res;
    }
    //problem 38: find the character of highest frequency in a string. if there are two chars have same highest frequency the the return that char that is smaller like from a=3,f=3 choose a.
    //Example: "zain sattar"---> "a"
    public static char getMaxOccuringChar(String str)
    {
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        Character character=' ';
       
        for (int i = 0; i < str.length(); i++) {
            character=str.charAt(i);
            if(map.get(character)!=null){
                map.replace(character, map.get(character)+1);
            }else{
                map.put(character, 1);
            }
        }
        int max=0;
        Character maxFreqChar=' ';
        for (Map.Entry<Character,Integer> entrySet :map.entrySet()) {
            if(entrySet.getValue()>max){
                max=entrySet.getValue();
                maxFreqChar=entrySet.getKey();
            }
            else if(entrySet.getValue()==max){
                if(entrySet.getKey()<maxFreqChar){
                    maxFreqChar=entrySet.getKey();
                }
            }
        }
        return maxFreqChar;
    }
    //problem 39: Replace white spaces with @40.
    public static StringBuilder replaceSpaces(StringBuilder str) {
        StringBuilder res=new StringBuilder();;
        Character temp=' '; 
        for(int i=0;i<str.length();i++){
            temp=str.charAt(i);
            if(temp!=' '){
                res.append(temp);
            }else{
                res.append("@40");
            }
        }
        return res;
    }
    //Solution 2: inplace solution
     //problem 39: Replace white spaces with @40.
     public static StringBuilder replaceSpacesSol2(StringBuilder str) {
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)==' ')
            {
                str.replace(i, i+1, "@40");
            }
        }
        return str;
    }
    //Problem 40: Remove all occurances of given subString from given string
    public static String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            System.out.println(s.contains(part));
            s=s.replaceFirst(part, "");
        }
        return s;
    }
    public static void main(String[] args) {
        boolean isValidPalindrome= isPalindrome(" ");
        System.out.println(isValidPalindrome);
        String reversedString=reverseWordsOrder("I love java");
        System.out.println(reversedString);
        Character maxFreqCharacter=getMaxOccuringChar("zaiiin sattar");
        System.out.println(maxFreqCharacter);
        StringBuilder string=new StringBuilder();
        string.append("Geeks for geeks ");
        StringBuilder res=replaceSpacesSol2(string);
        System.out.println(res);
        String str="daabcbaabcbc";
        String str2=removeOccurrences(str, "abc");
        System.out.println(str2);
    }
    
}
