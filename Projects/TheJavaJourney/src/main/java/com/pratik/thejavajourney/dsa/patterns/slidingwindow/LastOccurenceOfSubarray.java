package com.pratik.thejavajourney.dsa.patterns.slidingwindow;

import java.util.Arrays;

public class LastOccurenceOfSubarray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 3, 4, 1, 2, 3, 2, 4, 5};
        StringBuilder s1 = new StringBuilder();
        for (int i=0;i< arr.length;i++){
            s1.append(arr[i]);
        }
        int subArr[] = {2, 3, 2};
        StringBuilder s2= new StringBuilder();
        for(int i=0;i< subArr.length;i++){
            s2.append(subArr[i]);
        }
        System.out.println(s1 + "      " + s2);
        int index = s1.lastIndexOf(s2.toString());
        System.out.println(index);
        // expected out put index=8
       // int ansIndex = findIndexOfLastOccurenceOfArray(arr, subArr);
    }

    private static int findIndexOfLastOccurenceOfArray(int[] arr, int[] subArr) {


        String string = Arrays.toString(arr);
        System.out.println(string);
        String string1 = Arrays.toString(subArr);
        System.out.println(string1);
        int i = string.lastIndexOf(string1);
        System.out.println(i);



        return 0;
    }


}
