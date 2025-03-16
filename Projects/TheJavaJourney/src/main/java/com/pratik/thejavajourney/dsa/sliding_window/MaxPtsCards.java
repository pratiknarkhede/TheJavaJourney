package com.pratik.thejavajourney.dsa.sliding_window;

public class MaxPtsCards {
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        MaxPtsCards m= new MaxPtsCards();
        int maximumPoints = m.maxScore(cardPoints, k);
        System.out.println(maximumPoints);

    }

    public int maxScore(int[] cardPoints, int k) {
        //first calculate sum of first k elements of array
        int lsum=0;
        int rsum=0;
        int n=cardPoints.length;

        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        int max=lsum;
        if (n==k) return lsum;
        int rightIndex=n-1;
        System.out.println(lsum);
        for(int leftIndex=k-1;leftIndex>=0;leftIndex--){
            lsum -= cardPoints[leftIndex]; // Remove leftmost element
            rsum += cardPoints[rightIndex]; // Add rightmost element
            rightIndex=rightIndex-1;
            max = Math.max(lsum+rsum, max);
        }
        return max;
    }
}
