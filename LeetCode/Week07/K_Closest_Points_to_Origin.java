package Algorithm.LeetCode.Week07;

import java.util.Arrays;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin {

  public static void main(String[] args) {
    int[][] points1 = {{1, 3}, {-2, 2}};
    int k1 = 1;
    int[][] result1 = kClosest(points1, k1);
    System.out.println("Output: " + Arrays.deepToString(result1)); // 예상 출력: [[-2, 2]]

    int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
    int k2 = 2;
    int[][] result2 = kClosest(points2, k2);
    System.out.println(
        "Output: " + Arrays.deepToString(result2)); // 예상 출력: [[3, 3], [-2, 4]] 또는 [[-2, 4], [3, 3]]
  }

  public static int[][] kClosest(int[][] points, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> distance(n2) - distance(n1));

    for (int[] point : points) {
      pq.offer(point);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[][] res = new int[pq.size()][2];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll();
    }

    return res;
  }

  private static int distance(int[] point) {
    return point[0] * point[0] + point[1] * point[1];
  }
}
