package com.pratik.thejavajourney.dsa.algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 0;
//        int search = search(nums, target);
//        System.out.println(search);

        int search2 = searchRecursive(nums, target);
        System.out.println(search2);
    }

    //iterative way
    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }


    //recursive way
    private static int searchRecursive(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        return doRecursiveSearch(left, right, nums, target);
    }

    private static int doRecursiveSearch(int left, int right, int[] nums, int target) {
        if (left > right) {
            return -1;
        }
        int mid=(left+right)/2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) {
            right=mid-1;
            return doRecursiveSearch(left, right, nums, target);
        } else {
            left=mid+1;
            return doRecursiveSearch(left, right, nums, target);
        }
    }
}
