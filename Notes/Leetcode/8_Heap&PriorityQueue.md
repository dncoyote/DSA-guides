# **Heaps & Priority Queue**

## **Kth Largest Element in a Stream**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-01-23 000129.png" />
</div>

#### Brute - 

```java
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
        KthLargestBrute kthLargest = new KthLargestBrute(k, nums);

        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
}
```
>Time Complexity - 
- add - O(m log m) becayse add to heap takes O(log k)
- initialization - O(n)
- Total - O((n+m)log k)
>Space Complexity - O(n)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
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

public class KthLargestElementInStream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(k, nums);

        System.out.println(kthLargest.add(3)); // Output: 4
        System.out.println(kthLargest.add(5)); // Output: 5
        System.out.println(kthLargest.add(10)); // Output: 5
        System.out.println(kthLargest.add(9)); // Output: 8
        System.out.println(kthLargest.add(4)); // Output: 8
    }
}
```
>Time Complexity - 
- add - O(n log k) becayse add to heap takes O(log k)
- initialization - O(m log k)
- Total - O((n+m)log k)

>Space Complexity - O(k)
#### Explanation

-

#### Steps

-

#### Follow up 

-

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