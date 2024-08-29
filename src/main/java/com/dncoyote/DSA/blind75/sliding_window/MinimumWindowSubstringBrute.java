package com.dncoyote.DSA.blind75.sliding_window;

import java.util.HashMap;

public class MinimumWindowSubstringBrute {
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        String result = minimumWindowSubstring(s, t);
        System.out.println(result);
    }

    private static String minimumWindowSubstring(String s, String t) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        String result = new String();
        for (int i = 0; i < t.length(); i++) {
            char currChar = t.charAt(i);
            charCount.put(currChar, charCount.getOrDefault(currChar, 0) + 1);
        }
        int count = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            if (charCount.containsKey(currChar)) {
                int frequency = charCount.get(currChar);
                charCount.put(currChar, frequency - 1);
                if (frequency > 0)
                    count++;
            }
            if (charCount.size() == count) {
                result = s.substring(left, right);
            }
        }
        return result;

    }
}
