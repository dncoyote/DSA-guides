# **Arrays**

# Introduction
## **Arrays**
- Array is a data structure that allows you to store multiple values of the same type under a single variable name.
- Arrays are used to store elements of a specific type in contiguous memory locations. 
- Each element in an array can be accessed using an index, starting from 0 for the first element to n-1.
```java
// Declaration and initialization of an array of integers
int[] numbers = {1, 2, 3, 4, 5};

// Declaration and initialization of an empty array of strings
String[] names = new String[3]; // Creates an array of size 3
names[0] = "Alice";
names[1] = "Bob";
names[2] = "Charlie";
```
---
# Easy

## **Find the largest element in Array** 
[Video](https://www.youtube.com/watch?v=37E9ckMDdTk&t=526s&ab_channel=takeUforward) | [Code](src/main/java/com/dncoyote/DSA/arrays_easy/LargestElement.java)
#### Brute
> Time Complexity - O(n log n)
- Quick Sort

#### Optimal
>Time Complexity - O(N)
```java
public class LargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int largest = findLargestElement(arr);
        System.out.println("Largest Element: " + largest);
    }

    private static int findLargestElement(int[] arr) {
        int largest = arr[0];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
```
##### Explanation
- Assume that first element is the largest, iterate through the array and find the largest.
## **Find the smallest element in Array** 

## **Find the second largest element in Array** 
[Explanation](https://www.youtube.com/watch?v=37E9ckMDdTk&t=526s&ab_channel=takeUforward)
#### Brute
> Time Complexity - O(n log n)
- Quick Sort
- Find `arr[n-2]`, check whether its equal to `arr[n-1]`(largest), if its not equal then `arr[n-2]` is second largest, if its equal then find `arr[n-3]` and repeat comparison.

#### Better
>Time Complexity - O(2N)
- Find largest
- `if`
```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int secondLargest = findSecondLargestElement(arr);
        System.out.println("Second Largest Element: " + secondLargest);
    }

    private static int findSecondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] > secondLargest && arr[j] != largest) {
                secondLargest = arr[j];
            }
        }
        return secondLargest;
    }
}
```

#### Optimal
>Time Complexity - 
```java
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        int secondLargest = findSecondLargestElement(arr);
        System.out.println("Second Largest Element: " + secondLargest);
    }

    private static int findSecondLargestElement(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && secondLargest != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
```
#### Explanation
- Consider two variables `largest` and `secondLargest` and initialize it with `Integer.MIN_VALUE`
## **Find the second smallest element in Array** 

## **Check if Array is sorted** 
[Explanation](https://www.youtube.com/watch?v=37E9ckMDdTk&t=526s&ab_channel=takeUforward)
#### Optimal
>Time Complexity - O(N)
-  `for (int i = 1; i < arr.length; i++)` No need to check for the first element.
```java
public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 1, 3, 0 };
        boolean result = isArraySorted(arr);
        System.out.println("Is Array sorted: " + result);

        int[] arr1 = { 1, 2, 3, 4, 5 };
        boolean result1 = isArraySorted(arr1);
        System.out.println("Is Array sorted: " + result1);
    }

    private static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
```
#### Explanation

-

## **Remove duplicates from a sorted array** 
#### Brute
>Time Complexity 
- use Set.

#### Optimal
>Time Complexity - O(N)

>Space Complexity - O(1)

```java
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = { 5, 9, 9, 9, 10, 10, 16 };
        int length = removingDuplicates(arr);
        System.out.println("Unique Array:");
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static int removingDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
``` 
## **Left Rotate an array by one place**
#### Optimal
>Time Complexity - O(N)

>Space Complexity - O(1)

- Move every element to its left position.
- First element will always move to the last position.

```java
public class LeftRotateArrayByOnePlace {

    public static void main(String[] args) {
        int arr[] ={1,2,3,4,5};
        int result[] = leftRotate(arr);

        System.out.println("After Rotation");
        for(int n : result){
            System.out.println(n);
        }
    }

    private static int[] leftRotate(int[] arr) {
        int temp = arr[0];
        for(int i=1; i<arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] =temp;
        return arr;
    }
}
```
## **Left Rotate an array by D places**
#### Brute
>Time Complexity - O(n+D)

>Space Complexity -
```java
```

#### Optimal
>Time Complexity - O(2n)

>Space Complexity - O(1)

- Move every element to its left position by D places.
- First D elements will always move to the last position.

```java
public class LeftRotateArrayByKPlacesOptimal {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 8;
        int result[] = leftRotateByK(arr, k);

        System.out.println("After Rotation");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] leftRotateByK(int[] arr, int k) {
        int n = arr.length;
        int temp[] = new int[k];
        k = k % n;
        // Create a temporary array to store the first K elements
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        // Shift the remaining elements of the original array to the left
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        // Copy the elements from the temporary array back to the original array
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
        return arr;
    }
}

```
## **Move zeroes to end**
#### Brute
>Time Complexity - O(N)

>Space Complexity - O(N)
```java
public class MoveZeroesToEndBrute {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int[] result = moveZeroes(arr);
        System.out.println("After moving zeroes");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] moveZeroes(int[] arr) {
        int[] result = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }
}
```

#### Optimal
>Time Complexity - O(N)

>Space Complexity - O(1)

```java
public class MoveZeroesToEndOptimal {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int[] result = moveZeroes(arr);
        System.out.println("After moving zeroes");
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] moveZeroes(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
}
```

## **Linear Seach**
#### Optimal
>Time Complexity - 

>Space Complexity - 

```java
public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = 4;
        int position = linearSearch(arr, n);
        if (position >= 0) {
            System.out.println("N value " + n + " exists in " + position + " place.");
        } else {
            System.out.println("N value " + n + " does not exist.");
        }

    }

    private static int linearSearch(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (n == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
```
## **Union of Two sorted array**
#### Brute
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Optimal
>Time Complexity - 

>Space Complexity - 

```java

```
#### Explanation

-
---
# Medium
## **Two Sum** 
#### Optimal
>Time Complexity - 

>Space Complexity - 

```java
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        int target = 6;
        int[] result = twoSum(arr, target);
        for(int n: result){
            System.out.println(n);
        }
    }

    private static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> mapVal = new HashMap<>();
        for(int i=0;i<arr.length; i++){
            int val = target-arr[i];
            if(mapVal.containsKey(val)){
                return new int[]{mapVal.get(val), i};
            }
            mapVal.put(arr[i],i);
        }
        throw new IllegalArgumentException("Does not exist.");
    }
}
```
