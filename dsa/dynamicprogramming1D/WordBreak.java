package dynamicprogramming1D;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

  public static void main(String[] args) {
    String s1 = "leetcode";
    List<String> wordDict1 = Arrays.asList("leet", "code");
    String s2 = "catsandog";
    List<String> wordDict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println(wordBreakOptimal(s1, wordDict1));// true
    System.out.println(wordBreakOptimal(s2, wordDict2));// false
  }

  private static boolean wordBreakOptimal(String s, List<String> wordDict) {
    HashSet<String> wordSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && wordSet.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[s.length()];
  }

  private static boolean wordBreakBrute(String s, List<String> wordDict) {
    if (s.length() == 0)
      return true;

    for (int i = 1; i <= s.length(); i++) {
      String prefix = s.substring(0, i);
      if (wordDict.contains(prefix) && wordBreakBrute(s.substring(i), wordDict)) {
        return true;
      }
    }
    return false;
  }
}
