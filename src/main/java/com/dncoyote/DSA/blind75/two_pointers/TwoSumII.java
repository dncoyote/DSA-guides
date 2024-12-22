package com.dncoyote.DSA.blind75.two_pointers;

public class TwoSumII {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] res = twoSumII(nums, target);
        for (int n : res)
            System.out.println(n);
    }

    private static int[] twoSumII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            // sum is less than the target val, move pointer to the right increasing value
            if (sum < target) {
                left++;
                // sum is greater than the target val, move pointer to left decreasing value
            } else if (sum > target) {
                right--;
                // sum is equal to target
            } else {
                // Convert to 1-indexed, to return the correct index
                return new int[] { left + 1, right + 1 };
            }
        }
        return new int[0];
    }

}
