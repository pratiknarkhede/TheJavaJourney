package com.pratik.thejavajourney.concurrency.printInorder;

public class PrintInorderExcecution extends Thread {

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    public void run() {
        System.out.println();
    }
}
