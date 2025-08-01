# **Backtracking**
- This strategy uses brute-force approach.
- Backtracking is not for optimization, Dynamic Programming is for optimization.
- State space Tree.
- The condition is called Bounding condition.

## **Subsets**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-02 115931.png" />
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
public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsetsOptimal(nums));
    }

    private static List<List<Integer>> subsetsOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetOptimal(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void generateSubsetOptimal(int[] nums, List<List<Integer>> result, List<Integer> current,
            int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsetOptimal(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
```
>Time Complexity - O(2^N)

>Space Complexity - O(2^N)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Subsets II**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-02 183417.png" />
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
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = { 4,4,4,1,4 };
        System.out.println(subsetsOptimal(nums));
    }

    private static List<List<Integer>> subsetsOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsetOptimal(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void generateSubsetOptimal(int[] nums, List<List<Integer>> result, List<Integer> current,
            int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            generateSubsetOptimal(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
```
>Time Complexity - O(2^N)

>Space Complexity - O(2^N)
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Combination Sum**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-01-27 223003.png" />
</div>

#### Brute - 

```java
public class CombinationSum {

  public static void main(String[] args) {
    int[] nums = { 2, 3, 5 };
    int target = 8;
    System.out.println(combinationSumBrute(nums, target));
  }

  private static List<List<Integer>> combinationSumBrute(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        result.add(Arrays.asList(nums[i]));
      }
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (target == nums[i] + nums[j]) {
          result.add(Arrays.asList(nums[i], nums[j]));
        }
      }
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          if (target == nums[i] + nums[j] + nums[k]) {
            result.add(Arrays.asList(nums[i], nums[j], nums[k]));
          }
        }
      }
    }
    return result;
  }
}
```
>Time Complexity - O(n<sup>3</sup>) 

>Space Complexity -  O(n<sup>3</sup>) 
 
#### Explanation

- What this does
    - Checks all single elements equal to target.
    - Checks all pairs whose sum equals target (with repeats allowed).
    - Checks all triplets similarly.
- Limitations
    - Fixed combination length — no longer combos.
    - Not efficient — grows exponentially with length.
    - May contain duplicates (e.g., [2,3] and [3,2]) — no pruning or sorting.
#### Steps

-

#### Optimal -


```java
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(nums, target));
    }

    private static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<Integer> current, List<List<Integer>> result,
            int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (num > target)
              break;
            current.add(num);
            // Recurse with reduced target
            backtrack(nums, target - num, current, result, i);
            // Undo the choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
```
>Time Complexity - O(n <sup>k</sup>) 
- Time complexity is exponential in nature, but pruning helps control the time needed.
- `k = target/min(nums)`
- `n` is number of values in `nums`.
>Space Complexity - O(k)
- due to recursive stack.
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Combination Sum II**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-02 180400.png" />
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
public class CombinationSumII {
    public static void main(String[] args) {
        // int[] nums = { 2, 3, 6, 7 };
        // int target = 7;
        int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSumII(nums, target));
    }

    private static List<List<Integer>> combinationSumII(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> current,
            int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (i > start && num == nums[i - 1]) {
                continue;
            }
            if (target < num) {
                continue;
            }
            current.add(num);
            backtrack(nums, target - num, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Permutations**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-03 231016.png" />
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
public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permutations(nums));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), visited);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtrack(nums, result, current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
```
>Time Complexity - O(n * n!)
- O(n!) permutations are generated
- Each permutation takes O(n) to process
>Space Complexity - O(n!)
- O(n!) permutations are generated
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Word Search**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-03 232136.png" />
</div>

#### Optimal -
```java
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));

    }

    private static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, int i) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
                || board[row][col] != word.charAt(i)) {
            return false;
        }

        char temp = board[row][col];
        // we cannot reuse the same cell in a single path
        board[row][col] = '#';

        boolean found =
                // down
                backtrack(board, word, row + 1, col, i + 1) ||
                // up
                        backtrack(board, word, row - 1, col, i + 1) ||
                        // right
                        backtrack(board, word, row, col + 1, i + 1) ||
                        // left
                        backtrack(board, word, row, col - 1, i + 1);

        board[row][col] = temp;

        return found;
    }
}
```
>Time Complexity - O(m x n x 4<sup>L</sup>)
- m is number of rows.
- n is number of columns.
- L is length of word.
- The algorithm potentially explores every cell on the board as a starting point:
O(m * n) where m = number of rows, n = number of columns.
- From each starting cell, in the worst case, the DFS explores up to 4 directions recursively for each character in the word.
- Best case scenario - O(m x n x L)
>Space Complexity - O(L)
- recursion stack.

#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Letter Combinations of a Phone Number**
<div align="center">
  <img alt="image" src="assets/Screenshot 2025-02-20 212257.png" />
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
public class LetterCombinationsPhoneNumber {
    private static String[] mappings = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        // convert the character to an integer with extra parsing
        // String letters = mappings[Integer.parseInt(String.valueOf(digits.charAt(index)))];
        // convert the character to an integer without extra parsing
        String letters = mappings[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
```
>Time Complexity - 

>Space Complexity - 
#### Explanation

-

#### Steps

- convert the character to an integer without extra parsing
    - mappings[digits.charAt(0) - '0'] -> mappings['2' - '0'] -> mappings[2] -> "abc"
    - '2' - '0' = 50 - 48 = 2
#### Follow up 

-
