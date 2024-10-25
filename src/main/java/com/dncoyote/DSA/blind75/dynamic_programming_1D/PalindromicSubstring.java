package com.dncoyote.DSA.blind75.dynamic_programming_1D;

public class PalindromicSubstring {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(palindromicSubstring(str));
    }

    private static int palindromicSubstring(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count += countPalindrome(str, i, i);
            count += countPalindrome(str, i, i + 1);
        }
        return count;
    }

    private static int countPalindrome(String str, int low, int high) {
        int count = 0;
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            count++;
            low--;
            high++;
        }
        return count;
    }
}
