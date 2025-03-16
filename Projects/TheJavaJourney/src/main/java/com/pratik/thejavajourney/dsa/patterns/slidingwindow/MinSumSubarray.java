package com.pratik.thejavajourney.dsa.patterns.slidingwindow;

public class MinSumSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 1, 1, 4, 3};
        int target = 7;
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (r < nums.length) {
            while (sum <= target) {
                sum += nums[r];
                r++;
            }
            minLength = Math.min(minLength, r - l + 1);
            while (sum > target) {
                sum = sum - nums[l];
                l++;
            }

        }


        return minLength;
    }

    //brute force
    private static int minSubArrayLen1(int target, int[] nums) {

        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    minSize = Math.min(minSize, j - i + 1);
                }
            }
        }
        if (minSize == Integer.MAX_VALUE) {
            return 0;
        }

        return minSize;
    }
}
