package com.dncoyote.DSA.blind75.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        System.out.println("Original Board:");
        printBoard(board);

        surroundedRegions(board);

        System.out.println("\nBoard after solving:");
        printBoard(board);
    }

    private static void surroundedRegions(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Identify all 'O's on the borders
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[] { i, 0 });
            }
            if (board[i][cols - 1] == 'O') {
                queue.offer(new int[] { i, cols - 1 });
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[] { 0, j });
            }
            if (board[rows - 1][j] == 'O') {
                queue.offer(new int[] { rows - 1, j });
            }
        }

        // Identify all 'O's connected to the borders and mark them as safe 'T'
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            if (board[row][col] == 'O') {
                board[row][col] = 'T';
            }

            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                queue.offer(new int[] { row - 1, col });
            }

            if (row + 1 < rows && board[row + 1][col] == 'O') {
                queue.offer(new int[] { row + 1, col });
            }

            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                queue.offer(new int[] { row, col - 1 });
            }

            if (col + 1 < cols && board[row][col + 1] == 'O') {
                queue.offer(new int[] { row, col + 1 });
            }
        }
        // Convert remaining 'O' to 'X' and restore 'T' to 'O'
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
