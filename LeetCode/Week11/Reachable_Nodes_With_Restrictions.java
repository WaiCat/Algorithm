package Algorithm.LeetCode.Week11;

import java.util.ArrayList;
import java.util.List;

public class Reachable_Nodes_With_Restrictions {

  static boolean[] visited;

  public static void main(String[] args) {
    // Example 1
    int n1 = 7;
    int[][] edges1 = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
    int[] restricted1 = {4, 5};
    System.out.println("Example 1 Output: " + reachableNodes(n1, edges1, restricted1)); // Output: 4

    // Example 2
    int n2 = 7;
    int[][] edges2 = {{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
    int[] restricted2 = {4, 2, 1};
    System.out.println("Example 2 Output: " + reachableNodes(n2, edges2, restricted2)); // Output: 3
  }

  public static int reachableNodes(int n, int[][] edges, int[] restricted) {
    visited = new boolean[n];
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (int visite : restricted) {
      visited[visite] = true;
    }

    return dfs(0, graph);
  }

  public static int dfs(int current, List<List<Integer>> edges) {
    if (visited[current]) {
      return 0;
    }
    visited[current] = true;
    int maxLen = 1;

    for (int edge : edges.get(current)) {
      if (!visited[edge]) {
        maxLen += dfs(edge, edges);
      }
    }

    return maxLen;
  }

}
