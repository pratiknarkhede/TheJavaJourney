package com.pratik.thejavajourney.dsa.string;

import java.util.HashMap;
import java.util.Map;

class ValidPairAdjacentDigits {
    public String findValidPair(String s) {
        Map<Character, Integer> characterCountMap = createAndReturnHashMap(s);
        for (int i = 0; i < s.length() - 2; i++) {
            Integer i1 = Character.getNumericValue(s.charAt(i));
            Integer i2 = Character.getNumericValue((s.charAt(i+1)));
            if (!i1.equals(i2) && i1.equals(characterCountMap.get(s.charAt(i)))
                    && (i2.equals(characterCountMap.get(s.charAt(i + 1))))) {
                return i1+""+i2;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String s = "221";
        ValidPairAdjacentDigits v = new ValidPairAdjacentDigits();
        String validPair = v.findValidPair(s);
        System.out.println(validPair);
    }


    private Map<Character, Integer> createAndReturnHashMap(String s1) {
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