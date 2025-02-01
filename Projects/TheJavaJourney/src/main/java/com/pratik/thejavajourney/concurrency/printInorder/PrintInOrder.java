package com.pratik.thejavajourney.concurrency.printInorder;

import java.util.Properties;

public class PrintInOrder {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};


        Runnable printingTask = () -> {
            System.out.println("I am runnign ");
        };
        printingTask.run();
    }

    synchronized private void printFirst(int[] nums) {
        System.out.println("First");
    }

    synchronized private void printSecond(int[] nums) {
        System.out.println("Second");
    }

    synchronized private void printThird(int[] nums) {
        System.out.println("Third");
    }
}
