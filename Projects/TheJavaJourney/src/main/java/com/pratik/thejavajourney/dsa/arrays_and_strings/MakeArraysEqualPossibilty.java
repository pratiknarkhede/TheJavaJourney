package com.pratik.thejavajourney.dsa.arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;

public class MakeArraysEqualPossibilty {
    public static void main(String[] args) {
        MakeArraysEqualPossibilty possibilty = new MakeArraysEqualPossibilty();
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        boolean result = possibilty.canBeEqual(target, arr);
        System.out.println(result); // Output: true
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        if (arr.length != target.length) {
            return false;
        }
        if (arr.length == 1) {
            if (arr[0] == target[0])
                return true;
        }
        HashMap<Integer, Integer> targetHashMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (targetHashMap.containsKey(target[i])) {
                targetHashMap.put(target[i], targetHashMap.get(target[i]) + 1);
            } else {
                targetHashMap.put(target[i], 0);
            }

        }


        HashMap<Integer, Integer> arrHashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arrHashMap.containsKey(arr[i])) {
                arrHashMap.put(arr[i], arrHashMap.get(arr[i]) + 1);
            } else {
                arrHashMap.put(arr[i], 0);
            }

        }

        if (arrHashMap.equals(targetHashMap)) {
            return true;
        }
        return false;
    }

    //simply sort the arrays and check for equality
    public boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
