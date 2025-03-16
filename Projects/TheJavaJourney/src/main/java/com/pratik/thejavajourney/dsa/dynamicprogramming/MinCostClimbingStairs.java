package com.pratik.thejavajourney.dsa.dynamicprogramming;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {10, 15, 20/*, 21*/};

        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int minCost = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println(minCost);
    }

    public int minCostClimbingStairs(int[] cost) {
        return 0;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int minCost = 0;
        int minCostToClimbPrevStep = cost[0];
        int minCostToClimb2StepsBack = cost[1];
        int currentCost=0;
        for (int i = 2; i < cost.length; i++) {
            currentCost=cost[i]+Math.min(minCostToClimbPrevStep,minCostToClimb2StepsBack);
            System.out.println("currentCost "+currentCost);
            minCostToClimb2StepsBack=minCostToClimbPrevStep;
            minCostToClimbPrevStep=currentCost;
        }
        return currentCost;
    }
}
