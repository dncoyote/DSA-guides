package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  public static void main(String[] args) {
    int[] nums = { 2, 3, 5 };
    int target = 8;
    // System.out.println(combinationSumBrute(nums, target));
    System.out.println(combinationSumOptimal(nums, target));
  }

  private static List<List<Integer>> combinationSumOptimal(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, target, new ArrayList<>(), result, 0);
    return result;
  }

  private static void backtrack(int[] nums, int target, List<Integer> current, List<List<Integer>> result, int start) {
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
