package com.pratik.thejavajourney.dsa.dynamicprogramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        HouseRobber robber =new HouseRobber();
        int robbedMoney = robber.rob(nums);
        System.out.println(robbedMoney);
    }

    public int rob(int[] nums) {
        // at every house we have two choices
        // either to rob the house , this will allow us to take money from this house
        // and previous to previous house

        //or skip the house and keep the money collected until previous house

        /*
        *
        *
        *             skip      previous_house_money (prev)
        *                     /
        * current_max= max of
        *                     \ this house money + prev2
        *
        *
        *
        * */

        int prev=0;
        int prev2=0;
        int current_max=0;
        int n=nums.length;
        for(int house_money : nums){
            current_max= Math.max(prev,  prev2 + house_money);
            // now as we move to next house , house previous to previous becomes previous
            prev2=prev;
            // prev becomes how much max we have gotten till the prev house
            prev=current_max;

        }

        return current_max;
    }
}
