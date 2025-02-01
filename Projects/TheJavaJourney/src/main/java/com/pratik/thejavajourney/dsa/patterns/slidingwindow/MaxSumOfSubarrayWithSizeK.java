package com.pratik.thejavajourney.dsa.patterns.slidingwindow;

public class MaxSumOfSubarrayWithSizeK {
    public static void main(String[] args) {
        int[] array =  {2, 1, -5, 1, 3, 2};
        //              0, 1, 2, 3, 4, 5
        //                       i
        int K = 3;
        int result = findMaxSumSubarray(array, K);
        System.out.println(result);
    }

    private static int findMaxSumSubarray(int[] array, int k) {
        int[] window=new int[k];
        int currentSum=0;
        int maxSumOfWindow=Integer.MIN_VALUE;
        //iniliaze window with size k
        for(int i=0;i<k;i++){
            currentSum+=array[i];
        }
        maxSumOfWindow=currentSum;

        //slide the window
        for(int i=k;i<array.length;i++){
            if(currentSum>maxSumOfWindow){
                maxSumOfWindow=currentSum;
            }
            //add next element
            currentSum=currentSum+array[i];
            currentSum=currentSum-array[i-k];
            maxSumOfWindow=Math.max(currentSum,maxSumOfWindow);
        }
        return maxSumOfWindow;
    }
}
