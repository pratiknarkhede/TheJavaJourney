package com.pratik.thejavajourney.dsa.sliding_window;

public class MinSizeSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        MinSizeSubarray mms = new MinSizeSubarray();
        int minLength = mms.minSubArrayLen(target, nums);
        System.out.println(minLength);
    }

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;
        int r = 0;
        int n = nums.length;
        int min_size = n+1;
        int sum = 0;
        int current_size = 0;
        //we keep adding element at right pointer(r) till r reaches end
        while (r < n) {
            sum = sum + nums[r];
            while (sum >= target && l <= r) {
                //when sum equals or exceeds target we will calculate current window size
                current_size = r - l + 1;
                if (current_size < min_size) {
                    min_size = current_size;
                }
                //when sum equals or exceeds target, we will try to shrink the window size, till it becomes less than target
                sum = sum - nums[l];
                l++;
            }
            r++;
            //System.out.println(sum);
        }

        if(min_size > n) return 0;
        return min_size;
    }


}
