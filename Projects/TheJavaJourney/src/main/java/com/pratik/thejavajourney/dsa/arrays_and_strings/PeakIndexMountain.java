package com.pratik.thejavajourney.dsa.arrays_and_strings;

public class PeakIndexMountain {

    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        //  9   10   3   2   1  0
        //               mid
        //
        int peakIndexInMountain = findPeakIndexInMountain(arr);
        System.out.println(peakIndexInMountain);
    }

    private static int findPeakIndexInMountain(int[] arr) {

        int l = 0;
        int length = arr.length;
        int r = length - 1;
        int mid =0;
        while (l < r) {
             mid = (l + r) / 2 ;
            // we know if arr[mid] < arr[mid+1] means ,peak will be in the right since it is increasing
            // we also know peak peak cant be mid since arr[mid+1] is already bigger than arr[mid]
            // so peak will be further down right and it can be mid+1
            //increasing slope
            if (arr[mid + 1] > arr[mid]) {
                l = mid+1;
            }

            // now if arr[mid] > arr[mid+1] , we know peak will be in the left
            // we also know that peak might be at mid or might be further down left
            //decreasing slope
            else if (arr[mid + 1] < arr[mid]) {
                r = mid;
            }
        }
        System.out.println(arr[l]);
        // at terminating condition l=r
        return l;
    }
}
