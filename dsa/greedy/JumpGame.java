package greedy;

public class JumpGame {
  public static void main(String[] args) {
    int[] nums = { 2, 3, 1, 1, 4 };
    System.out.println("Can jump to last index? " + jumpGameOptimal(nums));
  }

  private static boolean jumpGameOptimal(int[] nums) {
    int furthestReach = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > furthestReach) {
        return false;
      }
      furthestReach = Math.max(furthestReach, i + nums[i]);
      if (furthestReach >= nums.length - 1) {
        return true;
      }
    }
    return false;
  }

  private static boolean jumpGameBrute(int[] nums) {
    return jumpBrute(0, nums);
  }

  private static boolean jumpBrute(int position, int[] nums) {
    if (position == nums.length - 1) {
      return true;
    }
    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      if (jumpBrute(nextPosition, nums)) {
        return true;
      }
    }
    return false;
  }
}
