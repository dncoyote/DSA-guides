package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

  public static void main(String[] args) {
    int[][] heights = {
        { 1, 2, 2, 3, 5 },
        { 3, 2, 3, 4, 4 },
        { 2, 4, 5, 3, 1 },
        { 6, 7, 1, 4, 5 },
        { 5, 1, 1, 2, 4 }
    };
    List<List<Integer>> results = pacificAtlanticFlow(heights);
    System.out.println(results);
  }

  private static List<List<Integer>> pacificAtlanticFlow(int[][] heights) {
    int rows = heights.length;
    int cols = heights[0].length;
    List<List<Integer>> results = new ArrayList<>();

    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
      dfs(heights, i, cols - 1, atlantic, Integer.MIN_VALUE);
    }
    for (int j = 0; j < cols; j++) {
      dfs(heights, 0, j, pacific, Integer.MIN_VALUE);
      dfs(heights, rows - 1, j, atlantic, Integer.MIN_VALUE);
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (atlantic[row][col] && pacific[row][col]) {
          results.add(Arrays.asList(row, col));
        }
      }
    }
    return results;
  }

  private static void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
    if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col]
        || heights[row][col] < prevHeight) {
      return;
    }
    visited[row][col] = true;
    dfs(heights, row + 1, col, visited, heights[row][col]);
    dfs(heights, row - 1, col, visited, heights[row][col]);
    dfs(heights, row, col + 1, visited, heights[row][col]);
    dfs(heights, row, col - 1, visited, heights[row][col]);
  }
}
