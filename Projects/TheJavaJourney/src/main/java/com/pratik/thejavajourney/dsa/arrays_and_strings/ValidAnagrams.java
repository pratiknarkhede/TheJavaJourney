package com.pratik.thejavajourney.dsa.arrays_and_strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ValidAnagrams {

    public static void main(String[] args) {
        String s = "aacc", t = "ccac";
        boolean isItAnagram = isAnagramOptimized(s, t);
        System.out.println(isItAnagram);
    }


    //one way is to sort and check if the sorted string or array is equal
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        char arr1[]=s.toCharArray();
        char arr2[]=t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.toString(arr1).equals(Arrays.toString(arr2))) return true;
        return false;
    }

    //convert to hashmap and and check the occurance of each character is same in boths strings

    public static boolean isAnagramUsingHashMap(String s, String t) {
        //first check for length if mismatch surely it is not anagram
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sHashMap = new HashMap<>();

        //populate hashmap with character frequency of each character for first string
        for (char c : s.toCharArray()) {
            if (sHashMap.containsKey(c)) {
                sHashMap.put(c, sHashMap.get(c) + 1);
            } else {
                sHashMap.put(c, 1);
            }
        }
        System.out.println(sHashMap);

        //populate hashmap with character frequency of character for second string
        HashMap<Character, Integer> tHashMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (tHashMap.containsKey(c)) {
                tHashMap.put(c, tHashMap.get(c) + 1);
            } else {
                tHashMap.put(c, 1);
            }
        }
        //if both hashmaps are equal then they are anagrams
        System.out.println(tHashMap);
        if (sHashMap.equals(tHashMap)) {
            return true;
        }
        return false;
    }

    //optimized solution
    //first populate the hashmap with frequency
    //for second hashmap for each occurence decremenet respective value in hashmap
    //if value become negative then false, if all zeroes then anagram

    public static boolean isAnagramOptimized(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sHashMap.put(c,sHashMap.getOrDefault(c,0)+1);
        }

        for (char c:t.toCharArray()){
            sHashMap.put(c,sHashMap.getOrDefault(c,0)-1);
            if(sHashMap.get(c)<0) return false;
        }
        return true;
    }
}
