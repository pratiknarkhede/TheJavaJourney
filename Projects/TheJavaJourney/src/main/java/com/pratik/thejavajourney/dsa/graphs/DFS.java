package com.pratik.thejavajourney.dsa.graphs;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        int[][] adj = {{2, 3, 1}, {0}, {0, 4}, {0}, {2}};
        ArrayList<ArrayList<Integer>> adjList = GraphUtil.convertToAdjacencyList(adj);
        System.out.println(adjList.size());
        DFS dfs = new DFS();
        ArrayList<Integer> dfsTraversal = dfs.dfsOfGraph(adjList);
        System.out.println(dfsTraversal);
    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        //we will maintain an array , where each index will represent node in graph
        // the array element will be containing value as boolean , True denoting the node has been visited
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> traversedList = new ArrayList<>();

        doDfsTraversal(0, adj, visited, traversedList);

        return traversedList;

    }

    private void doDfsTraversal(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> traversedList) {
        visited[node] = true;
        traversedList.add(node);
        ArrayList<Integer> neighbourList = adj.get(node);
        for (int vertex : neighbourList) {
            if (!visited[vertex])
                doDfsTraversal(vertex, adj, visited, traversedList);
        }
    }


}
