package com.dncoyote.DSA.blind75.binary_search;

public class FindMinimumInRotatedSortedArrayOptimal {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMinimumInRotatedSortedArray(arr));
    }

    private static int findMinimumInRotatedSortedArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[low];

    }
}