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