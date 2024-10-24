package com.dncoyote.DSA.blind75.dynamic_programming_1D;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // String str = "babad";
        String str = "abrbadaabab";
        System.out.println(longestPalindromicStubstring(str));
    }

    private static String longestPalindromicStubstring(String str) {
        if (str.length() <= 1) {
            return str;
        }

        String lps = "";

        for (int i = 1; i < str.length(); i++) {
            int low = i;
            int high = i;

            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            String palindrome = str.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }

            low = i - 1;
            high = i;

            while (str.charAt(low) == str.charAt(high)) {
                low--;
                high++;

                if (low == -1 || high == str.length())
                    break;
            }

            palindrome = str.substring(low + 1, high);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }

        }
        return lps;
    }
}
