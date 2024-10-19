# **1D Dynamic Programming**
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

## **House Robbers**
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