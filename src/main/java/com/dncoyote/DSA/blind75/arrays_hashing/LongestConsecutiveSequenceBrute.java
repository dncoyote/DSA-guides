package com.dncoyote.DSA.blind75.arrays_hashing;

public class LongestConsecutiveSequenceBrute {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        int longestStreak = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentStreak = 1;
            int currentNumber = nums[i];
            while (contains(nums, currentNumber + 1)) {
                currentNumber++;
                currentStreak++;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

    private static boolean contains(int[] nums, int i) {
        for (int n : nums) {
            if (n == i) {
                return true;
            }
        }
        return false;
    }
}
