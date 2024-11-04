package com.dncoyote.DSA.blind75.dynamic_programming_1D;

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