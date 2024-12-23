# **Stack**
## **Theory**
- A stack is a linear data structure that follows the Last In, First Out (LIFO) principle. This means that the last element added to the stack is the first one to be removed.
- Backtracking problems (e.g., solving mazes, undo mechanisms in text editors).
- Parsing expressions (e.g., checking balanced parentheses in a string).
- Function call management (e.g., recursive function calls are managed using the call stack).

## **Valid Parentheses**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-23 161641.png" />
</div>

#### Better - 
```java
public class ValidParenthesesBetter {
    public static void main(String[] args) {
        String s = "[{()[]}{([])}()]";
        System.out.println(validParentheses(s));
    }

    private static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                if (c == '[')
                    stack.push(']');
                else if (c == '{')
                    stack.push('}');
                else if (c == '(')
                    stack.push(')');
            } else if (c == ']' || c == '}' || c == ')') {
                if (stack.isEmpty() || stack.peek() != c) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(n)
#### Explanation

-

#### Steps

-


#### Optimal -
```java
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
```
>Time Complexity - O(n)

>Space Complexity - O(n)
#### Explanation

- Check Neetcode solution that uses a map along with the stack

#### Steps

-