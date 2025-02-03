package com.dncoyote.DSA.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(subsetsOptimal(nums));
    }

    private static List<List<Integer>> subsetsOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetOptimal(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void generateSubsetOptimal(int[] nums, List<List<Integer>> result, List<Integer> current,
            int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsetOptimal(nums, result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
