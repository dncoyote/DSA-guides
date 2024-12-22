package com.dncoyote.DSA.blind75.two_pointers;

public class ContainerWithMostWaterOptimal {
    public static void main(String[] args) {
        int[] heights = { 1, 7, 2, 5, 4, 7, 3, 6 };
        int maxArea = containerWithMaxArea(heights);
        System.out.println(maxArea);
    }

    private static int containerWithMaxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int area = Math.min(heights[left], heights[right])
                    * width;
            System.out.println("Area - " + area + "=" + Math.min(heights[left], heights[right]) + "*" + (right - left));

            maxArea = Math.max(maxArea, area);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
