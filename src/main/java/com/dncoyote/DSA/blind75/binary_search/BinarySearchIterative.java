package com.dncoyote.DSA.blind75.binary_search;

public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 17;
        System.out.println(binarySearch(arr, target));
    }

    private static int binarySearch(int[] arr, int target) {
        int n = arr.length - 1;
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (target == arr[mid])
                return mid;
            else if (target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
