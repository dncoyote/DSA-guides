package arrayshashing;

import java.util.HashSet;

public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    System.out.println(containsDuplicateBrute(nums));
  }

  private static boolean containsDuplicateOptimal(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
    }
    return false;
  }

  private static boolean containsDuplicateBrute(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  }
}
