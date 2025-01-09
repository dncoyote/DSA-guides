package com.dncoyote.DSA.blind75.binary_search;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = { 1, 3 };
        int[] num2 = { 2 };

        double median = medianOfTwoSortedArraysOptimal(num1, num2);
        System.out.println(median);
    }

    private static double medianOfTwoSortedArraysOptimal(int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            return medianOfTwoSortedArraysOptimal(num2, num1);
        }

        int m = num1.length;
        int n = num2.length;

        // Binary search on the smaller array nums1
        int low = 0;
        int high = m;

        while (low <= high) {
            // Partition nums1 and nums2
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            // Find the max of the left partition and min of the right partition
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : num1[i - 1]; // If left partition of nums1 is empty, use
                                                                           // MIN_VALUE
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : num1[i]; // If right partition of nums1 is empty, use
                                                                        // MAX_VALUE
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : num2[j - 1]; // If left partition of nums2 is empty, use
                                                                           // MIN_VALUE
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : num2[j]; // If right partition of nums2 is empty, use
                                                                        // MAX_VALUE

            // Check if the partitions are valid
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // even
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))
                            / 2.0;
                    // odd
                } else {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            }
            // If nums1LeftMax > nums2RightMin, move partition i to the left
            if (nums1LeftMax > nums2RightMin) {
                high = i - 1;
            }
            // If nums2LeftMax > nums1RightMin, move partition i to the right
            else {
                low = i + 1;
            }
        }
        return -1;
    }

    private static double medianOfTwoSortedArraysBrute(int[] num1, int[] num2) {
        int[] merged = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        // two pointer approach to sort and merge values
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                merged[k] = num1[i];
                k++;
                i++;
            } else {
                merged[k] = num2[j];
                k++;
                j++;
            }
        }

        // if there are any elements left in nums1, they are added to the merged array.
        while (i < num1.length) {
            merged[k] = num1[i];
            k++;
            i++;
        }

        // if there are any elements left in nums2, they are added to the merged array.
        while (j < num2.length) {
            merged[k] = num2[j];
            k++;
            j++;
        }

        int n = merged.length;
        if (n % 2 == 0) {
            return (double) (merged[n / 2] + merged[(n / 2) - 1]) / 2; // even
        } else {
            return merged[n / 2]; // odd
        }
    }

}
