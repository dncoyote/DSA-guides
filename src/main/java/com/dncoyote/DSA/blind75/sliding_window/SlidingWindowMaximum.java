package com.dncoyote.DSA.blind75.sliding_window;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = slidingWindowMaximumOptimal(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] slidingWindowMaximumOptimal(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.add(i);
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

    private static int[] slidingWindowMaximumBrute(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // Iterate through all windows of size k
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }
}
