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
-  Concept of Flattening a 2D Matrix
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
            int mid = low + (high - low) / 2;
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