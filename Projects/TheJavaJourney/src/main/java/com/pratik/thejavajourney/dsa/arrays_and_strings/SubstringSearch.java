package com.pratik.thejavajourney.dsa.arrays_and_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringSearch {
    public static void main(String[] args) {
        String s = "this is list of strings where I would be searching is substring to check how many times" +
                "it is existing";

        String substring = "is";

        int subStringCount = subStringSeach(s, substring);
    }

    private static int subStringSeach(String s, String substring) {
        int count=0;

        //create compiled string using comiple of
        Pattern compiledString = Pattern.compile(substring);

        //then using compiledString object , set it to be match with string where we want to search it
        Matcher matcher = compiledString.matcher(s);

        while(matcher.find()){

            count++;
        }
        System.out.println("Number of times "+substring+"occured is "+count);
        return count;
    }

//    private static int subStringSeach(String s, String substring) {
//        int count=0;
//        int i = s.indexOf(substring);
//        String s2 = s.replace(substring, "&");
//        System.out.println(s2);
//
//        for(char ch: s2.toCharArray()){
//            if(ch=='&'){
//                count++;
//            }
//        }
//        System.out.println(count);
//        return count;
//    }
}
