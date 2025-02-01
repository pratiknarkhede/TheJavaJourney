package com.pratik.thejavajourney.dsa.arrays_and_strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurence {
    public static void main(String[] args) {
        String s = "Rodion Ramnovic Raskalnikov";
        HashMap<Character, Integer> countMap = calculateCharacterCount(s);
        System.out.println(countMap);
        Map<Character, Long> countMap2 = calculateCharacterCountWithFP(s);
        System.out.println(countMap2);
    }

    private static Map<Character, Long> calculateCharacterCountWithFP(String s) {
        Map<Character, Long> charcountMap = s.chars()
                                        .mapToObj(c -> (char) c)
                                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return charcountMap;
    }

    private static HashMap<Character, Integer> calculateCharacterCount(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!countMap.containsKey(c)) {
                countMap.put(c, 1);
            } else {
                countMap.put(c, countMap.get(c) + 1);
            }
        }
        return countMap;
    }



}
