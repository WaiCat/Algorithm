package Algorithm.LeetCode.Week07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Find_K_Pairs_with_Smallest_Sums {

  public static void main(String[] args) {
    int[] nums1_1 = {1, 7, 11};
    int[] nums2_1 = {2, 4, 6};
    int k1 = 3;
    System.out.println("Output: " + kSmallestPairs(nums1_1, nums2_1, k1)); // [[1,2],[1,4],[1,6]]

    int[] nums1_2 = {1, 1, 2};
    int[] nums2_2 = {1, 2, 3};
    int k2 = 2;
    System.out.println("Output: " + kSmallestPairs(nums1_2, nums2_2, k2)); // [[1,1],[1,1]]
  }

  public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
      return result;
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
        (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
    );

    for (int i = 0; i < nums1.length && i < k; i++) {
      pq.offer(new int[]{i, 0}); // i: index in nums1, 0: start index in nums2
    }

    while (k-- > 0 && !pq.isEmpty()) {
      int[] pair = pq.poll();
      int i = pair[0], j = pair[1];
      result.add(Arrays.asList(nums1[i], nums2[j]));
      if (j + 1 < nums2.length) {
        pq.offer(new int[]{i, j + 1});
      }
    }

    return result;
  }
}
