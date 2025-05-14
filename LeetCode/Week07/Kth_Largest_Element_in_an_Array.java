package Algorithm.LeetCode.Week07;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {

  public static void main(String[] args) {
    // 예제 1
    int[] nums1 = {3, 2, 1, 5, 6, 4};
    int k1 = 2;
    System.out.println("Output: " + findKthLargest(nums1, k1)); // 기대 출력: 5

    // 예제 2
    int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k2 = 4;
    System.out.println("Output: " + findKthLargest(nums2, k2)); // 기대 출력: 4
  }

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums) {
      pq.add(num);
    }
    for (int i = 1; i < k; i++) {
      pq.remove();
    }
    return pq.peek();
  }
}
