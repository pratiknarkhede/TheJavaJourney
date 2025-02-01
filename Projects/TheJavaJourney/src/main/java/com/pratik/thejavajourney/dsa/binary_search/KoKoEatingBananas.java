package com.pratik.thejavajourney.dsa.binary_search;

import java.util.Arrays;

public class KoKoEatingBananas {
    /*
     * Input: piles = [1,4,3,2], h = 9

     * Output: 2
     *

     *
     * Return the minimum integer k such that you can eat all
     * the bananas within h hours.
     *
     *
     *
     * 4 :-> 4
     * 3 :-> 5
     * 2 :-> 7
     * 1 :-> 10 > 9 hence answer is previous i.e 2
     *
     * */

    public static void main(String[] args) {

//        int[] banana_piles = {25,10,23,4};
//        int total_max_hours = 4;


        int[] banana_piles = {1,4,3,2};
        int total_max_hours = 9;
        int bananas_per_hour = 3;


        bananas_per_hour = bruteForceApproach(banana_piles, total_max_hours);
        System.out.println("minimal rate of hours to eat bananas: " + bananas_per_hour);


        bananas_per_hour=binarySearcvhApproach(banana_piles,total_max_hours);
        System.out.println("minimal rate of hours to eat bananas using binary search: " +bananas_per_hour);

    }



    private static int bruteForceApproach(int[] bananaPiles, int totalMaxHours) {
        int min = 1;
        int max = findMaxElementInArray(bananaPiles);
        for (int i = min; i <= max; i++) {
            double v = totalHoursToEatBananaWithGivenHours(bananaPiles, i);
            if (v <= totalMaxHours) return i;
        }
        return -1;
    }

    private static int findMaxElementInArray(int[] bananaPiles) {
        int max = Integer.MIN_VALUE;
        for (int banana : bananaPiles) {
            if (banana > max) {
                max = banana;
            }
        }
        return max;
    }

    /*
     *
     * if we take rate of eating banana as max element in array, it will give total hours to
     * eat bananas as number of elements like here if take rate as 4 , total hours will be 4
     *
     * and if we take rate as more than 4 say 5 still hours required will be 4 in total, so doesnt make sense to take 5
     *
     * so maximum rate will be 4 which max element in array and minimum rate can start from 1
     *
     * so the desired rate will lay between (1, 4) and we need to take minimal rate which satisfy our condition
     *
     * the condition is that total hours to eat bananas should be less than 9
     *
     * so we will start with 1 and see totals hours to eat banana : 10 > 9 hence doesnt work
     *
     * now for 2 : --> 6 < 9 works
     *
     * for 3 :--> 5  < 9 works
     *
     * but we want minimal rate so we will stop whenever condition is satisfied
     * */

    private static double totalHoursToEatBananaWithGivenHours(int[] bananaPiles, int bananasPerHour) {
        double hours = 0;
        for (int bananaPile : bananaPiles) {
            hours += Math.ceil((double) bananaPile / bananasPerHour);
        }
        return hours;
    }


    /*
    * we can optimize here ,
    * since there are possible range of answers , we can apply binary search
    *
    * suppose if answer lies between range 1 to 11
    *
    * now if 5 satisfy the condtion every element greateer than 5 will so will ignore right of 5 since we are looking
    * for minimal value so new range would be (1  to  5)
    *
    * */
    private static int binarySearcvhApproach(int[] bananaPiles, int totalMaxHours) {


        int left= 1;
        int right = findMaxElementInArray(bananaPiles);

        while (left <=right) {
            int mid =(left+right)/2 ;
            int v = (int)totalHoursToEatBananaWithGivenHours(bananaPiles, mid);
            if(v <= totalMaxHours){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        return left;
    }


}
