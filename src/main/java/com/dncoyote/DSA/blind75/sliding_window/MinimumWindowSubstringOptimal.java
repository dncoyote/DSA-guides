package com.dncoyote.DSA.blind75.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstringOptimal {
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        String result = minWindow(s, t);
        System.out.println(result);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";

        Map<Character, Integer> targetCharCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCharCount.put(c, targetCharCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCharCount = new HashMap<>();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int required = targetCharCount.size(); // Number of unique characters in t
        int formed = 0; // Number of unique characters with required frequency in window

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            windowCharCount.put(rightChar, windowCharCount.getOrDefault(rightChar, 0) + 1);

            if (targetCharCount.containsKey(rightChar) &&
                    windowCharCount.get(rightChar).intValue() == targetCharCount.get(rightChar).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Reduce the frequency of the left character
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (targetCharCount.containsKey(leftChar) &&
                        windowCharCount.get(leftChar) < targetCharCount.get(leftChar)) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
