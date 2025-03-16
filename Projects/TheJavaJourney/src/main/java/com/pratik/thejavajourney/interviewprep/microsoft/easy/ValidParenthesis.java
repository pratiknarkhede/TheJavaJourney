package com.pratik.thejavajourney.interviewprep.microsoft.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "([}}])";
        ValidParenthesis validParenthesis = new ValidParenthesis();
        boolean valid = validParenthesis.isValid(s);
        System.out.println("Is string " + s + " valid " + valid);

    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char c : s.toCharArray()) {
            // check if c is closing bracket , all keys are closing brackets
            if (map.containsKey(c)) {
                if (stack.empty() || map.get(c) != stack.pop()) {
                    return false;
                } else {
                    if (c == '(' || c == '[' || c == '{') {
                        stack.push(c);
                    }

                }
            }
        }
        return stack.empty();
    }
}
