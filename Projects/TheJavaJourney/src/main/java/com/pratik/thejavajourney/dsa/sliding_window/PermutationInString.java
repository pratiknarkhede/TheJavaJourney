package com.pratik.thejavajourney.dsa.sliding_window;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        PermutationInString ps= new PermutationInString();
        boolean ifIncluded = ps.checkInclusion(s1, s2);
        System.out.println(ifIncluded);
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> mapS1=new HashMap<>();
        for(Character c: s1.toCharArray()){
            if(mapS1.containsKey(c)){
                mapS1.put(c,mapS1.get(c)+1);
            }else{
                mapS1.put(c,1);
            }
        }
        System.out.println(mapS1);
        return false;
    }

    private String sort(String s1){
        char[] s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);
        return new String(s1CharArray);
    }
}
