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
> You are given an array of length `n` which was originally sorted in ascending order. It has now been rotated between 1 and `n` times. Find the Minimum value.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

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
            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[low];

    }
}
```
#### Explanation

-

#### Steps

-

## **Find Target in Rotated Sorted Array**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

- method 1
    - Linear Search - better
- method 2
    - Rotate the array back to sorted
    - binary search

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

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
                // checks if the target value lies within the range of the sorted left half
                if (target <= arr[mid] && arr[low] <= target) {
                    high = mid - 1;// Move right
                } else {
                    low = mid + 1;// Move left
                }
                // if Right half is sorted
            } else {
                // checks if the target value lies within the range of the sorted right half
                if (target >= arr[mid] && arr[high] >= target) {
                    low = mid + 1;// Move right
                } else {
                    high = mid - 1;// Move left
                }
            }
        }
        return -1;
    }
}
```
#### Explanation

-

#### Steps

-