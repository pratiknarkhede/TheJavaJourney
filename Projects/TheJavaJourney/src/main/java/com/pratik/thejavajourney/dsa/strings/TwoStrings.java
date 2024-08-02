package com.pratik.thejavajourney.dsa.strings;

import java.util.Arrays;
import java.util.HashMap;

public class TwoStrings {

    /*    Given an array of integers nums and an integer target,

         return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.*/
    public static int[] twoSum(int[] nums, int target) {
        int sum = 0;
        int[] sumArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return sumArr;
    }

    public static int[] twoSumOptimized(int[] nums, int target) {
        HashMap<Integer, Integer> numWithIndx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numWithIndx.containsKey(complement)) {
                //remember we need to return indices and at key we are storing array element , at value we are storing its index
                return new int[]{i,numWithIndx.get(complement)};
            }
            numWithIndx.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] sum = twoSumOptimized(nums, target);
        System.out.println(Arrays.toString(sum));
    }


}
