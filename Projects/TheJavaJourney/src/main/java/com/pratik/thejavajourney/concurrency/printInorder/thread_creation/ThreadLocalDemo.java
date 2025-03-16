package com.pratik.thejavajourney.concurrency.printInorder.thread_creation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    // This ThreadLocal holds the user ID for the current request/thread
    private static final ThreadLocal<String> userContext = new ThreadLocal<>();

    private static final ThreadLocal<String> threadName = ThreadLocal.withInitial(() -> Thread.currentThread()
                                                                                              .getName());

    // Simulates logging with user context
    public static void logActivity(String activity) {
        System.out.println("[User: " + userContext.get() +
                ", Thread: " + threadName.get() +
                "] " + activity);
    }


    public static void performBusinessLogic() {
        // Notice we don't pass the user ID, yet the method "knows" which user it's for
        // since the thread handling the request will retrive the userId from the context
        logActivity("performing business logic "+userContext.get());

    }

    public static void processRequest(String userId) {
        // setting userConext for this thread , means current thread
        try {
            userContext.set(userId);
            logActivity("Started processing request "+userContext.get());
            // Simulate some processing time

            Thread.sleep((int) (5 * 1000));


            performBusinessLogic();
            logActivity("Completed request "+userContext.get());
        } catch (InterruptedException e) {
            Thread.currentThread()
                  .interrupt();
            logActivity("Request interrupted");
        } finally {
            // IMPORTANT: Always clean up ThreadLocal values when done
            //otherwise it will lead to memory leak
            userContext.remove();
        }
    }


    public static void main(String[] args) {
        // Simulate multiple concurrent requests using a thread pool
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        //submit 5 request for different users
        for (int i = 0; i < 5; i++) {
            final String userId= "user"+i;
            executorService.submit(()->processRequest(userId));

        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
