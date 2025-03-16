package com.pratik.thejavajourney.dsa.sliding_window;

class MaxAvgSalaryOne {

    public static void main(String[] args) {
        int[] nums={1,12,-5,-6,50,3};
        int k=4;
        MaxAvgSalaryOne maxAvgSalaryOne=new MaxAvgSalaryOne();
        double maxAverage = maxAvgSalaryOne.findMaxAverage(nums, k);
        System.out.println(maxAverage);

    }
    public double findMaxAverage(int[] nums, int k) {
        int l=0;
        int r=k-1;
        int n=nums.length;
        double max_sum=Integer.MIN_VALUE;
        //calculate avg of window till k
        int sum=0;
        for(int i=0;i<k;i++){
          sum+=nums[i];      
        }
        System.out.println(sum);
        max_sum=sum;
        while(r<n-1){
            r++;
            sum=sum-nums[l]+nums[r];
            max_sum=Math.max(sum,max_sum);
            l++;
        }
        return max_sum/k;

    }
}