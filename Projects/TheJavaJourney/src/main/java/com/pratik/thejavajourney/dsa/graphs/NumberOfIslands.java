package com.pratik.thejavajourney.dsa.graphs;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        NumberOfIslands ni = new NumberOfIslands();
        int numberOfIslands = ni.numIslands(grid);
        System.out.println(numberOfIslands);
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m - 1][n - 1];
        ArrayList<Pair> traversedList = new ArrayList<>();
        int[] countArray = new int[1];
        visited[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                countArray[0]++;
                doBfsTraversal(i, j, grid, visited, traversedList, countArray);
            }
        }
        return 0;
    }

    private void doBfsTraversal(int i, int j, int[][] grid, boolean[][] visited, ArrayList<Pair> traversedList, int[] countArray) {
        visited[i][j] = true;
        traversedList.add(new Pair(i, j));
        Queue<Pair> qu = new LinkedList<>();
        while (!qu.isEmpty()) {
            int row = qu.peek().x;
            int column = qu.peek().y;
            qu.remove();

            //traverse the neighbours
            for (int p = -1; p < 1;  p++) {
                for (int q = -1; q < 1;  q++) {
                    int nRow=row+p;
                    int nColumn=column+q;
                    if ( nRow < 0 && nColumn < 0 && grid[nRow][nColumn]==1 && !visited[nRow][nColumn]) {
                         qu.add(new Pair(nRow,nColumn));
                    }
                }
            }
        }
    }
}
