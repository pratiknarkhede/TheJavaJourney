package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

public class WaitNotifyUseCase {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread prodcucerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        prodcucerThread.start();
        consumerThread.start();
    }

}

class Buffer {
    private String item;
    //indicate if buffer is empty or not
    private boolean isEmpty = true;

    //produce() will produce item
    public synchronized void produce(String item) {
        //until buffer is not empty ,wait
        while (!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //if buffer is empty. produce itema
        this.item = item;
        //now that item is produced , make sure to indicate that buffer is not empty again
        isEmpty = false;
        notify();
    }

    public synchronized String consume() {
        //until the buffer is empty wait
        while (isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //consume item
        String item = this.item;
        isEmpty = true;
        // notify producer buffer is empty
        notify();
        return item;
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.produce("Item " + i);
            System.out.println("Produced item: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            buffer.consume();
            System.out.println("Consumer item: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
