package com.pratik.thejavajourney.dsa.stack_and_queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        if(q1.isEmpty()){
            throw new IllegalStateException("stack is empty");
        }

        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        //retrieve poppedElement
        int poppedElement=q1.poll();
        swapQueues();
        return poppedElement;

    }

    private void swapQueues1(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }

    //top() is similar to pop() in our case it just that it wont delete the top elements just returns it
    public int top() {
        if(q1.isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        while(q1.size() >1){
            q2.offer(q1.poll());
        }
        int topElement=q1.poll();
        //since we dont remove the element while calling top just re add it to q2
         q2.offer(topElement);
        //swap the queues to reinsated orginal state so that elenments can be pushed to q1 again
        swapQueues();
        return topElement;
    }

    private void swapQueues() {
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }

    public boolean empty() {
           return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.top()); // Output: 2
        System.out.println(stack.empty()); // Output: false
    }
}
