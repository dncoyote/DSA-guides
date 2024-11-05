package com.dncoyote.DSA.blind75.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

    private static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(i)) {
            return false;
        }

        char temp = board[row][col];
        // we cannot reuse the same cell in a single path
        board[row][col] = '#';

        boolean found =
                // down
                backtrack(board, word, row + 1, col, i + 1) ||
                // up
                        backtrack(board, word, row - 1, col, i + 1) ||
                        // right
                        backtrack(board, word, row, col + 1, i + 1) ||
                        // left
                        backtrack(board, word, row, col - 1, i + 1);

        board[row][col] = temp;

        return found;
    }
}