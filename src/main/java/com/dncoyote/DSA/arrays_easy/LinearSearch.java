package com.dncoyote.DSA.arrays_easy;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = 4;
        int position = linearSearch(arr, n);
        if (position >= 0) {
            System.out.println("N value " + n + " exists in " + position + " place.");
        } else {
            System.out.println("N value " + n + " does not exist.");
        }

    }

    private static int linearSearch(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
