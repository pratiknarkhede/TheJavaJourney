package com.pratik.thejavajourney.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.pratik.thejavajourney.dsa.graphs.GraphUtil.convertToAdjacencyList;
import static com.pratik.thejavajourney.dsa.graphs.GraphUtil.printGraph;

public class BFS {
    public static void main(String[] args) {
        int[][] adj = {{0, 2}, {0, 3}, {0, 1}, {2, 4}};
        /*we converted the 2d input array into adjacency array */
        ArrayList<ArrayList<Integer>> adjList = convertToAdjacencyList(adj);
        printGraph(adjList);
        BFS bfs = new BFS();
        ArrayList<Integer> bfsTraversal = bfs.bfsOfGraph(0, adjList);
        System.out.println(bfsTraversal);
    }


    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        /*we will maintain a list of traversed elements*/
        ArrayList<Integer> traversedList = new ArrayList<>();
        /*maintain the array of visited elements*/
        boolean[] visited = new boolean[v];
        /*maintain a queue to store neighbours of the node being visited
        * so that instead going in depth we will dequeue element from the queue and find its neighbours
        * */
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=true;
        while (!q.isEmpty()) {
            Integer qTop = q.poll();
            traversedList.add(qTop);
            ArrayList<Integer> neighbourList = adj.get(qTop);
            /*for each neighbour of vertex if it is not visited ,visit it and add to the queue*/
            for (int vertex : neighbourList) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    q.add(vertex);
                }
            }
        }
        return traversedList;
    }

}
