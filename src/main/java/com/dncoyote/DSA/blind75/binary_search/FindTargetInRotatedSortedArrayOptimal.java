package com.dncoyote.DSA.blind75.binary_search;

public class FindTargetInRotatedSortedArrayOptimal {
    public static void main(String[] args) {
        int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        int target = 1;

        System.out.println(findTargetInRotatedSortedArray(arr, target));
    }

    private static int findTargetInRotatedSortedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target)
                return mid;
            // if Left half is sorted
            if (arr[low] <= arr[mid]) {
                // checks if the target value lies within the range of the sorted left half
                if (target <= arr[mid] && arr[low] <= target) {
                    high = mid - 1;// Move right
                } else {
                    low = mid + 1;// Move left
                }
                // if Right half is sorted
            } else {
                // checks if the target value lies within the range of the sorted right half
                if (target >= arr[mid] && arr[high] >= target) {
                    low = mid + 1;// Move right
                } else {
                    high = mid - 1;// Move left
                }
            }
        }
        return -1;
    }
}