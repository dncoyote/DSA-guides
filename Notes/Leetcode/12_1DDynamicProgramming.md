# **1D Dynamic Programming**
## **Theory**
### Tabulation
- Bottoms up Dynamic Programming 
### Memoization
- Top down Dynamic Programming
- We tend to store the value of sub problems in some map/table.

## **Climbing Stairs**
<div align="center">
  <img alt="image" src="assets/Untitled-9.png" />
</div>

#### Brute - Recursion 
```java
public class ClimbingStairs {
  public static void main(String[] args) {
    int n = 2;
    int result = climbStairsBrute(n);
    System.out.println(result);
  }

  private static int climbStairsBrute(int n) {
    if (n == 0)
      return 1;
    if (n < 0)
      return 0;

    return climbStairsBrute(n-1)+climbStairsBrute(n-2);
  }

}
```
>Time Complexity - O(2<sup>n</sup>) 
- Each call to `climbStairsBrute(n)` makes two recursive calls.
    - One for `n-1`.
    - One for `n-2`.
- Number of nodes (function calls) in this recursion tree is approximately 2<sup>n</sup> because each call branches into two more calls, except at base cases.
- Hence, the total number of recursive calls grows exponentially with n.
- Time complexity is exponential due to repeated calculations.
>Space Complexity - O(n)
- Recursion stack

#### Explanation

- Base cases
    - If `n == 0`: You are already at the bottom (start), so there is exactly 1 way to stand still (do nothing).
    - If `n < 0`: You have stepped beyond the bottom (invalid path), so there are 0 ways.
- Recursive step
    - For any `n > 0`, calculate:
        - `ways(n) = ways(n-1) + ways(n-2)`
        - Example: If `n` is 2, then `ways(2) = ways(1) + ways(0)` which is 1+1 = 2.
#### Steps

-

#### Optimal - Dynamic Programming(Bottoms up)
```java
public class ClimbingStairs {
  public static void main(String[] args) {
    int n = 2;
    int result = climbStairsOptimal(n);
    System.out.println(result);
  }

  private static int climbStairsOptimal(int n) {
    if (n <= 1)
      return 1;

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
```

>Time Complexity - O(n)
- single loop from 2 to n.

>Space Complexity - O(1)


#### Explanation
- If n is 4.

| Step(i)      | dp[i] calculations     | dp[i] value      |
| :---:  | :----:  |:---:           |
| 0 | Base case | 1 |
| 1 | Base case | 1 |
| 2 | dp[1]+dp[2] = 1+1 | 2 |
| 3 | dp[2]+dp[1] = 2+1 | 3 |
| 4 | dp[3]+dp[2] = 3+2 | 5 |

- Hence, there are 5 distinct ways to reach step 4.  
#### Steps

-

## **House Robbers**

<div align="center">
  <img alt="image" src="assets/Untitled-10.png" />
</div>

#### Brute - Recursion 
```java
public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(robBrute(nums)); // Output: 4(3+1)
  }

  private static int robBrute(int[] nums) {
    return recursionBrute(nums, 0);
  }

  private static int recursionBrute(int[] nums, int index) {
    // Base case: no houses left
    if (index >= nums.length)
      return 0;

    // Rob current house and move to house index+2
    int robCurrent = nums[index] + recursionBrute(nums, index + 2);

    // Skip current house and move to house index+1
    int skipCurrent = recursionBrute(nums, index + 1);

    return Math.max(robCurrent, skipCurrent);
  }
}
```

>Time Complexity - O(2<sup>n</sup>) 
- Exponential number of recursive calls.

>Space Complexity - O(n)
- Recursion stack

#### Explanation


#### Steps

-

#### Better - 
```java
public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = { 2, 1 };
    System.out.println(robOptimal(nums)); // Output: 4(3+1)
  }

  private static int robOptimal(int[] nums) {
    if (nums.length == 0)
      return 0;
    if (nums.length == 1)
      return nums[0];

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }
}
```

>Time Complexity - O(n)

>Space Complexity - O(n)
#### Explanation

- This is the formula
    - `dp[i] = max(dp[i-1], dp[i-2]+nums[i])`
- Here `dp[i]` is the maximum amount of money you can rob from house 0 to house `i` (may or may not include money from house `i`).
- Rob house `i` - `dp[i-2]+nums[i]`
    - if you rob house `i` you cannot rob house `i-1`.
    - So you rob house `i` which is `nums[i]` and the add it to the maximum you could rob up to house`[i-2]`.
- Skip house `i`
    - If skip house `i`, then your max loot is the whatever you had until `i-1`.

#### Steps

-

## **House Robbers II**
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
