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