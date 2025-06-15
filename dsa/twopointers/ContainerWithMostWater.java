package twopointers;

public class ContainerWithMostWater {
  public static void main(String[] args) {
    int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
    int maxArea = containerWithMaxAreaOptimal(heights);
    System.out.println(maxArea);
  }

  private static int containerWithMaxAreaOptimal(int[] heights) {
    int maxArea = 0;
    int left = 0;
    int right = heights.length - 1;
    while (left < right) {
      // width
      int w = right - left;
      // height
      int h = Math.min(heights[left], heights[right]);
      int area = w * h;
      maxArea = Math.max(maxArea, area);

      if (heights[left] < heights[right])
        left++;
      else
        right--;
    }
    return maxArea;
  }

  private static int containerWithMaxAreaBrute(int[] heights) {
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      for (int j = i + 1; j < heights.length; j++) {
        // width
        int w = j - i;
        // heights
        int h = Math.min(heights[i], heights[j]);
        int area = w * h;
        maxArea = Math.max(maxArea, area);
      }
    }
    return maxArea;
  }
}
