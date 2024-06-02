package com.dncoyote.DSA.arrays_easy;

public class MoveZeroesToEndBrute {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int[] result = moveZeroes(arr);
        System.out.println("After moving zeroes");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] moveZeroes(int[] arr) {
        int[] result = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }

}
