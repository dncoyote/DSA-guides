package com.dncoyote.DSA.blind75.heaps_priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(kthLargestElementInArray(nums, k));
        System.out.println(kthLargestElementInArrayBrute(nums, k));
    }

    private static int kthLargestElementInArrayBrute(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];

    }

    private static int kthLargestElementInArray(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
