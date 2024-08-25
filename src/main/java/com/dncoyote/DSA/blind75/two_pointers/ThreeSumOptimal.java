package com.dncoyote.DSA.blind75.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumOptimal {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array
        for (int i = 0; i < nums.length - 2; i++) {
            System.out.println("in for " + i);
            if (i > 0 && nums[i] == nums[i - 1]) {
                System.out.println("in if to skip duplicate");
                continue; // Skip duplicates
            }
            // Set pointers
            int left = i + 1;
            int right = nums.length - 1;
            System.out.println("i -" + i);
            System.out.println("l -" + left);
            System.out.println("r -" + right);

            while (left < right) {
                System.out.println("value of i -" + nums[i]);
                System.out.println("value of l-" + nums[left]);
                System.out.println("value of r-" + nums[right]);
                int sum = nums[i] + nums[left] + nums[right];
                System.out.println("sum -" + sum);
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        System.out.println("in while to skip duplicate l");
                        System.out.println("value of l-" + nums[left]);
                        System.out.println("value of l-1 -" + nums[left - 1]);
                        left++; // Skip duplicates
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        System.out.println("in while to skip duplicate r");
                        right--; // Skip duplicates
                    }

                } else if (sum < 0) {
                    System.out.println("else left ++");
                    left++;
                } else {
                    System.out.println("else right --");
                    right--;
                }
            }
        }

        return result;
    }
}