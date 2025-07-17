package dynamicprogramming1D;

public class HouseRobber {

  public static void main(String[] args) {
    int[] nums = { 2, 1 };
    System.out.println(robOptimal(nums)); // Output: 4(3+1)
  }

  private static int robOptimal(int[] nums) {
    if (nums.length == 0)
      return 0;
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

  private static int robBrute(int[] nums) {
    return recursionBrute(nums, 0);
  }

  private static int recursionBrute(int[] nums, int index) {
    // Base case: no houses left
    if (index >= nums.length)
      return 0;

    // Rob current house and move to house index+2
    int robCurrent = nums[index] + recursionBrute(nums, index + 2);

    // Skip current house and move to house index+1
    int skipCurrent = recursionBrute(nums, index + 1);

    return Math.max(robCurrent, skipCurrent);
  }
}
