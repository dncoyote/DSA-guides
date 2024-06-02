package com.dncoyote.DSA.arrays_easy;

public class MoveZeroesToEndOptimal {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int[] result = moveZeroes(arr);
        System.out.println("After moving zeroes");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
}
