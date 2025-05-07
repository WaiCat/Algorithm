package Algorithm.LeetCode.Week06;

import java.util.HashSet;
import java.util.Set;

public class Path_Crossing {

  public static void main(String[] args) {

    System.out.println(isPathCrossing("NES")); // false
    System.out.println(isPathCrossing("NESWW")); // true
  }

  public static boolean isPathCrossing(String path) {
    Set<String> visited = new HashSet<>();
    int high = 0, low = 0;
    visited.add("0,0");

    for (int i = 0; i < path.length(); i++) {
      if (path.charAt(i) == 'N') {
        high++;
      } else if (path.charAt(i) == 'S') {
        high--;
      } else if (path.charAt(i) == 'E') {
        low++;
      } else if (path.charAt(i) == 'W') {
        low--;
      }
      String point = high + "," + low;

      if (!visited.add(point)) {
        return true;
      }
    }
    return false;
  }
}
