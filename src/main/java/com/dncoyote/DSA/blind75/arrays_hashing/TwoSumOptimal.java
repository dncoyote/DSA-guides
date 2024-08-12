package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.HashMap;

public class TwoSumOptimal {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 3 };
        int target = 4;
        int[] result = twoSumSolution(arr, target);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] twoSumSolution(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int a = target - arr[i];
            if (map.containsKey(a)) {
                int[] result = { map.get(a), arr[i] };
                return result;
            }
            map.put(arr[i], i);

        }
        throw new IllegalArgumentException("No such value");
    }

}
