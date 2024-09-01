package com.dncoyote.DSA.blind75.binary_search;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 17;
        System.out.println(search(arr, target));
    }

    private static int search(int[] arr, int target) {
        return binarySearch(0, arr.length - 1, arr, target);
    }

    private static int binarySearch(int low, int high, int[] arr, int target) {
        if (low > high)
            return -1;

        int mid = (high + low) / 2;
        if (target == arr[mid])
            return mid;
        else if (target > arr[mid])
            return binarySearch(mid + 1, high, arr, target);
        return binarySearch(low, mid - 1, arr, target);
    }
}
