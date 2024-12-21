# **Arrays & Hashing**

## **Contains Duplicate**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-21 095447.png" />
</div>

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

## **Group Anagrams**
>
#### Brute - 
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
public class GroupAnagramsOptimal {
    public static void main(String[] args) {
        String[] val = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result = groupAnagrams(val);
        for (List<String> s : result)
            System.out.println(s);
    }

    private static List<List<String>> groupAnagrams(String[] val) {
        HashMap<String, List<String>> result = new HashMap<>();
        for (String s : val) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append("#");
                key.append(count[i]);
            }
            String keyString = key.toString();
            if (!result.containsKey(keyString)) {
                result.put(keyString, new ArrayList<>());
            }
            result.get(keyString).add(s);

        }
        return new ArrayList<>(result.values());
    }
}
```
#### Explanation
- 

## **Top k elements in List**
>Given an integer array nums and an integer k, return the k most frequent elements within the array.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class TopKElementsBrute {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 4, 4, 3 };
        int k = 2;
        int[] result = topKElements(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] topKElements(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        frequencyMap.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println(frequencyMap.entrySet());

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedList.get(i).getKey();
        }
        return result;
    }
}
```
#### Explanation

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public class TopKElementsOptimal {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 4, 4, 3 };
        int k = 2;
        int[] result = topKElements(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] topKElements(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
```
#### Explanation

- Revisit

## **Longest Consecutive Sequence**
> Given an array of integers `nums`, return the length of the longest consecutive sequence of elements.
A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class LongestConsecutiveSequenceBrute {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        int longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentStreak = 1;
            int currentNumber = nums[i];
            while (contains(nums, currentNumber + 1)) {
                currentNumber++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

    private static boolean contains(int[] nums, int i) {
        for (int n : nums) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }
}
```
#### Explanation

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public class LongestConsecutiveSequenceOptimal {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int longestStreak = 0;
        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int currentStreak = 1;
                int currentNumber = n;
                while (numSet.contains(currentNumber + 1)) {
                    currentStreak = currentStreak + 1;
                    currentNumber = currentNumber + 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
```
#### Explanation

- Revisit

## **Product of Array except self**
> Given an integer array `nums`, return an array output where `output[i]` is the product of all the elements of `nums` except `nums[i]`.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class ProductofArrayExceptSelfBrute {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productofArrayExceptSelf(nums);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] productofArrayExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}
```
#### Explanation

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java
public class ProductofArrayExceptSelfOptimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productofArrayExceptSelf(nums);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] productofArrayExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1; // Initializing prefix product to 1
        for (int i = 0; i < n; i++) {
            output[i] = prefix; // Set the current index to the prefix product
            prefix *= nums[i]; // Update prefix to include nums[i]
        }

        int suffix = 1; // Initializing suffix product to 1
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix; // Multiply the current value in output with suffix
            suffix *= nums[i]; // Update suffix to include nums[i]
        }

        return output;
    }
}
```
#### Explanation

- Revisit

## **Encode Decode String**
> Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
#### Brute - 
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
public class EncodeDecodeStringOptimal {
    public static void main(String[] args) {
        List<String> stringList = List.of("neet", "code", "love", "you");
        String encodeString = encodeString(stringList);
        System.out.println("Encoded String: " + encodeString);
        List<String> decodeString = decodeString(encodeString);
        System.out.println("Decoded String: " + decodeString);
    }

    private static String encodeString(List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringList) {
            stringBuilder.append(string.length()).append("#").append(string);
        }
        return stringBuilder.toString();
    }

    private static List<String> decodeString(String encodedString) {
        List<String> decodedString = new ArrayList<>();

        int i = 0;
        while (i < encodedString.length()) {
            int j = encodedString.indexOf("#", i);
            System.out.println("j - " + j);
            int length = Integer.parseInt(encodedString.substring(i, j));
            System.out.println("length - " + length);
            decodedString.add(encodedString.substring(j + 1, j + 1 + length));
            System.out.println("decodedString - " + decodedString);
            i = j + 1 + length;
        }
        return decodedString;
    }
}
/**
 * O/P
 * Encoded String: 4#neet4#code4#love3#you
 * Decoded String: [neet, code, love, you]
 */
```
#### Explanation

- Revisit