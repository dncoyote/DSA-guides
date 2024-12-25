package com.dncoyote.DSA.blind75.binary_search;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 13;
        System.out.println(search2DMatrixBrute(matrix, target));
    }

    private static boolean search2DMatrixBrute(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int n : row) {
                if (n == target) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search2DMatrixOptimal(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row * col - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            int midValue = matrix[mid / col][mid % col];

            if (target == midValue) {
                return true;
            } else if (target > midValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}