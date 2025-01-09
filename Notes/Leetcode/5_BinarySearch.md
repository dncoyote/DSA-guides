# **Binary Search**
## **Theory**
> If the question is regarding a sorted array and search is involved, binary search is mostly the answer.
## **Binary Search - Iterative**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 155639.png" />
</div>

```java
public class BinarySearchIterative {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 17;
        System.out.println(binarySearch(arr, target));
    }

    private static int binarySearch(int[] arr, int target) {
        int n = arr.length - 1;
        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (target == arr[mid])
                return mid;
            else if (target > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
```
>Time Complexity - O(log n)
- The search space (range of indices) is halved at each iteration.

>Space Complexity - O(1)
#### Explanation

- Returns index of the value or -1 if value is not present.

#### Steps

-

## **Binary Search - Recursive**
>Time Complexity - 

>Space Complexity - 
```java
public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 17;
        System.out.println(search(arr, target));
    }

    private static int search(int[] arr, int target) {
        return binarySearch(0, arr.length - 1, arr, target);
    }

    private static int binarySearch(int low, int high, int[] arr, int target) {
        if (low > high)
            return -1;

        int mid = (high + low) / 2;
        if (target == arr[mid])
            return mid;
        else if (target > arr[mid])
            return binarySearch(mid + 1, high, arr, target);
        return binarySearch(low, mid - 1, arr, target);
    }
}
```
#### Explanation

- 

#### Steps

-

## **Find Minimum in Rotated Sorted Array**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-25 103307.png" />
</div>

#### Brute - 
```java
private static int findMinimumInRotatedSortedArrayBrute(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
```
>Time Complexity - O(n)

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

#### Optimal -
```java
public class FindMinimumInRotatedSortedArrayOptimal {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMinimumInRotatedSortedArray(arr));
    }

    private static int findMinimumInRotatedSortedArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            // Compare mid element with the rightmost element
            if (arr[mid] > arr[high])
            // Minimum is in the right half
                low = mid + 1;
            else
            // Minimum is in the left half
                high = mid;
        }
        return arr[low];

    }
}
```
>Time Complexity - O(log n)

>Space Complexity - O(1)

#### Explanation

- `arr[mid] > arr[high]` - If the middle element `(arr[mid])` is greater than the last element `(arr[high])`, this means the minimum element lies in the right half of the array because a rotated array ensures that the minimum element is smaller than the elements before it. So we move `low` to `mid + 1` to search the right half.
- `else` -  the minimum element could be the middle element or lies in the left half of the array because if `arr[mid]` is less than or equal to `arr[high]`, it means that `mid` is part of the smaller (or sorted) half, and the minimum could be in this half.

#### Steps

-

## **Find Target in Rotated Sorted Array**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-25 110311.png" />
</div>

#### Brute - 
 
```java
private static int findTargetInRotatedSortedArrayBrute(int[] arr, int target) {
        int index = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] == target)
                index = i;
        }
        return index;
    }
```
>Time Complexity - O(n)

>Space Complexity - O(1)
#### Explanation

- method 1
    - Linear Search - better
- method 2
    - Rotate the array back to sorted
    - binary search

#### Steps

-

#### Optimal -

```java
public class FindTargetInRotatedSortedArrayOptimal {
    public static void main(String[] args) {
        int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        int target = 1;

        System.out.println(findTargetInRotatedSortedArray(arr, target));
    }

    private static int findTargetInRotatedSortedArray(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (arr[mid] == target)
                return mid;
            // if Left half is sorted
            if (arr[low] <= arr[mid]) {
                // checks if the target value is in the range of the sorted left half
                if (target <= arr[mid] && arr[low] <= target) {
                    high = mid - 1;// narrow the search range to the left half
                } else {
                    low = mid + 1;// narrow the search range to the right half
                }
                // if Right half is sorted
            } else {
                // checks if the target value is in the range of the sorted right half
                if (target >= arr[mid] && arr[high] >= target) {
                    low = mid + 1;// narrow the search range to the right half
                } else {
                    high = mid - 1;// narrow the search range to the left half
                }
            }
        }
        return -1;
    }
}
```
>Time Complexity - O(log n)

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

