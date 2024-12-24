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

## **Min Stack**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 100735.png" />
</div>

#### Brute - 

```java
class MinStack {

    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int mini = stack.peek();

        while (!stack.isEmpty()) {
            mini = Math.min(mini, stack.peek());
            tmp.push(stack.pop());
        }
        
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }
        
        return mini;
    }
}
```
>Time Complexity - O(n) for getMin, O(1) for rest

>Space Complexity - O(n) for getMin, O(1) for rest

#### Explanation

-

#### Steps

-


#### Optimal -

```java
class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int top = mainStack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class MinimumStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
```
>Time Complexity - 
- push - O(1)
- pop - O(1)
- top - O(1)
- getMin - O(1)

>Space Complexity - O(n)
- The auxiliary `minStack` ensures we always have the minimum value up to the current point in the stack

#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Evaluate Reverse Polish Notation**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 104135.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = { "4","13","5","/","+"};
        int result = evaluateReversePolishNotation(tokens);
        System.out.println(result);
    }

    private static int evaluateReversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
```
>Time Complexity - O(n)
- n is number of tokens

>Space Complexity - O(n)
- n is number of tokens
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Generate Parentheses**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 113444.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal - Backtra

```java
public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParentheses(n);
        System.out.println(result);
    }

    private static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            System.out.println(current);
            result.add(current);
            return;
        }
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}
OP
--
[((())), (()()), (())(), ()(()), ()()()]
```
>Time Complexity - Catalan Number - 

>Space Complexity - O(n)
#### Explanation

- Even though the Stack class isn't explicitly used, the behavior of the solution is inherently stack-like.

#### Steps

-

#### Follow up 

-


## **Daily Temperatures**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 123632.png" />
</div>

#### Brute - 

```java
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperaturesBrute(temperatures);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] dailyTemperaturesBrute(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            for(int j=i+1; j<temperatures.length;j++){
                if(temperatures[i]<temperatures[j]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
```
>Time Complexity - O(n^2)

>Space Complexity - O(n)
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperaturesOptimal(temperatures);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] dailyTemperaturesOptimal(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                result[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
OP
--
1
1
4
2
1
1
0
0
```
>Time Complexity - O(n)

>Space Complexity - O(n)

#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Car Fleet**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 144630.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class CarFleet {
    public static void main(String[] args) {
        int[] position = { 10, 8, 0, 5, 3 };
        int[] speed = { 2, 4, 1, 1, 3 };
        int target = 12;
        System.out.println(carFleet(target, position, speed));
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[position.length];

        // Calculate the time for each car to reach the destination
        for (int i = 0; i < position.length; i++) {
            time[i] = (double) (target - position[i]) / speed[i];
        }

        // Sort the cars based on their positions in decreasing order
        Integer[] indices = new Integer[position.length];
        for (int i = 0; i < position.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);

        int fleets = 0;
        double lastTime = 0;
        // Process cars in order of their positions (from farthest to closest)
        for (int i : indices) {
            if (time[i] > lastTime) {
                fleets++;
                lastTime = time[i];
            }
        }
        return fleets;
    }
}
OP
--
3
```
>Time Complexity - O(n log n)

>Space Complexity - O(n)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Largest Rectangle in Histogram**
<div align="center">
  <img alt="image" src="assets/Screenshot 2024-12-24 154533.png" />
</div>

#### Brute - 

```java

```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-


#### Optimal -

```java
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int result = largestRectangleInHistogram(heights);
        System.out.println(result);
    }

    private static int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight;
            if (i == heights.length) {
                currentHeight = 0; // Treat the end of the histogram as a bar of height 0
            } else {
                currentHeight = heights[i]; // Use the height of the current bar
            }

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Height of the rectangle
                int width;
                if (stack.isEmpty()) {
                    width = i; // Rectangle extends from the beginning to current index
                } else {
                    width = i - stack.peek() - 1; // Rectangle spans between two boundaries
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area); // Update the max area
            }
            stack.push(i);
        }
        return maxArea;
    }
}
```
>Time Complexity - O(n)

>Space Complexity - O(n)
#### Explanation

-

#### Steps

-

#### Follow up 

-