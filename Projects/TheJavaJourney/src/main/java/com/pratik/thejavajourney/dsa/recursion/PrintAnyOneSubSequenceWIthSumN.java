package com.pratik.thejavajourney.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAnyOneSubSequenceWIthSumN {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 3, 2};
        int target = 6;
        List<Integer> sqnceWithSumN = calculateSubSequence(arr, target);
    }

    private static List<Integer> calculateSubSequence(int[] arr, int target) {
        ArrayList<Integer> sList = new ArrayList<>();
        findSubSequenceWithSumN(0, sList, arr, 0, target);

        return sList;
    }


    /*
    * we have made the method boolean
    *
    * */
    private static boolean findSubSequenceWithSumN(int i, ArrayList<Integer> sList, int[] arr, int tempSum, int target) {
        //at each step we have choice to take that element or not take
        //terminating condition is if we reach the last index and sum is target

        if (i >= arr.length) {
            if (tempSum == target) {
                System.out.println(new ArrayList<Integer>(sList));
                return true; //if we find the target subsequnece no need to check further return
            } else
                return false;
        }
        //choose to take element at index i
        sList.add(arr[i]);
        tempSum += arr[i];
        // skip checking futher if we found the target
        if (findSubSequenceWithSumN(i + 1, sList, arr, tempSum, target)) {
            return true;
        }
        /*choose to not take element at index i
        frequeunt mistake , remove takes index so we dont need to give array element instead last element
        dont do this
        sList.remove(arr[sList.size()-1]);
        */
        sList.remove(sList.size() - 1);
        tempSum -= arr[i];
        if (findSubSequenceWithSumN(i + 1, sList, arr, tempSum, target)) {
            return true;
        }
        return false;
    }
}
