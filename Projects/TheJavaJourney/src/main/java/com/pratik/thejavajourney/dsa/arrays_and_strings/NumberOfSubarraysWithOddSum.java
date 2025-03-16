package com.pratik.thejavajourney.dsa.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;
//this is wrong
public class NumberOfSubarraysWithOddSum {
    private static final int MOD = 1_000_000_007;
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        NumberOfSubarraysWithOddSum no = new NumberOfSubarraysWithOddSum();
        int i = no.numOfSubarrays(arr);
        System.out.println(i);
    }

    public int numOfSubarrays(int[] arr) {
        //at each index we have choice to either take the element or not take it
        List<Integer> arrayLists = new ArrayList<>();
        findSubarray(0, new ArrayList<>(), arrayLists, arr);
        System.out.println(arrayLists.toString());
        return arrayLists.size();
    }

    private void findSubarray(int i, ArrayList<Integer> sList, List<Integer> arrayLists, int[] arr) {
        //take the first element
        if (i == arr.length) {
            int sum = sList.stream()
                           .mapToInt(num->num.intValue())
                           .sum();
            if (sum % 2 == 1)
                arrayLists.add(sum);
            return;
        }

        sList.add(arr[i]);
        findSubarray(i + 1, sList, arrayLists, arr);
        sList.remove(sList.size() - 1);
        findSubarray(i + 1, sList, arrayLists, arr);
    }
}
