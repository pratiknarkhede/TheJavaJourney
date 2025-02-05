package com.pratik.thejavajourney.dsa.recursion;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        //int arr[] = {10, 1, 2, 7, 6, 1, 5};
        int arr[] = {1, 2, 1, 1};
        int target = 2;
        List<List<Integer>> ansList = combinationSumII.combinationSum2(arr, target);
//        Set<List<Integer>> uniqueCombinations = new HashSet<>();
//        for (int i = 0; i < ansList.size(); i++) {
//            uniqueCombinations.add(ansList.get(i));
//
//        }
//        System.out.println(ansList);

        System.out.println(ansList);
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> targetSumList = new ArrayList<>();
        Arrays.sort(arr);
        findSumCombination(0, new ArrayList<>(), targetSumList, arr, target);
        return targetSumList;
    }

    private void findSumCombination(int index, ArrayList<Integer> sList, List<List<Integer>> targetSumList, int[] arr, int target) {

        if (target == 0) {
            targetSumList.add(new ArrayList<>(sList));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            sList.add(arr[i]);
            findSumCombination(i + 1, sList, targetSumList, arr, target - arr[i]);
            sList.remove(sList.size() - 1);
        }
    }

}
