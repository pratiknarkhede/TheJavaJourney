package com.pratik.thejavajourney.collection_framework.Queue;

import java.util.PriorityQueue;
/*Common Use Cases Of priority queue:
Task Scheduling:

Operating Systems: Managing processes with different priorities.
Event Handling: Processing urgent events before less critical ones.
Graph Algorithms:

Dijkstra's Algorithm: Finding the shortest path in a graph.
Prim's Algorithm: Finding the minimum spanning tree.
Simulation Systems:

Event Simulation: Scheduling future events based on their occurrence time.
Data Compression:

Huffman Coding: Building optimal prefix codes.
Merging Sorted Lists:

Efficiently merging multiple sorted lists into one.
A Search Algorithm:*

Pathfinding and graph traversal algorithms.*/

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue=new PriorityQueue<>();
        taskQueue.offer(new Task("Write report", 3));
        taskQueue.offer(new Task("Fix critical bug", 1));
        taskQueue.offer(new Task("Update documentation", 4));
        taskQueue.offer(new Task("Prepare presentation", 2));

        while(!taskQueue.isEmpty()){
            Task qElement = taskQueue.poll();
            System.out.println(qElement);
        }
    }
}
