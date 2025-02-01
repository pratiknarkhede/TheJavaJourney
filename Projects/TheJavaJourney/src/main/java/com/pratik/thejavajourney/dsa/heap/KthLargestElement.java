package com.pratik.thejavajourney.dsa.heap;

import java.util.*;
import java.util.stream.Collectors;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};// 1,2,3,4,5,6
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);

        int kSmallest = findKSmallest(nums, k);
        System.out.println(kSmallest);
    }

    private static int findKthLargest(int[] nums, int k) {
        //prirotiy Q expectes comparator so we are passing compartor that imposes reverse order
        //this will maintain a max heap
        PriorityQueue<Integer> priorityQbasedOnLargestElement=new PriorityQueue<>(Collections.reverseOrder());
        for(int element : nums){
            priorityQbasedOnLargestElement.offer(element);
        }

        for(int i=0;i<k-1;i++){
            priorityQbasedOnLargestElement.poll();
        }

        int kthLargestElement = priorityQbasedOnLargestElement.poll();
        return kthLargestElement;
    }

    public static int findKSmallest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int element : nums){
            priorityQueue.offer(element);
        }


/*  Another way to initliaze Q
      List<Integer> list = Arrays.stream(nums)
                                      .boxed()
                                      .collect(Collectors.toList());

        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(list);*/


        for(int i = 0; i<k-1; i++){
            priorityQueue.poll();
        }
        int kthSmallestElement = priorityQueue.poll();
        return kthSmallestElement;
    }
}
