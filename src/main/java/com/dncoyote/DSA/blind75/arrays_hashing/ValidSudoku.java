package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        boolean result = validSudoku(board);
        System.out.println(result);
    }

    private static boolean validSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                // Ignore empty cells
                if (num == '.')
                    continue;

                // Calculate box index
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Invalid if duplicate found
                if (rows[r].contains(num) || cols[r].contains(num) || boxes[boxIndex].contains(num)) {
                    return false;
                }
                rows[r].add(num);
                cols[r].add(num);
                boxes[boxIndex].add(num);
            }
        }
        return true;
    }
}
