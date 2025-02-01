package com.pratik.thejavajourney.dsa.binary_search;

public class MinimumElementInSortedArray {

    public static void main(String[] args) {
        int arr[] = {2,1};
        //int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int min = findMin(arr);
        System.out.println("Minimum in the array is : " + min);
    }

    public static int findMin(int[] nums) {

        int left=0;
        int length = nums.length;
        int right= length-1;
        // if leftmost element is less than rightmost element array is in its original ascending order state
        if(nums[left] < nums[right]){
            return nums[left];
        }

        /*
         * if element at our mid is greater than rightmost element then ,
         * then the pivot which is starting point of sorted array is in the right half
         *
         * if the array is rotated , its sorted order will be break into
         * two sorted arrays
         *
         * we need to find the point where the sorted order is breaked
         *
         * [4,5,6,7,0,1,2]
         * two sorted array [4,5,6,7] and [0,1,2]
         * The minimum element is at the pivot point (where the rotation "breaks" the sorted order).
         *
         * */

        int mid= 0;
        while (left < right) {
            mid = (left+right)/2;
            if(mid>0 && nums[mid]< nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid] > nums[right]){
                left=mid+1;
            }else{
                //observere we didnt take mid-1 ,as it could result in skipping minimum element
                right=mid;
            }
        }
        return nums[left];
    }
}
