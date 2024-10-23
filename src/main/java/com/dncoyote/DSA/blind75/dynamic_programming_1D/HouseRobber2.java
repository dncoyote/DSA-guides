package com.dncoyote.DSA.blind75.dynamic_programming_1D;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 3, 1, 4, 2, 1, 8 };
        int maxLoot = houseRobber(nums);
        System.out.println(maxLoot);
    }

    private static int houseRobber(int[] nums) {
        int[] skipLast = new int[nums.length];
        int[] skipFirst = new int[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i + 1];
        }
        int loot1 = helper(skipLast);
        int loot2 = helper(skipFirst);

        return Math.max(loot1, loot2);
    }

    private static int helper(int[] nums) {
        if (nums.length < 2)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
