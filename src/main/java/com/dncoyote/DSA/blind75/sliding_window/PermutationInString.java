package com.dncoyote.DSA.blind75.sliding_window;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(permutationsInStringOptimal(s1, s2));
    }

    private static boolean permutationsInStringOptimal(String s1, String s2) {
        // Return false if s1 is longer that s2
        if (s2.length() < s1.length())
            return false;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            counts1[s1.charAt(i) - 'a']++;
            counts2[s2.charAt(i) - 'a']++;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            if (matches(counts1, counts2)) {
                return true;
            }
            // Add the new character to the window
            counts2[s2.charAt(i) - 'a']++;
            // Remove the character that is no longer in the window
            counts2[s2.charAt(i - s1.length()) - 'a']--;
        }

        return matches(counts1, counts2);
    }

    private static boolean matches(int[] counts1, int[] counts2) {
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != counts2[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean permutationsInStringBrute(String s1, String s2) {

        // Sort the characters of s1
        char[] charArrayS1 = s1.toCharArray();
        Arrays.sort(charArrayS1);
        String sortedS1 = new String(charArrayS1);

        // Iterate through every possible substring of s2 with length equal to s1
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String substring = s2.substring(i, i + s1.length());

            // Sort the current substring and compare with sorted s1
            char[] charArrayS2 = substring.toCharArray();
            Arrays.sort(charArrayS2);
            String sortedS2 = new String(charArrayS2);

            if (sortedS1.equals(sortedS2)) {
                return true;
            }
        }
        return false;
    }
}
