package com.pratik.thejavajourney.dsa.patterns.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*      first step in problem involving this pattern is to build prefix array
        which is auxillary array , in which at any given index i , arr[i] is sum of all previous elements upto that
        index i , and surely it will also include the element at i itself in that sum
*/


/*      Also another useful thing is to create a method which will support return subarray sum , where we will provide range of
        of subarray with left and right indexes    */
public class PrefixSum {
    public static void main(String[] args) {
        int nums[]={1,3,4,2,6,8,2};
        int prefixSumArr[]=buildPrefixSum(nums);
        System.out.println(Arrays.toString(prefixSumArr));
        int subarraySum = getSubarraySum(nums, 2, 4);
        System.out.println(subarraySum);
        buildPrefixSumMap(nums);
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


    private static Map<Integer,Integer> buildPrefixSumMap(int[] nums) {
        Map<Integer,Integer> prefixSumMap=new HashMap<>();
        int prefixSum=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            prefixSumMap.put(i,prefixSum);
        }
        System.out.println(prefixSumMap);
        return prefixSumMap;
    }


    /*sum of subarray */
    /*sumOfSub(left,right)= preFixSum[right]-prefixSum[left-1]*/

    public static int getSubarraySum(int[] nums, int left, int right) {
        int[] prefixSum = buildPrefixSum(nums);
        if(left==0) return prefixSum[right];
        //here note we are considering prefixSum[left] and not prefixSum[left-1],
        //because prefixSum[left] will have sum of array elemens
        return prefixSum[right]-prefixSum[left];
    }


}
