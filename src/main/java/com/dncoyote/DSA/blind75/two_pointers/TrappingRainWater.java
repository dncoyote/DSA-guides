package com.dncoyote.DSA.blind75.two_pointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int heights[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = trap(heights);
        System.out.println(result);
    }

    private static int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int leftMax = heights[left];
        int rightMax = heights[right];

        int waterTrapped = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, heights[left]);

                waterTrapped += leftMax - heights[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, heights[right]);

                waterTrapped += rightMax - heights[right];
            }
        }
        return waterTrapped;
    }
}
