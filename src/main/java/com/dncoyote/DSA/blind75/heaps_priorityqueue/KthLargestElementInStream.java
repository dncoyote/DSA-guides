package com.dncoyote.DSA.blind75.heaps_priorityqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> minheap;
    int k;

    KthLargest(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int num) {
        if (minheap.size() < k) {
            minheap.add(num);
        } else if (num > minheap.peek()) {
            minheap.poll();
            minheap.add(num);
        }
        return minheap.peek();
    }
}

class KthLargestBrute {
    List<Integer> list;
    int k;

    KthLargestBrute(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
    }

    public int add(int num) {
        list.add(num);
        Collections.sort(list);
        return list.get(list.size() - k);

    }
}

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 4, 5, 8, 2 };
        // KthLargest kthLargest = new KthLargest(k, nums);
        KthLargestBrute kthLargest = new KthLargestBrute(k, nums);

        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
}
