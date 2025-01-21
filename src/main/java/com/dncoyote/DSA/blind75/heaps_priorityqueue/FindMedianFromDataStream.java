package com.dncoyote.DSA.blind75.heaps_priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    // Stores the smaller half of the numbers, top element is largest number in the
    // half
    PriorityQueue<Integer> maxHeap;
    // Stores the larger half of the numbers, top element is smallest number in the
    // half
    PriorityQueue<Integer> minHeap;

    MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void add(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }
}

public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.add(1);
        mf.add(2);
        System.out.println(mf.findMedian());
        mf.add(3);
        System.out.println(mf.findMedian());
    }
}
