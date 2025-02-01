package com.pratik.thejavajourney.dsa.patterns.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RangeSumQueryImmutable {




    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 2, 6, 8, 2};
        int sum = sumRange(3, 5,nums);
        System.out.println(sum);
        int[] prefixArray = buildPrefixArray(nums);
        System.out.println("array:   "+Arrays.toString(prefixArray));
    }


    public static <nums> int sumRange(int left, int right,int[] nums) {
        Map<Integer, Integer> prefixMap = buildPrefixMap(nums);
        System.out.println(prefixMap);
        if (prefixMap.containsKey(left) && prefixMap.containsKey(right)) {
            return prefixMap.get(right) - prefixMap.get(left - 1);
        }else{
            return Integer.MIN_VALUE;
        }
    }

    public static Map<Integer, Integer> buildPrefixMap(int[] nums) {
        HashMap<Integer, Integer> preFixSumMap = new HashMap<>();
        int preFixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preFixSum = preFixSum + nums[i];
            preFixSumMap.put(i, preFixSum);
        }
        System.out.println(preFixSumMap);
        return preFixSumMap;
    }


    public static int[] buildPrefixArray(int[] nums){
        int[] prefixSum=new int[nums.length];
        prefixSum[0]= nums[0];
        for(int i = 1; i< nums.length; i++){
            prefixSum[i]=prefixSum[i-1]+ nums[i];
        }

        return prefixSum;
    }
}
