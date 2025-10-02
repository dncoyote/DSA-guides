# Leetcode
 
 1. [Arrays & Hashing](#arrays-&-hashing)
    - Contains Duplicate
    - Valid Anagram
    - Two Sum
    - Group Anagrams
    - Top K frequent Elements
    - Encode and Decode Strings
    - Product of Array Except Self
    - Longest Consecutive Sequence

# Arrays & Hashing
## **Contains Duplicate**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 095447.png" />
</div>

#### Brute - Nested for loops
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
>Time Complexity - O(n<sup>2</sup>)
- nested for loops
>Space Complexity - O(1)
- array is used
#### Explanation

- Use nested for loops to identify if a number from first loop exists in the second loop.
- Use `i+1` in inner loop to ensure there is no comparison with same element
#### Better - Sorting
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
>Time Complexity - O(n log n)

>Space Complexity - O(1)
#### Explanation

- Sort the array using inbuilt sort function and  compare if adjacent values are equal.

#### Optimal - HashSet
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
>Time Complexity - O(n)
- due to loop

>Space Complexity - O(n)
- due to HashSet usage
#### Explanation

- Use a HashSet.