## **Search a 2D Matrix**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-25 113758.png" />
</div>

#### Brute - 

```java
private static boolean search2DMatrixBrute(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int n : row) {
                if (n == target) {
                    return true;
                }
            }
        }
        return false;
    }
```
>Time Complexity - O(m * n)
- m is number of rows.
- n is number of columns

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        System.out.println(search2DMatrixOptimal(matrix, target));
    }

    private static boolean search2DMatrixOptimal(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row * col - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            int midValue = matrix[mid / col][mid % col];

            if (target == midValue) {
                return true;
            } else if (target > midValue) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
```
>Time Complexity - O(log (m * n))
- m is number of rows.
- n is number of columns
- Normal Binary Search runs with O(log n), here its O(log (m * n))

>Space Complexity - O(1)
#### Explanation 
###### Concept of Flattening a 2D Matrix
- [
  [1,  3,  5],
  [7,  9, 11],
  [13, 15, 17]
] 
- [1, 3, 5, 7, 9, 11, 13, 15, 17]

- `int midValue = matrix[mid / col][mid % col]` - A 2D matrix can be conceptually flattened into a single 1D array.
    - `row = mid / col`: Dividing the index mid by the number of columns col gives the row because every col elements correspond to a new row in the matrix.
    - `col = mid % col`: The remainder when mid is divided by col gives the column within that row. This is because the column index resets every col elements.
- if `mid = 7` for `1   3   5   7   9  11  13  15  17`. 
    - `row = mid / col` -> `7/3 = 2`
    - `col = mid % col` -> `7%3 = 1`
    - so `matrix[2][1] = 15`
- if `mid = 4` for `1   3   5   7   9  11  13  15  17`. 
    - `row = mid / col` -> `4/3 = 1`
    - `col = mid % col` -> `4%3 = 1`
    - so `matrix[1][1] = 9`

#### Steps

-

#### Follow up 

-

## **Koko Eating Bananas**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-25 160745.png" />
</div>

#### Brute - 

```java
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        int minEatingSpeed = kokoEatingBananasBrute(piles, h);
        System.out.println(minEatingSpeed);
    }

    private static int kokoEatingBananasBrute(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile); // Find the maximum pile size
        }

        // Brute force: Try every possible speed from 1 to maxPile
        for (int k = 1; k <= maxPile; k++) {
            if (canFinish(piles, h, k)) {
                return k; // Return the first valid speed
            }
        }

        return maxPile; // This will never be reached because a solution always exists
    }

    private static boolean canFinish(int[] piles, int h, int mid) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / mid);
        }
        return hours <= h;
    }
}
```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 3, 6, 7, 11 };
        int h = 8;
        int minEatingSpeed = kokoEatingBananasBrute(piles, h);
        System.out.println(minEatingSpeed);
    }

    private static int kokoEatingBananasOptimal(int[] piles, int h) {
        int low = 1; // Min. speed by which Koko can eat
        int high = Integer.MIN_VALUE;

        // Find max. speed by which Koko can eat(biggest pile)
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low < high) {
            // to avoid int overflow by exceeding int limit, if low and high are large values
            int mid = low + (high - low) / 2; 
            // this can also be used
            int mid = (high + low) / 2;
            if (canFinish(piles, h, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canFinish(int[] piles, int h, int mid) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / mid);
        }
        return hours <= h;
    }
}
```
>Time Complexity - O(n log n)

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Time Based Key-Value Store**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-01-08 224453.png" />
</div>

#### Brute - 

