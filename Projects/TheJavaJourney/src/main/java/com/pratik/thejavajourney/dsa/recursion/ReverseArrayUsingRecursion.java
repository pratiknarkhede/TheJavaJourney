package com.pratik.thejavajourney.dsa.recursion;

import java.util.Arrays;

public class ReverseArrayUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 2, 5};
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr) {

        int r = arr.length - 1;
        int l = 0;

        reverse(arr, l, r);
    }

    private static void reverse(int[] arr, int l, int r) {
        if (l >= r) return;
        swap(arr, l, r);
        reverse(arr, l + 1, r - 1);
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = 0;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


}
