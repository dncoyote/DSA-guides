# **Sliding Window**
## **Theory**

## **Buy and Sell Crypto/Stock**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 100302.png" />
</div>

#### Brute - 
```java
public class BuyAndSellCrypto {
  public static void main(String[] args) {
    int[] crypto = { 10, 1, 5, 6, 7, 1 };
    int profit = buyAndSellCryptoBrute(crypto);
    System.out.println(profit);
  }

  private static int buyAndSellCryptoBrute(int[] crypto) {
    int maxProfit = 0;
    for (int i = 0; i < crypto.length; i++) {
      for (int j = i + 1; j < crypto.length; j++) {
        int profit = crypto[j] - crypto[i];
        maxProfit = Math.max(maxProfit, profit);
      }
    }
    return maxProfit;
  }
}
```
>Time Complexity - O(n<sup>2</sup>) 
 
>Space Complexity - O(1)
- Uses constant extra space.

#### Explanation

-

#### Optimal -

```java

public class BuyAndSellCrypto {
  public static void main(String[] args) {
    int[] crypto = { 10, 1, 5, 6, 7, 1 };
    int profit = buyAndSellCryptoOptimal(crypto);
    System.out.println(profit);
  }

  private static int buyAndSellCryptoOptimal(int[] crypto) {
    int maxProfit = 0;
    int left = 0;
    int right = left + 1;
    while (right < crypto.length) {
      if (crypto[left] < crypto[right]) {
        int profit = crypto[right] - crypto[left];
        maxProfit = Math.max(maxProfit, profit);
      } else {
        left = right;
      }
      right++;
    }
    return maxProfit;
  }
}
```
>Time Complexity - O(n)

>Space Complexity - O(1)

## **Longest Substring without repeating characters**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 105426.png" />
</div>

#### Brute - 
```java
public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    String s = "abcabcbb";
    int result = longestSubstringWithoutDuplicatesOptimal(s);
    System.out.println(result);
  }

  private static int longestSubstringWithoutDuplicatesBrute(String s) {
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        if (allUnique(s, i, j)) {
          maxLength = Math.max(maxLength, j - i);
        }
      }
    }
    return maxLength;
  }

  private static boolean allUnique(String s, int start, int end) {
    HashSet<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (set.contains(c)) {
        return false;
      }
      set.add(c);
    }
    return true;
  }
}
```
>Time Complexity - O(n<sup>3</sup>)

>Space Complexity - O(min(m, n)) or O(k) or O(1)
- m is alphabet size(26), n is string length.
#### Explanation

-

#### Steps

-

#### Optimal -
```java
 public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    String s = "abcabcbb";
    int result = longestSubstringWithoutDuplicatesOptimal(s);
    System.out.println(result);
  }

  private static int longestSubstringWithoutDuplicatesOptimal(String s) {
    HashSet<Character> set = new HashSet<>();
    int left = 0;
    int right = 0;
    int maxLength = 0;

    while (right < s.length()) {
      char c = s.charAt(right);
      if (!set.contains(c)) {
        set.add(c);
        right++;
        maxLength = Math.max(maxLength, right - left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
    }
    return maxLength;
  }


```
>Time Complexity - O(n)

>Space Complexity - O(min(m, n)) or O(k) or O(1)
- m is alphabet size(26), n is string length.
- k is the size of the character set (26 alphabets)

#### Steps
- `int left`, `int maxLength` all set to 0.
- `charCount` hashmap to store individual characters along with their count
- `right` pointer in for loop.
- if `currentChar` already exists in the map, then move left pointer.


## **Longest Repeating Character Replacement**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 121510.png" />
</div>

