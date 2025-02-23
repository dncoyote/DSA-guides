package com.dncoyote.DSA.blind75.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };
        System.out.println("Minutes to rot all oranges: " + rottingOranges(grid));
    }

    private static int rottingOranges(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[] { row, col });
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int[] directions = { 0, 1, 0, -1, 0 };
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotOccured = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int j = 0; j < 4; j++) {
                    int newRow = row + directions[j];
                    int newCol = col + directions[j + 1];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] { newRow, newCol });
                        freshOranges--;
                        rotOccured = true;
                    }
                }
            }
            if (rotOccured) {
                minutes++;
            }

        }
        return (freshOranges == 0) ? minutes : -1;
    }
}