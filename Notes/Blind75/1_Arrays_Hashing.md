# **Arrays & Hashing**

## **Contains Duplicate**
>Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
Input: nums = [1,2,3,1]
Output: true
#### Brute - 
>Time Complexity - O(n^2)

>Space Complexity - O(1)
```java
public class ContainsDuplicateBrute {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
#### Explanation

-

#### Better - Sorting
>Time Complexity - O(nlogn)

>Space Complexity - O(1)
```java
public class ContainsDuplicateBetter {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
```
#### Explanation

-

#### Optimal - Hashset
>Time Complexity - O(n)

>Space Complexity - O(n)

```java
public class ContainsDuplicateOptimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> newSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (newSet.contains(nums[i])) {
                return true;
            }
            newSet.add(nums[i]);
        }
        return false;
    }
}
```
#### Explanation

-
## **Two Sun**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Better - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java

```
#### Explanation

-