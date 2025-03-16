package com.pratik.thejavajourney.dsa.hashmap;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call the function and print the result
        List<List<String>> result = new GroupAnagrams().groupAnagrams(input);
        System.out.println(result);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //hashmap to store sorted list
        Map<String, List<String>> sortedStringMap = new HashMap<>();
        for(String str : strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(str);
            sortedStringMap.computeIfAbsent(sortedString,k->new ArrayList<>()).add(str);
            if (!sortedStringMap.containsKey(sortedString)) {
                sortedStringMap.put(sortedString, new ArrayList<>());
            }
            sortedStringMap.get(sortedString).add(str);
        }
        System.out.println(sortedStringMap);
        return new ArrayList<>(sortedStringMap.values());
    }
}
