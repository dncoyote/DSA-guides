package arrayshashing;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    int[] result = productofArrayExceptSelfOptimal(nums);
    for (int n : result) {
      System.out.println(n);
    }
  }

  private static int[] productofArrayExceptSelfOptimal(int[] nums) {
    int[] output = new int[nums.length];
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      output[i] = prefix;
      prefix *= nums[i];
    }
    int suffix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      output[i] *= suffix;
      suffix *= nums[i];
    }
    return output;
  }

  private static int[] productofArrayExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int product = 1;
      for (int j = 0; j < nums.length; j++) {
        if (i != j) {
          product *= nums[j];
        }
      }
      result[i] = product;
    }
    return result;
  }
}
