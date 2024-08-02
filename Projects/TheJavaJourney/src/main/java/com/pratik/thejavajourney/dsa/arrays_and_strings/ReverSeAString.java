package com.pratik.thejavajourney.dsa.arrays_and_strings;

public class ReverSeAString {


    public static void main(String[] args) {
        String s1 = "beginning interview study";
        String s2 = ", again ";

        reverseString1(s1);
        reverseString2(s1);
    }


    private static void reverseString1(String s1) {
        StringBuilder sb = new StringBuilder(s1);
        String sTemp = new String(sb.reverse());
        System.out.println("In reverseString1 "+sTemp);
    }

    private static void reverseString2(String s1) {
        char[] charArray = s1.toCharArray();
        int length = charArray.length;
        char[] revsersed = new char[length];
        for (int i = 0; i < length-1; i++) {
            revsersed[i]=charArray[length-i-1];
        }
        System.out.println("In reverseString2 "+new String(revsersed));
    }


}