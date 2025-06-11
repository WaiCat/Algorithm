package Algorithm.LeetCode.Week11;

public class Max_Area_of_Island {

  static boolean[][] visited;

  public static void main(String[] args) {
    // Example 1
    int[][] grid1 = {
        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
    };
    System.out.println("Example 1 Output: " + maxAreaOfIsland(grid1)); // Output: 6

    // Example 2
    int[][] grid2 = {
        {0, 0, 0, 0, 0, 0, 0, 0}
    };
    System.out.println("Example 2 Output: " + maxAreaOfIsland(grid2)); // Output: 0
  }

  public static int dfs(int[][] grid, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||
        grid[row][col] == 0 || visited[row][col]) {
      return 0;
    }

    visited[row][col] = true;
    int area = 1;

    area += dfs(grid, row - 1, col);
    area += dfs(grid, row + 1, col);
    area += dfs(grid, row, col - 1);
    area += dfs(grid, row, col + 1);

    return area;
  }

  public static int maxAreaOfIsland(int[][] grid) {
    int maxArea = 0;
    int row = grid.length;
    int col = grid[0].length;
    visited = new boolean[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          maxArea = Math.max(maxArea, dfs(grid, i, j));
        }
      }
    }

    return maxArea;
  }
}
