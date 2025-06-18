package stack;

import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    String s = "[{()[]}{([])}()]";
    System.out.println(validParenthesesOptimal(s));
  }

  private static boolean validParenthesesOptimal(String s) {
    if (s == null || s.length() % 2 != 0)
      return false;

    Stack<Character> stack = new Stack<>();

    for (Character c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  private static boolean validParenthesesBrute(String s) {
    if (s == null || s.length() % 2 != 0)
      return false;

    String previous = "";
    while (!s.equals(previous)) {
      previous = s;
      s = s.replace("()", "").replace("[]", "").replace("{}", "");
    }
    return s.isEmpty();
  }

}
