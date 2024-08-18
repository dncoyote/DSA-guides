package com.dncoyote.DSA.blind75.arrays_hashing;

public class ProductofArrayExceptSelfBrute {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productofArrayExceptSelf(nums);
        for (int n : result) {
            System.out.println(n);
        }
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