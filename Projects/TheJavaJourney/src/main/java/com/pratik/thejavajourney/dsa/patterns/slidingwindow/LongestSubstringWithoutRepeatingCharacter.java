package com.pratik.thejavajourney.dsa.patterns.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
        // Output: 3
    }

    private static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int windowStart = 0;
        // we will maintain a set to store current window with unique chars
        //we will iterate with i to check each character of i ,
        //if it is present , we will reduce the windowSize by removing element from windowStart which is 0 at the iniliazation
        //we will keep removing the element at index [windowStart] by checking if our set contains that
        //until set has unique characters again
        // if it current char at string i,e element at i is not present in set
        //we will add it to set ,
        //current size of window will be , the current pointer(endpointer which is i)- (start pointer)startWindow +1 (since index start at 0)

        Set<Character> charSet = new HashSet<>();
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            while (charSet.contains(s.charAt(i))) {
                charSet.remove(s.charAt(windowStart));
                windowStart++;
            }


            charSet.add(s.charAt(i));
            currentLength = i - windowStart + 1;
            maxLength = Math.max(maxLength, currentLength);

        }

        return maxLength;
    }
}
