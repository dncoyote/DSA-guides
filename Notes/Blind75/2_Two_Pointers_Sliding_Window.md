# **Two Pointers**
## **Theory**
#### Constant Window

#### Longest sub-array/sub-string


## **Valid Palindrome**
> Given a string `s`, return `true` if it is a palindrome, otherwise return `false`.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class ValidPalindromeBrute {
    public static void main(String[] args) {
        String string = "Was it a car or a cat I saw?";
        System.out.println(validPalindrome(string));
    }

    private static boolean validPalindrome(String string) {
        String cleanString = string.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder stringBuilder = new StringBuilder(cleanString);
        String reverseString = stringBuilder.reverse().toString();
        return cleanString.equals(reverseString);
    }
}
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
public class ValidPalindromeOptimal {
    public static void main(String[] args) {
        String string = "Was it a car or a cat I saw?";
        System.out.println(validPalindrome(string));
    }

    private static boolean validPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(string.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(string.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```
#### Explanation

-

## **Three Sum**
> Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` where `nums[i] + nums[j] + nums[k] == 0`, and the indices `i`, `j` and `k` are all distinct.
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java
public class ThreeSumBrute {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
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
public class ThreeSumOptimal {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
        System.out.println(nums.length - 2);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // Skip duplicates

            //Set pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1])
                        left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right + 1])
                        right--; // Skip duplicates
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
```
#### Explanation

-

## **Container with most water**
> You are given an integer array `heights` where `heights[i]` represents the height of the `i`'th
  bar. You may choose any two bars to form a container. Return the maximum amount of water a container can store.
  Input: height = [1,7,2,5,4,7,3,6]
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
public class ContainerWithMostWaterOptimal {
    public static void main(String[] args) {
        int[] heights = { 1, 7, 2, 5, 4, 7, 3, 6 };
        int maxArea = containerWithMaxArea(heights);
        System.out.println(maxArea);
    }

    private static int containerWithMaxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right])
                    * (right - left);

            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
```
#### Explanation

-

# **Sliding Window**
## **Theory**

## **Buy and Sell Crypto/Stock**
> You are given an integer array prices where `prices[i]` is the price of NeetCoin on the `i`th day.
You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.
Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.
Input: prices = [10,1,5,6,7,1]
Output: 6

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
public class BuyAndSellCryptoOptimal {
    public static void main(String[] args) {
        int[] crypto = { 10, 1, 5, 6, 7, 1 };
        int profit = buyAndSellCrypto(crypto);
        System.out.println(profit);
    }

    private static int buyAndSellCrypto(int[] crypto) {
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;
        while (right < crypto.length) {
            if (crypto[left] < crypto[right]) {
                maxProfit = Math.max(maxProfit, crypto[right] - crypto[left]);
            } else {
                left = right;
            }
            right++;
        }
        return maxProfit;
    }
}
```
#### Explanation
- Revisit - This is not strictly a Sliding Window problem, explore better solutions.

## **Longest Repeating Character Replacement**
>You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
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
#### Explanation

- `right - left + 1` this expression is used to calculate the length of the **current size of the window**.
- When you subtract `right` with `left`, you get the number of elements between them. But, since the indices are zero-based you need to add 1 to get the total number of elements in the window. 

#### Steps
- `int left`, `int maxCount`, `int maxLength` all set to 0.
- `charCount` hashmap to store individual characters along with their count
- `right` pointer in for loop.

## **Longest Substring without duplicates**
>Given a string s, find the length of the longest substring without duplicate characters.
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
public class LongestSubstringWithoutDuplicatesOptimal {
    public static void main(String[] args) {
        String s = "zxyzxyz";
        int result = longestSubstringWithoutDuplicates(s);
        System.out.println(result);
    }

    private static int longestSubstringWithoutDuplicates(String s) {
        int left = 0;
        int maxlength = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) - 1);
                left++;
            }
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }
}
```
#### Explanation

-

#### Steps

- `int left`, `int maxLength` all set to 0.
- `charCount` hashmap to store individual characters along with their count
- `right` pointer in for loop.
- if `currentChar` already exists in the map, then move left pointer.

## **Minimum Window substring**
> Given two strings `s` and `t`, return the shortest substring of `s` such that every character in `t`, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
#### Brute - 
>Time Complexity - 

>Space Complexity - 
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
#### Explanation

- revisit - Brute solution

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

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
#### Explanation

-

#### Steps

- Find char freq map of t string in Map<Character, Integer> targetCharCount = new HashMap<>();
- Initialise left = 0, right = 0, minLength = Integer.MAX_VALUE, start = 0, required = targetCharCount.size(), int formed = 0 and  Map<Character, Integer> windowCharCount.
- In right loop, add values from s string to windowCharCount. Increment formed value.
- In left loop, only accessed when formed==required.
    - calculate minLength by finding current window length.
    - reduce the char count from windowCharCount.
    - reduce formed by 1
    - left++
- right++