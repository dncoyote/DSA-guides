package dynamicprogramming1D;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
    int result = LongestIncreasingSubsequenceOptimal(nums);
    System.out.println("Length of Longest Increasing Subsequence is: " + result);
  }

  private static int LongestIncreasingSubsequenceOptimal(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int maxLength = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }
    return maxLength;
  }
}
