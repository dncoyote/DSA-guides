package com.dncoyote.DSA.blind75.heaps_priorityqueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeightOptimal(stones)); // Output: 1
    }

    private static int lastStoneWeightOptimal(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    private static int lastStoneWeightBrute(int[] stones) {
        int n = stones.length;

        while (n > 1) {
            // only the first n elements (valid stones) are considered for sorting
            Arrays.sort(stones, 0, n);
            int stone1 = stones[n - 1];
            int stone2 = stones[n - 2];

            if (stone1 == stone2) {
                n -= 2;
            } else {
                stones[n - 2] = stone1 - stone2;
                n -= 1;
            }
        }
        return n == 0 ? 0 : stones[0];
    }
}
