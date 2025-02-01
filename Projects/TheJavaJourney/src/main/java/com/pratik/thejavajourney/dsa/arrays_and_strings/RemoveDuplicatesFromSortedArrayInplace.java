package com.pratik.thejavajourney.dsa.arrays_and_strings;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayInplace {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayInplace solution = new RemoveDuplicatesFromSortedArrayInplace();
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        int k = solution.removeDuplicateInplace(nums);

//        System.out.println("Number of unique elements: " + k);
//        System.out.println("Unique elements:");
//        for (int i = 0; i < k; i++) {
//            System.out.print(nums[i] + " ");
//        }
    }

    //not inplace
    private int removeDuplicates(int[] nums) {
        int[] array = Arrays.stream(nums)
                            .distinct()
                            .toArray();
        System.out.println(Arrays.toString(array));
        return array.length;
    }

    private int removeDuplicateInplace(int[] nums) {
        int p1 = 0, p2 = 0;
        while (p1 < nums.length) {
            while (nums[p1] == nums[p2] && p2<nums.length) {
                ++p2;
            }
            p1++;
            while(p1 != p2 && p2<nums.length ){
                nums[p1]=Integer.MIN_VALUE;
                p1++;
            }
        }
        return 0;
    }
}
