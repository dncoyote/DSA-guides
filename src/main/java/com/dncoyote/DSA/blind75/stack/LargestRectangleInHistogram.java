package com.dncoyote.DSA.blind75.stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int result = largestRectangleInHistogram(heights);
        System.out.println(result);
    }

    private static int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight;
            if (i == heights.length) {
                currentHeight = 0; // Treat the end of the histogram as a bar of height 0
            } else {
                currentHeight = heights[i]; // Use the height of the current bar
            }

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Height of the rectangle
                int width;
                if (stack.isEmpty()) {
                    width = i; // Rectangle extends from the beginning to current index
                } else {
                    width = i - stack.peek() - 1; // Rectangle spans between two boundaries
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area); // Update the max area
            }
            stack.push(i);
        }
        return maxArea;
    }
}
