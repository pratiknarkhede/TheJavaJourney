package com.pratik.thejavajourney.dsa.dynamicprogramming;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 4;
        ClimbingStairs cs = new ClimbingStairs();
        int totalSteps = cs.climbStairs(n);
        System.out.println(totalSteps);
    }

    public int climbStairs2(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs(int num) {
        if(num<=2) return num;
        int waysToReachPreviousStep = 2; // Ways to reach step 2
        int waysToReachTwoStepsBack = 1; // Ways to reach step 1
        int waysToReachCurrentStep=0;
        for(int i=3;i<=num;i++){
            waysToReachCurrentStep = waysToReachPreviousStep + waysToReachTwoStepsBack;
            // now on next step
            // step1Count will become step 1
            // and step2Count will become currentStepCount
            waysToReachTwoStepsBack = waysToReachPreviousStep;
            waysToReachPreviousStep = waysToReachCurrentStep;
        }
        return waysToReachCurrentStep;
    }


}
