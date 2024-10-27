# **1D Dynamic Programming**
## **Theory**
### Tabulation
- Bottoms up Dynamic Programming 
### Memoization
- Top down Dynamic Programming
- We tend to store the value of sub problems in some map/table.

## **Climbing Stairs**
>

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
public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 2;
        int result = climbStairs(n);
        System.out.println(result);
    }

    private static int climbStairs(int n) {
        if (n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```
#### Explanation

-

#### Steps

-

## **House Robbers I**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

- Greedy Algorithm

#### Steps

-

#### Better - 
>Time Complexity - O(n)

>Space Complexity - O(n)
```java
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 3, 1, 4, 2, 1, 8 };
        int maxLoot = houseRobber(nums);
        System.out.println(maxLoot);
    }

    private static int houseRobber(int[] nums) {
        if (nums.length < 2)
            return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }
}
```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - O(n)

>Space Complexity - O(1)

```java

```
#### Explanation

-

#### Steps

- Using temp values

## **House Robbers II **
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Better - 
>Time Complexity - 

>Space Complexity - 
```java
public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 3, 1, 4, 2, 1, 8 };
        int maxLoot = houseRobber(nums);
        System.out.println(maxLoot);
    }

    private static int houseRobber(int[] nums) {
        int[] skipLast = new int[nums.length];
        int[] skipFirst = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i + 1];
        }
        int loot1 = helper(skipLast);
        int loot2 = helper(skipFirst);

        return Math.max(loot1, loot2);
    }

    private static int helper(int[] nums) {
        if (nums.length < 2)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

```java

```
#### Explanation

-

#### Steps

-

## **Longest Palindromic Substring**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Better - 
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
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // String str = "babad";
        String str = "abrbadaabab";
        System.out.println(longestPalindromicStubstring(str));
    }

    private static String longestPalindromicStubstring(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String lps = "";

        for (int i = 1; i < str.length(); i++) {
            int low = i;
            int high = i;

            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }

            low = i - 1;
            high = i;

            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }

        }
        return lps;
    }
}
```
#### Explanation

-

#### Steps

-

## **Palindromic Substring**
>
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
public class PalindromicSubstring {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(palindromicSubstring(str));
    }

    private static int palindromicSubstring(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count += countPalindrome(str, i, i);
            count += countPalindrome(str, i, i + 1);
        }
        return count;
    }

    private static int countPalindrome(String str, int low, int high) {
        int count = 0;
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            count++;
            low--;
            high++;
        }
        return count;
    }
}
```
#### Explanation

-

#### Steps

-

## **Coin Change**
>
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
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = { 1, 5, 6, 9 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;

        int[] minCoinsDp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoinsDp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                // helps us avoid invalid updates to minCoinsDp[i]. Without it, we might
                // incorrectly assume an unreachable amount is reachable, leading to incorrect
                // results.
                if (coin <= i && minCoinsDp[i - coin] != Integer.MAX_VALUE) {
                    minCoinsDp[i] = Math.min(minCoinsDp[i], 1 + minCoinsDp[i - coin]);
                }
            }
        }
        if (minCoinsDp[amount] == Integer.MAX_VALUE)
            return -1;

        return minCoinsDp[amount];
    }
}
```
#### Explanation

-

#### Steps

-

## **Maximum Product Sub-array**
>
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
>Time Complexity - O(n)

>Space Complexity - O(1)

```java
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, -5, 6, -1, 4 };
        System.out.println(maximumProductSubarray(nums));
    }

    private static int maximumProductSubarray(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            leftProduct *= nums[i];
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            rightProduct *= nums[nums.length - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return ans;
    }
}
```
#### Explanation

- Kadane's algorithm

#### Steps

-