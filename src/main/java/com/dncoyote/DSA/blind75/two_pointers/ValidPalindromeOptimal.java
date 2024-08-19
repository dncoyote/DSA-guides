package com.dncoyote.DSA.blind75.two_pointers;

public class ValidPalindromeOptimal {
    public static void main(String[] args) {
        String string = "Was it a car or a cat I saw?";
        System.out.println(validPalindrome(string));
    }

    private static boolean validPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        System.out.println("rightlength - " + right);

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(string.charAt(left))) {
                System.out.println("leftval before inc- " + string.charAt(left));
                left++;
                System.out.println("leftval after inc- " + string.charAt(left));

            }
            while (left < right && !Character.isLetterOrDigit(string.charAt(right))) {
                System.out.println("rightval before inc- " + string.charAt(right));
                right--;
                System.out.println("rightval before dec- " + string.charAt(right));

            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            System.out.println("chk leftval " + string.charAt(left));
            System.out.println("chk rightval " + string.charAt(right));
            left++;
            right--;
        }
        return true;
    }
}