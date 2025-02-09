package com.dncoyote.DSA.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permutations(nums));
    }

    private static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), visited);
        return result;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                backtrack(nums, result, current, visited);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}
