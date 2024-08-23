package com.pratik.thejavajourney.collection_framework.Queue;

public class Task implements Comparable<Task>{
    String name;
    int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task otherTask) {
        return Integer.compare(this.priority,otherTask.priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