#### Brute - 
```java
public class LongestRepeatingCharacterReplacementOptimal {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println(result);
    }

    private static int longestRepeatingCharacterReplacementBrute(String s, int k) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                // Find freq count array
                int[] charCount = new int[26];
                for (int x = i; x < j; x++) {
                    charCount[s.charAt(x) - 'A']++;
                }

                // Find the most frequent character in the substring
                int maxFreq = 0;
                for (int count : charCount) {
                    maxFreq = Math.max(maxFreq, count);
                }

                // Calculate the number of replacements needed
                int windowSize = j - i + 1;
                int replacementNeeded = windowSize - maxFreq;

                if (replacementNeeded <= k) {
                    maxLength = Math.max(maxLength, windowSize);
                }

            }
        }
        return maxLength;
    }
}
```
>Time Complexity - O(n^3)

>Space Complexity - O(k) - O(26) - O(1)
#### Explanation

-

#### Optimal 
```java
public class LongestRepeatingCharacterReplacementOptimal {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println(result);
    }

    private static int longestRepeatingCharacterReplacement(String s, int k) {
          int left = 0;
        int maxFreq = 0;
        int result = 0;
        int[] charCount = new int[26];

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount[currentChar - 'A']++;
            // Update the max frequency in the window
            maxFreq = Math.max(maxFreq, charCount[currentChar - 'A']);

            // If the current window size minus the max frequency is greater than k, shrink the window
            while ((right - left + 1) - maxFreq > k) {
                // Decrement the frequency of the character at `left`
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the result with the maximum window size
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
O/P
---
5
```
>Time Complexity - O(n)

>Space Complexity - O(k) - O(26) - O(1)

#### Optimal -

```java
public class LongestRepeatingCharacterReplacementOptimal {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println(result);
    }

    private static int longestRepeatingCharacterReplacement(String s, int k) {
        int left = 0;
        int maxCount = 0; // to store the count of the most frequent character in the current window
        int maxLength = 0; // to keep track of the longest valid substring length
        HashMap<Character, Integer> charCount = new HashMap<>();// to keep track of the frequency of characters in the
                                                                // current window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(currentChar));
            // right - left + 1 gives the current window length
            // Subtracting maxCount from this gives the number of characters in the window
            // that are not the most frequent character.
            if (right - left + 1 - maxCount > k) {// Check if window is valid
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }   
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
O/P
---
5
```
>Time Complexity - O(n)

>Space Complexity - O(k) - O(26) - O(1)

#### Explanation

- `right - left + 1` this expression is used to calculate the length of the **current size of the window**.
- When you subtract `right` with `left`, you get the number of elements between them. But, since the indices are zero-based you need to add 1 to get the total number of elements in the window. 

#### Steps
- `int left`, `int maxCount`, `int maxLength` all set to 0.
- `charCount` hashmap to store individual characters along with their count
- `right` pointer in for loop.

## **Minimum Window substring**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 124451.png" />
</div>

#### Brute - 
```java
public class MinimumWindowSubstringBrute {
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        String result = minimumWindowSubstring(s, t);
        System.out.println(result);
    }

    private static String minimumWindowSubstring(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String window = s.substring(i, j + 1);
                
                if (containsAllChars(window, t)) {
                    if (window.length() < minLength) {
                        minLength = window.length();
                        minWindow = window;
                    }
                }
            }
        }
        
        return minWindow;
    }

    private static boolean containsAllChars(String window, String t) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : window.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) - 1);
                if (charCount.get(c) == 0) {
                    charCount.remove(c);
                }
            }
        }
        
        return charCount.isEmpty();
    }
}
```
>Time Complexity - 

>Space Complexity - 

#### Explanation

- revisit - Brute solution

#### Optimal -
```java
public class MinimumWindowSubstringOptimal {
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        String result = minWindow(s, t);
        System.out.println(result);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        Map<Character, Integer> targetCharCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCharCount.put(c, targetCharCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCharCount = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int required = targetCharCount.size();
        int formed = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCharCount.put(rightChar, windowCharCount.getOrDefault(rightChar, 0) + 1);

            if (targetCharCount.containsKey(rightChar) &&
                    windowCharCount.get(rightChar).intValue() == targetCharCount.get(rightChar).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Reduce the frequency of the left character
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (targetCharCount.containsKey(leftChar) &&
                        windowCharCount.get(leftChar) < targetCharCount.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
```
>Time Complexity - O(n)
- n is length of s

