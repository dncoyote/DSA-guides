package priorityqueueheaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class MedianFinderOptimal {
  // Stores the smaller half of the numbers, top element is largest number in the
  // half
  PriorityQueue<Integer> maxHeap;
  // Stores the larger half of the numbers, top element is smallest number in the
  // half
  PriorityQueue<Integer> minHeap;

  MedianFinderOptimal() {
    maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    minHeap = new PriorityQueue<>();
  }

  void add(int num) {
    maxHeap.offer(num);
    minHeap.offer(maxHeap.poll());
    if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

  double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    } else {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
  }
}

class MedianFinderBrute {
  List<Integer> data;

  MedianFinderBrute() {
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

public class FindMedianFromDataStream {
  public static void main(String[] args) {
    MedianFinderBrute mf = new MedianFinderBrute();

    // MedianFinderOptimal mf = new MedianFinderOptimal();

    mf.add(1);
    mf.add(2);
    System.out.println(mf.findMedian());
    mf.add(3);
    System.out.println(mf.findMedian());

  }

}
