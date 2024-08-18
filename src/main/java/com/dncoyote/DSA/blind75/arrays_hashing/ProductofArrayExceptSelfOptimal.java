package com.dncoyote.DSA.blind75.arrays_hashing;

public class ProductofArrayExceptSelfOptimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productofArrayExceptSelf(nums);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] productofArrayExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int prefix = 1; // Initializing prefix product to 1
        for (int i = 0; i < n; i++) {
            output[i] = prefix; // Set the current index to the prefix product
            prefix *= nums[i]; // Update prefix to include nums[i]
        }

        int suffix = 1; // Initializing suffix product to 1
        for (int i = n - 1; i >= 0; i--) {
            output[i] *= suffix; // Multiply the current value in output with suffix
            suffix *= nums[i]; // Update suffix to include nums[i]
        }

        return output;
    }
}
