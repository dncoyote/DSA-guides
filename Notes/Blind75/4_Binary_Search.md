# **Binary Search**
## **Theory**
> If the question is regarding a sorted array and search is involved, binary search is mostly the answer.
## **Binary Search - Iterative**
>Time Complexity - 

>Space Complexity - 
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
                high = mid + 1;
        }
        return -1;
    }
}
```
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