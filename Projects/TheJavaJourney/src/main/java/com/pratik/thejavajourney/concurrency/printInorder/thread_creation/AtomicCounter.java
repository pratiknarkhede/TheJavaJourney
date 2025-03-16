package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger counter=new AtomicInteger(0);
    public void increment(){
        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }


    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter=new AtomicCounter();
        Thread[] threads=new Thread[5];
        for (int i=0;i<5;i++){
            threads[i]=new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread thread:threads){
            thread.join();
        }
        System.out.println("Actual count after simulatenous increment by 5 threads is "+counter.getCounter());

    }

}
