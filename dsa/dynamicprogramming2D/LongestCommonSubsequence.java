package dynamicprogramming2D;

public class LongestCommonSubsequence {

  public static void main(String[] args) {
    String text1 = "abcde";
    String text2 = "ace";
    int result = longestCommonSubsequenceOptimal(text1, text2);
    System.out.println("Length of Longest Common Subsequence: " + result);
  }

  private static int longestCommonSubsequenceOptimal(String text1, String text2) {
    int m = text1.length();
    int n = text2.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[m][n];
  }

  private static int longestCommonSubsequenceBrute(String text1, String text2) {
    return helperBrute(text1, text2, 0, 0);
  }

  private static int helperBrute(String text1, String text2, int i, int j) {
    // If either string is fully traversed, no more subsequence
    if (i == text1.length() || j == text2.length())
      return 0;
    // If characters match, add 1 and move both pointers
    if (text1.charAt(i) == text2.charAt(j)) {
      return 1 + helperBrute(text1, text2, i + 1, j + 1);
    } else {
      // Else, try skipping one character from either string and take max
      return Math.max(helperBrute(text1, text2, i + 1, j), helperBrute(text1, text2, i, j + 1));
    }
  }
}
