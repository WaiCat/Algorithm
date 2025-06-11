package Algorithm.LeetCode.Week11;

import java.util.ArrayList;
import java.util.List;

public class Find_if_Path_Exists_in_Graph {

  static boolean[] visited;

  public static void main(String[] args) {
    // Example 1
    int n1 = 3;
    int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}};
    int source1 = 0, destination1 = 2;
    System.out.println(
        "Example 1 Output: " + validPath(n1, edges1, source1, destination1)); // true

    // Example 2
    int n2 = 6;
    int[][] edges2 = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
    int source2 = 0, destination2 = 5;
    System.out.println(
        "Example 2 Output: " + validPath(n2, edges2, source2, destination2)); // false
  }

  public static boolean dfs(List<List<Integer>> graph, int source, int destination) {
    if (source == destination) {
      return true;
    }
    visited[source] = true;

    for (int neighbor : graph.get(source)) {
      if (!visited[neighbor]) {
        if (dfs(graph, neighbor, destination)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean validPath(int n, int[][] edges, int source, int destination) {
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

    visited = new boolean[n];

    return dfs(graph, source, destination);
  }
}
