package graphs;

public class NumberOfIslands {

  public static void main(String[] args) {
    char[][] grid = {
        { '1', '1', '0', '0', '0' },
        { '1', '1', '0', '0', '1' },
        { '0', '0', '0', '1', '1' },
        { '0', '0', '0', '0', '0' },
        { '1', '0', '1', '0', '1' }
    };
    char[][] grid1 = {
        { '0', '1', '1', '1', '0' },
        { '0', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' }
    };
    char[][] grid2 = {
        { '1', '1', '0', '0', '1' },
        { '1', '1', '0', '0', '1' },
        { '0', '0', '1', '0', '0' },
        { '0', '0', '0', '1', '1' }
    };
    char[][] grid3 = {
        { '1', '1', '1', '1', '0' },
        { '1', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' }
    };

    System.out.println("Number of islands: " + numberOfIslands(grid3));
  }

  private static int numberOfIslands(char[][] grid) {
    int numOfIslands = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == '1') {
          numOfIslands++;
          dfs(grid, row, col);
        }
      }
    }
    return numOfIslands;
  }

  private static void dfs(char[][] grid, int row, int col) {
    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') {
      return;
    }

    grid[row][col] = '0';

    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);
    
  }
}
