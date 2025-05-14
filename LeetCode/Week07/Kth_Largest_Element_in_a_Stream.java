package Algorithm.LeetCode.Week07;

import java.util.PriorityQueue;

class KthLargest {

  private final PriorityQueue<Integer> minHeap;
  private final int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;

    minHeap = new PriorityQueue<>();
    for (int num : nums) {
      minHeap.add(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
  }

  public int add(int val) {
    minHeap.add(val);
    if (minHeap.size() > k) {
      minHeap.poll();
    }
    return minHeap.peek();
  }
}

public class Kth_Largest_Element_in_a_Stream {

  public static void main(String[] args) {
    // Example 1
    KthLargest kthLargest1 = new KthLargest(3, new int[]{4, 5, 8, 2});
    System.out.println(kthLargest1.add(3)); // 출력: 4
    System.out.println(kthLargest1.add(5)); // 출력: 5
    System.out.println(kthLargest1.add(10)); // 출력: 5
    System.out.println(kthLargest1.add(9)); // 출력: 8
    System.out.println(kthLargest1.add(4)); // 출력: 8

    // Example 2
    KthLargest kthLargest2 = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
    System.out.println(kthLargest2.add(2)); // 출력: 7
    System.out.println(kthLargest2.add(10)); // 출력: 7
    System.out.println(kthLargest2.add(9)); // 출력: 7
    System.out.println(kthLargest2.add(9)); // 출력: 8
  }
}
