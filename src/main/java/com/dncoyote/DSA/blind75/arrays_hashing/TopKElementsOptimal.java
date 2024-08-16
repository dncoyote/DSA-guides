package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElementsOptimal {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 4, 4, 3 };
        int k = 2;
        int[] result = topKElements(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] topKElements(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
