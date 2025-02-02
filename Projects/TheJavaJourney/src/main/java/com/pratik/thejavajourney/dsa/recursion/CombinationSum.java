package com.pratik.thejavajourney.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        //int[] candidates = {2, 3};
        int target = 7;
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> targetSumList = cs.combinationSum(candidates, target);
        System.out.println(targetSumList);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> targetSumList=new ArrayList<>();
        /*
        * observe we avoid returning answer as return value
        * instead we passed the data structure with ans (which is list of list) by reference
        * and carry forwarded that reference in each recusion call
        *
        * so if any time targetSumList is modified , original targetSumList will be also modified since it is same,
        * and we are working on reference
        *
        * and in the end with our helper method we will pass the targetSumList back as return value
        *
        * */
        findSubsequenceWithSum(0, new ArrayList<>(), targetSumList, arr, target);
        return targetSumList;
    }

    private void findSubsequenceWithSum(int i, ArrayList<Integer> sList, List<List<Integer>> targetSumList, int[] arr, int target) {

        if (i >= arr.length) {
            if (target == 0) {
                targetSumList.add(new ArrayList<>(sList));
            }
            return;
        }

        // we will keep on picking same index till the target sum becomes less than or equal to element at that index
        // if it is larger there wont be any point going further that recusrive tree branch ,since sum will never be 0
        if (arr[i] <= target) {
            sList.add(arr[i]);
            // we will chose same index but now since since we already chosen the same index
            //target will be reduced to target-element at that index
            findSubsequenceWithSum(i, sList, targetSumList, arr, target - arr[i]);
            sList.remove(sList.size() - 1);
        }
        // we decided that previous branch of recursive tree dont have any possibility
        // so we move to next index with whatever element being picked multiple times by at previously
        findSubsequenceWithSum(i + 1, sList, targetSumList, arr, target);
    }
}

