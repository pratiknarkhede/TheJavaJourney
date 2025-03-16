package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(
                ()->{
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        System.out.println("state after thread creation "+thread.getState());
        thread.start();
        System.out.println("state after  thread is started "+thread.getState());
        Thread.sleep(100);
        System.out.println("State while running: " + thread.getState());
        //join() waits for thread to die
        thread.join();
        System.out.println("State after completion "+thread.getState());
    }
}
