package com.pratik.thejavajourney.dsa.patterns.slidingwindow;

public class MinSumSubarray {
    public static void main(String[] args) {
        char[] nums={2,3,1,2,4,3};
        int target=7;
        int result=minSubArrayLen(target,nums);
    }

    private static int minSubArrayLen(int target, char[] nums) {
        int result=Integer.MAX_VALUE;
        //we will use two pointers left and right
        //left will point to start of window and right will point to end of window
        //subarray, max keyword hence possibilty of sliding window
        int l=0,r=0,currSum=0;
        for(int i=0;i<nums.length;i++){

            if(r<nums.length){
                currSum=currSum+nums[i];
                r++;
            }

        }
        return 0;
    }
}
