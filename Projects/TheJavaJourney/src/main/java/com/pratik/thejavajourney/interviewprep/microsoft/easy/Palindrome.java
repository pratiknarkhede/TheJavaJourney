package com.pratik.thejavajourney.interviewprep.microsoft.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Palindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Palindrome palindrome=new Palindrome();
        boolean ifPalindrome = palindrome.isPalindrome(s);
        System.out.println(ifPalindrome);
    }

    public boolean isPalindrome(String s) {
        //make all letters uppercase
        StringBuilder sb=new StringBuilder();
        for (char c: s.toCharArray()){
          if(Character.isAlphabetic(c) || Character.isDigit(c)){
          sb.append(Character.toUpperCase(c));}
        }
        char[] charArray = sb.toString()
                             .toCharArray();
        System.out.println(sb);
        int l=0,r=charArray.length-1;
        while(l<r){
            if(charArray[l]!=charArray[r]){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindromeFunctional(String s) {
        char[] charArray = s.toCharArray();


        return false;
    }

}


