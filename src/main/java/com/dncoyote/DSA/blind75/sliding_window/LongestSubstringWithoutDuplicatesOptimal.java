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
        int maxLength = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already present, move `left` pointer
            if (charCount.containsKey(currentChar)) {
                // Move `left` to the max of its current value or the position after the last
                // occurrence
                left = Math.max(left, charCount.get(currentChar) + 1);
            }
            charCount.put(currentChar, right);
            // Calculate the maximum length of substring
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
