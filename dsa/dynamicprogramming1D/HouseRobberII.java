package dynamicprogramming1D;

public class HouseRobberII {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 1 };
    int maxLoot = houseRobberBrute(nums);
    System.out.println(maxLoot);
  }

  private static int houseRobberOptimal(int[] nums) {
    if (nums.length == 1)
      return nums[0];

    int[] excludeLast = new int[nums.length - 1];
    int[] excludeFirst = new int[nums.length - 1];

    for (int i = 0; i < nums.length - 1; i++) {
      excludeLast[i] = nums[i];
      excludeFirst[i] = nums[i + 1];
    }

    int loot1 = robOptimal(excludeLast);
    int loot2 = robOptimal(excludeFirst);

    return Math.max(loot1, loot2);
  }

  private static int robOptimal(int[] nums) {
    if (nums.length == 1)
      return nums[0];

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }

  private static int houseRobberBrute(int[] nums) {
    if (nums.length == 1)
      return nums[0];
    if (nums.length == 0)
      return 0;

    int excludeLast = robBrute(nums, 0, nums.length - 2);
    int excludeFirst = robBrute(nums, 1, nums.length - 1);

    return Math.max(excludeFirst, excludeLast);
  }

  private static int robBrute(int[] nums, int start, int end) {
    if (start > end) {
      return 0;
    }

    int robCurrent = nums[start] + robBrute(nums, start + 2, end);
    int skipCurrent = robBrute(nums, start + 1, end);

    return Math.max(robCurrent, skipCurrent);
  }
}
