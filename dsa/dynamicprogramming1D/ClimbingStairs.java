package dynamicprogramming1D;

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

  private static int climbStairsBrute(int n) {
    if (n == 0)
      return 1;
    if (n < 0)
      return 0;

    return climbStairsBrute(n - 1) + climbStairsBrute(n - 2);
  }

}
