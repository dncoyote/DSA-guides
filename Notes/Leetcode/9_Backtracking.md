# **Backtracking**

## **Combination Sum**
>
#### Brute - 
>Time Complexity - 

>Space Complexity - 
```java

```
#### Explanation

-

#### Steps

-

#### Optimal -
>Time Complexity - 

>Space Complexity - 

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
                continue;
            current.add(num);
            backtrack(nums, target - num, current, result, i);
            current.remove(current.size() - 1);
        }
    }
}
```
#### Explanation

-

#### Steps

-

#### Follow up 

-

## **Word Search**
>

#### Optimal -
>Time Complexity - 

>Space Complexity - 

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
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int row, int col, int i) {
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
#### Explanation

-

#### Steps

-

#### Follow up 

-