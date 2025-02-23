package com.dncoyote.DSA.blind75.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesI {
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

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotOcurred = false;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.offer(new int[] { row - 1, col });
                    freshOranges--;
                    rotOcurred = true;
                }

                if (row + 1 < rows && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.offer(new int[] { row + 1, col });
                    freshOranges--;
                    rotOcurred = true;
                }

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.offer(new int[] { row, col - 1 });
                    freshOranges--;
                    rotOcurred = true;
                }

                if (col + 1 < cols && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.offer(new int[] { row, col + 1 });
                    freshOranges--;
                    rotOcurred = true;
                }
            }
            if (rotOcurred) {
                minutes++;
            }
        }
        return (freshOranges == 0) ? minutes : -1;
    }
}
