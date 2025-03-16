package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

public class ThreadSaftey {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        Thread t1= new Thread(()->{
            for(int i=0;i<2500;i++){
                counter.increment();
            }
        });

        Thread t2= new Thread(()->{
            for(int i=0;i<2500;i++){
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
    }
}

class Counter {
    private int count = 0;
    //if we didnt use synchronized final count may be less than 5000

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}


