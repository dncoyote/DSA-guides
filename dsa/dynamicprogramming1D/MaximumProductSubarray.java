package dynamicprogramming1D;

public class MaximumProductSubarray {

  public static void main(String[] args) {
    int[] nums = { 2, 3, -2, 4 };
    System.out.println(maxProductOptimal(nums)); // Output: 6
  }

  private static int maxProductOptimal(int[] nums) {
    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = maxSoFar;
        maxSoFar = minSoFar;
        minSoFar = temp;
      }
      maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
      minSoFar = Math.min(nums[i], minSoFar * nums[i]);
      result = Math.max(result, maxSoFar);
    }
    return result;
  }

  private static int maxProductBrute(int[] nums) {
    int maxProduct = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int product = 1;
      for (int j = i; j < nums.length; j++) {
        product *= nums[j];
        maxProduct = Math.max(maxProduct, product);
      }
    }
    return maxProduct;
  }
}
