package Algorithm.LeetCode.week05;

import java.util.HashMap;
import java.util.Map;

public class Equal_Row_and_Column_Pairs {

  public static void main(String[] args) {
    int[][] grid = {
        {3, 2, 1},
        {1, 7, 6},
        {2, 7, 7}
    };
    System.out.println(equalPairs(grid)); // 출력: 1
  }

  public static int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<String, Integer> rowMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < n; j++) {
        sb.append(grid[i][j]).append(',');
      }
      String rowStr = sb.toString();
      rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
    }

    int count = 0;
    for (int j = 0; j < n; j++) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
        sb.append(grid[i][j]).append(',');
      }
      String colStr = sb.toString();
      count += rowMap.getOrDefault(colStr, 0);
    }

    return count;
  }
}
