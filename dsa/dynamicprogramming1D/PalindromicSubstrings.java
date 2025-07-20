package dynamicprogramming1D;

public class PalindromicSubstrings {

  public static void main(String[] args) {
    // String str = "aaa";
    String str = "abc";
    System.out.println(palindromicSubstringOptimal(str));
  }

  private static int palindromicSubstringOptimal(String str) {
    int n = str.length();
    int count = 0;
    boolean[][] dp = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
      count++;
    }

    for (int i = 0; i < n - 1; i++) {
      if (str.charAt(i) == str.charAt(i + 1)) {
        dp[i][i + 1] = true;
        count++;
      }
    }

    for (int length = 3; length <= n; length++) {
      for (int i = 0; i <= n - length; i++) {
        int j = i + length - 1;

        if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
          dp[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }

  private static int palindromicSubstringBrute(String str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      for (int j = i; j < str.length(); j++) {
        if (isPalindromeBrute(str, i, j)) {
          count++;
        }
      }
    }
    return count;
  }

  private static boolean isPalindromeBrute(String str, int start, int end) {
    while (start < end) {
      if (str.charAt(start) != str.charAt(end))
        return false;
      start++;
      end--;
    }
    return true;
  }
}
