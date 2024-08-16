package com.dncoyote.DSA.blind75.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElementsBrute {
    public static void main(String[] args) {
        int[] nums = { 5, 5, 5, 4, 4, 3 };
        int k = 2;
        int[] result = topKElements(nums, k);
        for (int n : result) {
            System.out.println(n);
        }
    }

    private static int[] topKElements(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        frequencyMap.forEach((key, value) -> System.out.println(key + " - " + value));
        System.out.println(frequencyMap.entrySet());

        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedList.get(i).getKey();
        }
        return result;
    }
}
