package dynamicprogramming1D;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String s = "babad";
    System.out.println(longestPalindromicSubstringOptimal(s)); // Output: "bab" or "aba"
  }

  private static String longestPalindromicSubstringOptimal(String s) {
    int n = s.length();
    if (n < 2)
      return s;

    boolean[][] dp = new boolean[n][n];

    int maxLen = 1;
    int start = 0;

    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        start = i;
        maxLen = 2;
      }
    }

    for (int length = 3; length <= n; length++) {
      for (int i = 0; i <= n - length; i++) {
        int j = i + length - 1;
        if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
          dp[i][j] = true;
          if (length > maxLen) {
            start = i;
            maxLen = length;
          }
        }
      }

    }
    return s.substring(start, start + maxLen);
  }

  private static String longestPalindromicSubstringBrute(String s) {
    if (s == null || s.length() < 1)
      return "";

    int maxLength = 1;
    int start = 0;

    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPalindromeBrute(s, i, j) && maxLength < (j - i + 1)) {
          start = i;
          maxLength = j - i + 1;
        }
      }
    }
    return s.substring(start, start + maxLength);
  }

  private static boolean isPalindromeBrute(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right))
        return false;
      left++;
      right--;
    }
    return true;
  }
}
