package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

import lombok.SneakyThrows;

class TaskThread extends Thread{
    @Override
    public void run(){
        // the task thread runs in loop , sleeping for 1 second and then running again
        //print working everytime
        while (true){
            // task thread checks if it has been asked to stopped, this will be asked via interrupt() method
            if(Thread.interrupted()){
                System.out.println("Interrupt, stopping.");
                break;
            }
            try {
            // if the thead is interrupted while sleeping , it catches InterruptedException
            //print message and breaks the loop
                Thread.sleep(1000);
                System.out.println("Woking...");
            } catch (InterruptedException e) {
                System.out.println("caught interruption , stopping");
                break;
            }

        }
    }
}

//The main thread waits 5 seconds, calls interrupt() to request the task thread stop,
// and waits for it to finish with join().
public class ThreadInterruption {
    @SneakyThrows
    public static void main(String[] args) {
    TaskThread thread=new TaskThread();
    thread.start();
    // main thread sleep for 5 second before singalling task thead to stop through interrupt
    Thread.sleep(5000);
    thread.interrupt();
    // waits for thead to finish its execution
    thread.join();
    }
}
