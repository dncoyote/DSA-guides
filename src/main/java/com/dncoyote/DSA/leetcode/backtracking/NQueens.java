package com.dncoyote.DSA.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens{
    public static void main(String[] args) {
        int n =4;
        List<List<String>> solutions = solveNQueens(n);

        System.out.println(n);
        
    }

   public static List<List<String>> solveNQueens(int n){
List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Start backtracking from row 0
        //backtrack(0, board, result, n);
        return result;
}
}
