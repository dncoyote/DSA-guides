package com.dncoyote.DSA.blind75.heaps_priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianFinder {
    List<Integer> data;

    MedianFinder() {
        data = new ArrayList<>();
    }

    void add(int num) {
        data.add(num);
    }

    double findMedian() {
        Collections.sort(data);
        int n = data.size();
        if (n % 2 == 0) {
            return (data.get(n / 2) + data.get(n / 2 - 1)) / 2.0;
        } else {
            return data.get(n / 2);
        }
    }
}

public class FindMedianFromDataStreamBrute {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.add(1);
        mf.add(2);
        System.out.println(mf.findMedian());
        mf.add(3);
        System.out.println(mf.findMedian());
    }
}
