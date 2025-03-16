package com.pratik.thejavajourney.interviewprep.microsoft.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
* We have taken a hashmap
*
* with array element as key and its index as value
*
* now while iterating through the array
*
* we calculate compliment which will be target - current array element
*
*
* if that compliment is present in map ,
*
* then we will return index of current array element and the compliment
*
* if the compliment is not present we will simply add the element to the array
*
*
* */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] sol = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(sol));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] resultArr = new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        int length = nums.length;
        for(int i = 0; i< length; i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{i,map.get(compliment)};
            }
            map.put(nums[i],i);
        }
        return resultArr;
    }



}
