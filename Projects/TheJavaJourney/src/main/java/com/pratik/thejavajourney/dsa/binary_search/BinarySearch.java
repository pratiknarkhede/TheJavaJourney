package com.pratik.thejavajourney.dsa.binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 12;
        int searchedIndex = search(nums, target);
        System.out.println("found at index " + searchedIndex);
    }

    public static int search(int[] nums, int target) {
        int x = doSearch(0, nums.length - 1, nums, target);
        return x;
    }

    private static int doSearch(int left, int right, int[] nums, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) {
            left = mid + 1;
            return doSearch(left, right, nums, target);
        } else {
            right = mid - 1;
            return doSearch(left, right, nums, target);

        }
    }
}
