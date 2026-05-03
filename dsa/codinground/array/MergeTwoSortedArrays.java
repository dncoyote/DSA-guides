package codinground.array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String args[]) {
        int[] num1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] num2 = { 2, 5, 6 };
        int n = 3;
        int[] result = mergeTwoSortedArrays(num1, m, num2, n);
        System.out.println(Arrays.toString(result));
    }

    private static int[] mergeTwoSortedArrays(int[] num1, int m, int[] num2, int n) {
        int i = m - 1; // last element in nums1
        int j = n - 1; // last element in nums2
        int k = m + n - 1; // last position in nums1

        // Merge from back
        while (i >= 0 && j >= 0) {
            if (num1[i] > num2[j]) {
                num1[k] = num1[i];
                i--;
            } else {
                num1[k] = num2[j];
                j--;
            }
            k--;
        }

        // If num2 still has elements
        while (j >= 0) {
            num1[k] = num2[j];
            j--;
            k--;
        }
        return num1;
    }

}
