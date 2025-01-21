# **Heaps & Priority Queue**


## **Find Median From Data Stream**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-01-21 230314.png" />
</div>

#### Brute - 

```java
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
```
>Time Complexity - 
- add number - O(1)
- Find media - O(n log n)
- Overall for m additions and k median call - O(k n log n + m)

>Space Complexity - O(n)
#### Explanation

-

#### Steps

-

#### Optimal -

```java
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

```

>Time Complexity - 
- add number - O(log n)
- Find media - O(1)

>Space Complexity - O(n)

#### Explanation

-

#### Steps

-

#### Follow up 

-