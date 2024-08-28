package com.dncoyote.DSA.blind75.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicatesOptimal {
    public static void main(String[] args) {
        String s = "zxyzxyz";
        int result = longestSubstringWithoutDuplicates(s);
        System.out.println(result);
    }

    private static int longestSubstringWithoutDuplicates(String s) {
        int left = 0;
        int maxlength = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) - 1);
                left++;
            }
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            maxlength = Math.max(maxlength, right - left + 1);
        }
        return maxlength;
    }
}
