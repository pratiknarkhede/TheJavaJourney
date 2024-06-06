package com.pratik.thejavajourney.interviewqs;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveNumbersAndSortWords {

    // String s="j1v2a i1s awe2s3om1";


    private static String removeAndSortStrings(String stringWithNumbers) {
        char[] charArray = stringWithNumbers.toCharArray();
        String stringWithoutNumbers="";
        for(char ch:charArray){
            if(Character.isAlphabetic(ch) || Character.isWhitespace(ch)){
                stringWithoutNumbers=stringWithoutNumbers+""+ch;
            }
        }
        System.out.println(stringWithoutNumbers);
        String[] splitArray = stringWithoutNumbers.split("\s");
        System.out.println(Arrays.toString(splitArray));
        Arrays.sort(splitArray, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(splitArray));
        return null;
    }

    public static void main(String[] args) {
        String stringWithNumbers="j1v2a i1s awe2s3om1";
        String sortedStringWithoutNumbers=removeAndSortStrings(stringWithNumbers);
    }
}
