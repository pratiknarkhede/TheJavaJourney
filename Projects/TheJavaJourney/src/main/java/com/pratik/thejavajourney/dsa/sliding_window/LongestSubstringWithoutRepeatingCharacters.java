package com.pratik.thejavajourney.dsa.sliding_window;

import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String  s = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters longestSub= new LongestSubstringWithoutRepeatingCharacters();
        int lengthOfsubstring = longestSub.lengthOfLongestSubstring(s);
        System.out.println(lengthOfsubstring);

    }
    public int lengthOfLongestSubstring(String s) {
        // maintain window of unique elements
        Set<Character> windowSet=new HashSet<>();
        int l=0;
        int max_size=0;
        for(int i=0;i<s.length();i++){
            while(windowSet.contains(s.charAt(i))){
                windowSet.remove(s.charAt(l));
                l++;
            }
            windowSet.add(s.charAt(i));
            int current_size=i-l+1;
            if(current_size > max_size){
                max_size=current_size;
            }
        }
    return max_size;
    }
}   