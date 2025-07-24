package dynamicprogramming1D;

import java.util.Arrays;

public class CoinChange {

  public static void main(String[] args) {
    int[] coins = { 1, 2, 5 };
    int amount = 11;
    System.out.println(coinChangeBrute(coins, amount));
  }

  private static int coinChangeOptimal(int[] coins, int amount) {
    int max = amount + 1; // Sentinel value
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

  private static int coinChangeBrute(int[] coins, int amount) {
    if (amount == 0)
      return 0;
    if (amount < 0)
      return -1;

    int minCoins = Integer.MAX_VALUE;
    for (int coin : coins) {
      int result = coinChangeBrute(coins, amount - coin);
      if (result >= 0 && result < minCoins) {
        minCoins = result + 1;
      }
    }
    return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
  }
}
