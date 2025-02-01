package com.pratik.thejavajourney.dsa.patterns.prefixsum;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int nums[]={1,3,4,2,6,8,2};

        int k=4;
        int totalSUbarrayWIthSumK=subarraySumWhichEqualsToK(nums,k);

    }

    private static int subarraySumWhichEqualsToK(int[] nums, int k) {
        
        return 0;
    }

    private static int[] buildPrefixSum(int[] nums) {
        int arrLength = nums.length;
        int preFixSum[]=new int[arrLength];
        preFixSum[0]=nums[0];
        for(int i=1;i<arrLength;i++){
            preFixSum[i]=preFixSum[i-1]+nums[i];
        }
        // System.out.println(Arrays.toString(preFixSum));
        return preFixSum;
    }

    public static int getSubarraySum(int[] nums, int left, int right) {
        int[] prefixSum = buildPrefixSum(nums);
        if(left==0) return prefixSum[right];
        return prefixSum[right]-prefixSum[left-1];
    }
}
