package com.dncoyote.DSA.blind75.sliding_window;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacementOptimal {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println(result);
    }

    private static int longestRepeatingCharacterReplacement(String s, int k) {
        int left = 0;
        int maxCount = 0; // to store the count of the most frequent character in the current window
        int maxLength = 0; // to keep track of the longest valid substring length
        HashMap<Character, Integer> charCount = new HashMap<>();// to keep track of the frequency of characters in the
                                                                // current window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
            maxCount = Math.max(maxCount, charCount.get(currentChar));
            // right - left + 1 gives the current window length
            // Subtracting maxCount from this gives the number of characters in the window
            // that are not the most frequent character.
            if (right - left + 1 - maxCount > k) {// Check if window is valid
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                left++;
            }   
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
