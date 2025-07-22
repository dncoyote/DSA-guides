package dynamicprogramming1D;

public class DecodeWays {

  public static void main(String[] args) {
    String s = "226";
    System.out.println(decodeOptimal(s)); // Output: 3
  }

  private static int decodeOptimal(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    if (s.charAt(0) != '0') {
      dp[1] = 1;
    } else {
      dp[1] = 0;
    }

    for (int i = 2; i <= n; i++) {
      int oneDigit = Integer.parseInt(s.substring(i - 1, i));
      if (oneDigit >= 1 && oneDigit <= 9) {
        dp[i] = dp[i] + dp[i - 1];
      }

      int twoDigit = Integer.parseInt(s.substring(i - 2, i));
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] = dp[i] + dp[i - 2];
      }
    }
    return dp[n];
  }

  private static int decodeBrute(String s) {
    return decodeBrute(s, 0);
  }

  private static int decodeBrute(String s, int index) {
    if (index == s.length()) {
      return 1;
    }
    // If string starts with '0', no valid decoding
    if (s.charAt(index) == '0') {
      return 0;
    }
    // Decode one digit
    int ways = decodeBrute(s, index + 1);
    // Decode two digit
    if (index + 1 < s.length()) {
      int twoDigit = Integer.parseInt(s.substring(index, index + 2));
      if (twoDigit >= 10 && twoDigit <= 26) {
        ways += decodeBrute(s, index + 2);
      }
    }
    return ways;
  }
}
