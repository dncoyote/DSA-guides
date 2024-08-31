package com.dncoyote.DSA.blind75.stack;

import java.util.Stack;

public class ValidParenthesesOptimal {
    public static void main(String[] args) {
        String s = "[{()[]}{([])}]()]";
        System.out.println(validParentheses(s));
    }

    private static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