>Space Complexity - O(n + m) - O(1)
- n and m is length of s and t respectively.

#### Explanation

-

#### Steps

- Find char freq map of t string in `Map<Character, Integer> targetCharCount = new HashMap<>()`;
- Initialise `left = 0`, `right = 0`, `minLength = Integer.MAX_VALUE`, `start = 0`, `required = targetCharCount.size()`, `int formed = 0` and  `Map<Character, Integer> windowCharCount`.
- In right loop, add values from s string to windowCharCount. Increment formed value.
- In left loop, only accessed when `formed==required` and `left<=right`.
    - calculate `minLength` by finding current window length.
    - reduce the char count from windowCharCount.
    - reduce formed by 1
    - left++
- right++

## **Permutation in String**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 133459.png" />
</div>

#### Brute - 

```java
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(permutationsInStringOptimal(s1, s2));
    }

    private static boolean permutationsInStringBrute(String s1, String s2) {

        // Sort the characters of s1
        char[] charArrayS1 = s1.toCharArray();
        Arrays.sort(charArrayS1);
        String sortedS1 = new String(charArrayS1);

        // Iterate through every possible substring of s2 with length equal to s1
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String substring = s2.substring(i, i + s1.length());

            // Sort the current substring and compare with sorted s1
            char[] charArrayS2 = substring.toCharArray();
            Arrays.sort(charArrayS2);
            String sortedS2 = new String(charArrayS2);

            if (sortedS1.equals(sortedS2)) {
                return true;
            }
        }
        return false;
    }
}
```
>Time Complexity - O(n . m log m)
- n is length of s2 and m is length of s1

>Space Complexity - O(m)
- m is length of s1
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(permutationsInStringOptimal(s1, s2));
    }

    private static boolean permutationsInStringOptimal(String s1, String s2) {
        // Return false if s1 is longer that s2
        if (s2.length() < s1.length())
            return false;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            counts1[s1.charAt(i) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches(counts1, counts2)) {
                return true;
            }
            // Add the new character to the window
            counts2[s2.charAt(i) - 'a']++;
            // Remove the character that is no longer in the window
            counts2[s2.charAt(i - s1.length()) - 'a']--;
        }

        return matches(counts1, counts2);
    }

    private static boolean matches(int[] counts1, int[] counts2) {
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }
        return true;
    }
}
```
>Time Complexity - O(n)
- n is the length of s2

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Sliding Window Maximum**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 155757.png" />
</div>

#### Brute - 

```java
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = slidingWindowMaximumBrute(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] slidingWindowMaximumBrute(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // Iterate through all windows of size k
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }
}
```
>Time Complexity - O(n . k)

>Space Complexity - O(1)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = slidingWindowMaximumOptimal(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] slidingWindowMaximumOptimal(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.add(i);
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(k)
- k is the size of the sliding window
#### Explanation

- A **deque** (short for double-ended queue) is a data structure that allows insertion and removal of elements from both ends — front and back. It is implemented as a doubly linked list or a dynamic array in most programming languages.
- We use a deque to efficiently maintain the indices of elements in the array for each sliding window. The deque will always have the index of the maximum element for the current window at its front, which allows us to retrieve the maximum value in O(1).

#### Steps

- `if (!deque.isEmpty() && deque.peekFirst() < i - k + 1)` - Check if the index at the front of the deque is outside the current window. If yes, remove the front index with `deque.pollFirst()`.
- `while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])` - Check the elements at the back of the deque. If the current element `nums[i]` is greater than or equal to the element at those indices:
Remove the indices at the back `(deque.pollLast())`, as those elements can never be the maximum in the current or future windows.

#### Follow up 

-
