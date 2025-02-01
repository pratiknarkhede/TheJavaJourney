package com.pratik.thejavajourney.dsa.binary_search;


import java.util.Arrays;

/*        You are given an m x n integer matrix matrix with the following two properties:

        Each row is sorted in non-decreasing order.
                The first integer of each row is greater than the last integer of the previous row.
                Given an integer target, return true if target is in matrix or false otherwise.

                You must write a solution in O(log(m * n)) time complexity.*/
public class TwoDSortedArraySearch {
    public static void main(String[] args) {
        int[][] matrix = {{11, 12, 13, 14},
                {15, 16, 17, 18},
                {19, 20, 21, 22}};
        int target = 22;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);

        // using non recursive

        boolean b1 = searchMatrixNonRecursive(matrix, target);
        System.out.println("using non recursive approach do we find the element " + b1);
    }

    /*
    row-wise j changes
    column-wise i changes

    our approach is two imagine 1D array out of the 2D sorted array and apply binary serach on it

    it just that we would need to equate the index in 2D array with the current logical index in 2d array

    formula would be (0 indexed array)
    index in 2D =  (i) * n+ (j)
    matrix is m * n

    row wise j changes
    and we need to calculate how many rows are gone to reach that row so i changes

    To determine how many complete rows fit within index (how many rows we passed), perform integer division:
    i=index//n

    To determine the remainder after dividing  index by 𝑛 (how far into the row we are)
    j=index%n

    */

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = (m * n) - 1;

        boolean b = doBinarySearch(left, right, matrix, target);
        System.out.println("is seach found " + b);
        return b;
    }

    private static boolean doBinarySearch(int left, int right, int[][] matrix, int target) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        int n = matrix[0].length; // nuber of elements in row
        int i = mid / n;
        int j = mid % n;
        if (matrix[i][j] == target) {
            return true;
        } else if (matrix[i][j] > target) {
            right = mid - 1;
            return doBinarySearch(left, right, matrix, target);
        } else {
            left = mid + 1;
            return doBinarySearch(left, right, matrix, target);
        }
    }

    public static boolean searchMatrixNonRecursive(int[][] matrix, int target) {
        int m = matrix.length;//number of rows
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / n; // how many rows passed till mid
            int j = mid % n; // how many elements in that row (how many columns passed ) till mid
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}


