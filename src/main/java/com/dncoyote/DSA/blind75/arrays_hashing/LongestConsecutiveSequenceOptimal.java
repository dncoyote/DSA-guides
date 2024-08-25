package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceOptimal {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        System.out.println("--");
        for (Integer n : numSet) {
            System.out.println(n);
        }
        System.out.println("--");
        int longestStreak = 0;
        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int currentStreak = 1;
                int currentNumber = n;
                while (numSet.contains(currentNumber + 1)) {
                    currentStreak = currentStreak + 1;
                    currentNumber = currentNumber + 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
