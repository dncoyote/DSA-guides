package dynamicprogramming2D;

public class UniquePaths {

  public static void main(String[] args) {
    int m = 3, n = 7;
    int result = uniquePathsOptimal(m, n);
    System.out.println("Number of unique paths in a " + m + "x" + n + " grid: " + result);
  }

  private static int uniquePathsOptimal(int m, int n) {
    int[][] dp = new int[m][n];
    // Initialize first row to 1
    for (int j = 0; j < n; j++) {
      dp[0][j] = 1;
    }
    // Initialize first col to 1
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }

    // Fill dp table
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    // Return bottom right corner
    return dp[m - 1][n - 1];
  }

  private static int uniquePathsBrute(int m, int n) {
    return countPath(0, 0, m, n);
  }

  private static int countPath(int row, int col, int m, int n) {
    if (row >= m || col >= n)
      return 0;

    if (row == m - 1 && col == n - 1)
      return 1;

    int pathDown = countPath(row + 1, col, m, n);
    int pathRight = countPath(row, col + 1, m, n);

    return pathDown + pathRight;
  }
}
