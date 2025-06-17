package slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    String s = "abcabcbb";
    int result = longestSubstringWithoutDuplicatesOptimal(s);
    System.out.println(result);
  }

  private static int longestSubstringWithoutDuplicatesOptimal(String s) {
    HashSet<Character> set = new HashSet<>();
    int left = 0;
    int right = 0;
    int maxLength = 0;

    while (right < s.length()) {
      char c = s.charAt(right);
      if (!set.contains(c)) {
        set.add(c);
        right++;
        maxLength = Math.max(maxLength, right - left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
    }
    return maxLength;
  }

  private static int longestSubstringWithoutDuplicatesBrute(String s) {
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        if (allUnique(s, i, j)) {
          maxLength = Math.max(maxLength, j - i);
        }
      }
    }
    return maxLength;
  }

  private static boolean allUnique(String s, int start, int end) {
    HashSet<Character> set = new HashSet<>();
    for (int i = start; i < end; i++) {
      char c = s.charAt(i);
      if (set.contains(c)) {
        return false;
      }
      set.add(c);
    }
    return true;
  }
}
