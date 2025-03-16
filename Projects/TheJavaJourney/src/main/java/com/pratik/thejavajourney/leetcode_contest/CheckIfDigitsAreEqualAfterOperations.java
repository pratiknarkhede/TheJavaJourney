package com.pratik.thejavajourney.leetcode_contest;

import java.util.Arrays;
import java.util.List;

public class CheckIfDigitsAreEqualAfterOperations {

    public static void main(String[] args) {
        CheckIfDigitsAreEqualAfterOperations cd = new CheckIfDigitsAreEqualAfterOperations();
        String s = "34789";
        boolean b = cd.hasSameDigits(s);
        System.out.println("is it desired string "+b);

    }

    public boolean hasSameDigits(String s) {
        char[] charArray = s.toCharArray();

        while (charArray.length > 2) {
            for (int i = 0; i < charArray.length - 1; i++) {
                int temp = ((Character.getNumericValue(charArray[i]) + Character.getNumericValue(charArray[i + 1])) % 10);
                charArray[i] = Character.forDigit(temp, 10);

            }
            charArray = reduceSizeOfArray(charArray);
            System.out.println(Arrays.toString(charArray));
        }
        return charArray[0] == charArray[1];
    }

    private char[] reduceSizeOfArray(char[] charArray) {
        char[] reducedArray = new char[charArray.length - 1];
        for (int i = 0; i < reducedArray.length; i++) {
            reducedArray[i] = charArray[i];
        }
        charArray = reducedArray;
        return charArray;
    }
}



