package com.pratik.thejavajourney.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphUtil {
    public static ArrayList<ArrayList<Integer>> convertToAdjacencyList(int[][] adjArray) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        if (adjArray == null) {
            return adjList; // Return empty list if input is null
        }

        for (int[] neighbors : adjArray) {
            ArrayList<Integer> neighborList = new ArrayList<>();
            for (int neighbor : neighbors) {
                neighborList.add(neighbor);
            }
            adjList.add(neighborList);
        }

        return adjList;
    }


    public static void printGraph(ArrayList<ArrayList<Integer>> adjList) {
        if (adjList == null) {
            System.out.println("Graph is null.");
            return;
        }

        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Node " + i + ": ");
            System.out.println(adjList.get(i));
        }
    }
}
