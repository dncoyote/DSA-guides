package arrayshashing;

import java.util.Arrays;

public class ValidAnagram {
  public static void main(String[] args) {
    String s = "anagram";
    String t = "snagaram";
    boolean isAnagram = validAnagramOptimal(s, t);
    if (isAnagram) {
      System.out.println("Anagram");
    } else {
      System.out.println("Not anagram");
    }
  }

  private static boolean validAnagramOptimal(String s, String t) {
    if (s.length() != t.length())
      return false;

    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }

    for (int i = 0; i < 26; i++) {
      if (count[i] != 0)
        return false;
    }
    return true;
  }

  private static boolean validAnagramBrute(String s, String t) {
    char[] a = s.toCharArray();
    char[] b = t.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    return Arrays.equals(a, b);
  }

}
