package com.dncoyote.DSA.blind75.dynamic_programming_1D;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        // int[] nums = { 2, 3, -2, -5, 6, -1, 4 };
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(maximumProductSubarray(nums));
    }

    private static int maximumProductSubarray(int[] nums) {
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            leftProduct *= nums[i];
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            rightProduct *= nums[nums.length - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        return ans;
    }
}