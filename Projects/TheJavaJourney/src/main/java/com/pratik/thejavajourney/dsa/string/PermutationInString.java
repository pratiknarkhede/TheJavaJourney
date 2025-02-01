package com.pratik.thejavajourney.dsa.string;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        boolean isIt = checkInclusion(s1, s2);
        System.out.println("it includes :" + isIt);

    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> s1Map=createAndReturnHashMap(s1);
        Map<Character, Integer> s2Map = createAndReturnHashMap(s2);
        for(Character c: s1Map.keySet()){
            if(s2Map.containsKey(c)){
                int characterCountDifference = s2Map.get(c) - s1Map.get(c);
                if(characterCountDifference <0) return false;
                s2Map.put(c, characterCountDifference);
            }
        }
        System.out.println("s2Map "+s2Map);

        return false;
    }

    private static Map<Character, Integer> createAndReturnHashMap(String s1) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            if (characterCountMap.containsKey(c)) {
                characterCountMap.put(c, characterCountMap.get(c) + 1);
            } else {
                characterCountMap.put(c, 1);
            }
        }
        return characterCountMap;
    }
}
