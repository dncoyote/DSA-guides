package twopointers;

public class ValidPalindrome {
  public static void main(String[] args) {
    String string = "Was it a car or a cat I saw?";
    System.out.println(validPalindromeOptimal(string));
  }

  private static boolean validPalindromeOptimal(String string) {
    if (string == null)
      return false;

    int left = 0;
    int right = string.length() - 1;

    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(string.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(string.charAt(right))) {
        right--;
      }
      if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  private static boolean validPalindromeBrute(String string) {
    if (string == null)
      return false;

    StringBuilder sb = new StringBuilder();
    for (char c : string.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        sb.append(Character.toLowerCase(c));
      }
    }
    String cleanString = sb.toString();
    String reverseString = sb.reverse().toString();

    return cleanString.equals(reverseString);
  }

}
