package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

public class SimpleThreadCreation {
    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread myThread=new Thread(myRunnable);
        //start the thread
        myThread.start();
    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("implemented Runnable interface and thread name is "+Thread.currentThread().getName());
    }
}