```java
class TimeMap {
    Map<String, List<Pair>> timeMap;

    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    TimeMap() {
        timeMap = new HashMap<>();
    }

    void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }

        List<Pair> pairs = timeMap.get(key);
        String result = "";
        int maxTimestamp = Integer.MIN_VALUE;

        for (Pair pair : pairs) {
            if (pair.timestamp <= timestamp && pair.timestamp > maxTimestamp) {
                result = pair.value;
                maxTimestamp = pair.timestamp;
            }
        }

        return result;
    }
}

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}
```
>Time Complexity - 
- set operation - O(1)
- get operation -O(m)
- n is number of (key, value, timestamp) entries.
- m is number of timestamps for the given key.

>Space Complexity - 
- set operation - O(n)
- get operation -O(1)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
class TimeMap {
    Map<String, List<Pair>> timeMap;

    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    TimeMap() {
        timeMap = new HashMap<>();
    }

    void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(new Pair(timestamp, value));
    }

    String getOptimal(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Pair> pairs = timeMap.get(key);

        int low = 0;
        int high = pairs.size() - 1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (pairs.get(mid).timestamp <= timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if(high<0){
            return "";
        }
        return pairs.get(high).value;
    }
}

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.getOptimal("foo", 1));
        System.out.println(obj.getOptimal("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.getOptimal("foo", 4));
        System.out.println(obj.getOptimal("foo", 5));
    }
}
```
>Time Complexity - 
- set operation - O(1)
- get operation -O(log m)
- n is number of (key, value, timestamp) entries.
- m is number of timestamps for the given key.

>Space Complexity - 
- set operation - O(n)
- get operation -O(1)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Median of Two Sorted Arrays**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-01-09 235005.png" />
</div>

#### Brute - 

```java
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = { 1, 2 };
        int[] num2 = { 3, 4 };

        double median = medianOfTwoSortedArraysBrute(num1, num2);
        System.out.println(median);
    }

    private static double medianOfTwoSortedArraysBrute(int[] num1, int[] num2) {
        int[] merged = new int[num1.length + num2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        // two pointer approach to sort and merge values
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                merged[k] = num1[i];
                k++;
                i++;
            } else {
                merged[k] = num2[j];
                k++;
                j++;
            }
        }

        // if there are any elements left in nums1, they are added to the merged array.
        while (i < num1.length) {
            merged[k] = num1[i];
            k++;
            i++;
        }

        // if there are any elements left in nums2, they are added to the merged array.
        while (j < num2.length) {
            merged[k] = num2[j];
            k++;
            j++;
        }

        int n = merged.length;
        if (n % 2 == 0) {
            return (double) (merged[n / 2] + merged[(n / 2) - 1]) / 2; // even
        } else {
            return merged[n / 2]; // odd
        }
    }

}
```
>Time Complexity - O(m+n)
- m is the size of num1
- n is the size of num2
>Space Complexity - O(m+n)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] num1 = { 1, 3 };
        int[] num2 = { 2 };

        double median = medianOfTwoSortedArraysOptimal(num1, num2);
        System.out.println(median);
    }

    private static double medianOfTwoSortedArraysOptimal(int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            return medianOfTwoSortedArraysOptimal(num2, num1);
        }

        int m = num1.length;
        int n = num2.length;

        // Binary search on the smaller array nums1
        int low = 0;
        int high = m;

        while (low <= high) {
            // Partition nums1 and nums2
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            // Find the max of the left partition and min of the right partition
            int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : num1[i - 1]; 
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : num1[i];
            int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : num2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : num2[j];

            // Check if the partitions are valid
            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
                // even
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))
                            / 2.0;
                    // odd
                } else {
                    return Math.max(nums1LeftMax, nums2LeftMax);
                }
            }
            // If nums1LeftMax > nums2RightMin, move partition i to the left
            if (nums1LeftMax > nums2RightMin) {
                high = i - 1;
            }
            // If nums2LeftMax > nums1RightMin, move partition i to the right
            else {
                low = i + 1;
            }
        }
        return -1;
    }
}
```
>Time Complexity - O(log(min(m,n)))
- because we are performing binary search on the smaller array.
- m is the size of num1
- n is the size of num2
>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

#### Follow up 

-