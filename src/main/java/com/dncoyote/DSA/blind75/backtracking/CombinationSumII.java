package com.dncoyote.DSA.blind75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        // int[] nums = { 2, 3, 6, 7 };
        // int target = 7;
        int[] nums = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSumII(nums, target));
    }

    private static List<List<Integer>> combinationSumII(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, target, result, new ArrayList<>(), 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<List<Integer>> result, List<Integer> current,
            int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (i > start && num == nums[i - 1]) {
                continue;
            }
            if (target < num) {
                continue;
            }
            current.add(num);
            backtrack(nums, target - num, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
