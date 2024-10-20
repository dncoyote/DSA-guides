package com.dncoyote.DSA.blind75.dynamic_programming_1D;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 0)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}