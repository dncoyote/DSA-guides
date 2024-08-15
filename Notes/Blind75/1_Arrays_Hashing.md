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
## **Two Sum**
>Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
#### Brute - 
>Time Complexity - O(n^2)

>Space Complexity - 
```java
public class TwoSumBrute {

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3 };
        int target = 4;
        int[] result = twoSumSolution(arr, target);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] twoSumSolution(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum == target) {
                    return new int[] { arr[i], arr[j] };
                }
            }
        }
        throw new IllegalArgumentException("Does not exist.");
    }

}
```
#### Explanation
- Use two for loops to iterate through the given integer array.
- Find the sum of the value of the element from the first for loop and the second for loop.
- Compare the sum with the target.
- Return if true.
- Else iterate the loop.

#### Optimal - HashMap
>Time Complexity - O(n)

>Space Complexity - O(n)

```java
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3 };
        int target = 4;
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
#### Explanation
- Use a for loop to iterate through the integer array.
- Find the difference between target value and the value from the array.
- Check if that difference exists in the Hashmap.
- If it does not exist then add the value from array as key and its position as value in the hashmap.
- If it exists return the   

## **Valid Anagram**
>Given two strings s and t, return true if t is an anagram of s, and false otherwise.

#### Brute - Ordering and Sorting
>Time Complexity - O(nlogn)

>Space Complexity - O(n)
```java
public class ValidAnagramBrute {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = validAnagram(s, t);
        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not anagram");
        }
    }

    private static boolean validAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
```
#### Explanation

-

#### Optimal - 
>Time Complexity - O(n)

>Space Complexity - O(1)

```java
public class ValidAnagramOptimal {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean isAnagram = validAnagram(s, t);
        if (isAnagram) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not anagram");
        }
    }

    private static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
```
#### Explanation

-