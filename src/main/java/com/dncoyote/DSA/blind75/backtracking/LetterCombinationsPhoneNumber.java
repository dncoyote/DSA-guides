package com.dncoyote.DSA.blind75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    private static String[] mappings = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        // convert the character to an integer without extra parsing
        String letters = mappings[Integer.parseInt(String.valueOf(digits.charAt(index)))];
        // String letters = mappings[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
