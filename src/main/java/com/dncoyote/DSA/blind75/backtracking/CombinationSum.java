package com.dncoyote.DSA.blind75.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;
        // List<List<Integer>> result = combinationSum(nums, target);
        // System.out.println(combinationSumBrute(nums, target));
        System.out.println(combinationSum(nums, target));
    }

    private static List<List<Integer>> combinationSumBrute(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        generateCombination(nums, target, result);
        return result;
    }

    private static void generateCombination(int[] nums, int target, List<List<Integer>> result) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum1 = nums[i];
            if (sum1 > target)
                continue;

            for (int j = 0; j < n; i++) {
                int sum2 = sum1 + nums[j];
                if (sum2 > target)
                    continue;

                for (int k = 0; k < n; k++) {
                    int sum3 = sum2 + nums[k];
                    if (sum3 > target)
                        continue;

                    if (sum3 == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }

        }
    }

    private static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void backtrack(int[] nums, int target, List<Integer> current, List<List<Integer>> result,
            int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            int num = nums[i];
            if (num > target)
                continue;
            current.add(num);
            // Recurse with reduced target
            backtrack(nums, target - num, current, result, i);
            // Undo the choice (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
