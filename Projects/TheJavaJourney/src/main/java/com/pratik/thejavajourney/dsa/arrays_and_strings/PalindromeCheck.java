package com.pratik.thejavajourney.dsa.arrays_and_strings;

public class PalindromeCheck {



    public static void main(String[] args) {
        String s="avcaer*reacva";
        Boolean isPalindrome=checkIfPlaindrome(s);
        System.out.println("Is the string "+s+" palindrome "+isPalindrome);

        Boolean isPalindrome2=checkIfPlaindrome2(s);
        System.out.println("2 Is the string "+s+" palindrome "+isPalindrome2);
    }

    private static Boolean checkIfPlaindrome2(String s) {
        int left=0, right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    private static Boolean checkIfPlaindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        for(int i=0;i<(length/2)-1;i++){
            if(charArray[i] !=charArray[length-i-1]){
                return false;
            }
        }
        return true;
    }


}
