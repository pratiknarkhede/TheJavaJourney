package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

public class VolatileUsecase {
    private volatile boolean running=true;
    public void stop(){
        running=false;
    }

    public void run() {
        while(running){
            System.out.println("Thread is still running..");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread stopped execution ");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileUsecase volatileUsecase=new VolatileUsecase();
        Thread t=new Thread(volatileUsecase::run);
        t.start();
        Thread.sleep(1000);
        volatileUsecase.stop();
        t.join();
    }

}
