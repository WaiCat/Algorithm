package Algorithm.LeetCode.Week07;

import java.util.Collections;
import java.util.PriorityQueue;

public class Remove_Stones_to_Minimize_the_Total {

  public static void main(String[] args) {
    int[] piles1 = {5, 4, 9};
    int k1 = 2;
    System.out.println("Output: " + minStoneSum(piles1, k1)); // 기대 출력: 12

    int[] piles2 = {4, 3, 6, 7};
    int k2 = 3;
    System.out.println("Output: " + minStoneSum(piles2, k2)); // 기대 출력: 12
  }

  public static int minStoneSum(int[] piles, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int pile : piles) {
      maxHeap.offer(pile);
    }

    int total = 0;

    for (int i = 0; i < k; i++) {
      int pile = maxHeap.poll();
      pile -= pile / 2;
      maxHeap.offer(pile);
    }

    for (int pile : maxHeap) {
      total += pile;
    }

    return total;
  }
}
