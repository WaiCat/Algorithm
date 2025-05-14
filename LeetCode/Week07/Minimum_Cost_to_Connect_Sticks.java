package Algorithm.LeetCode.Week07;

import java.util.PriorityQueue;

public class Minimum_Cost_to_Connect_Sticks {

  public static void main(String[] args) {
    // 예제 1
    int[] sticks1 = {2, 4, 3};
    System.out.println("Output: " + connectSticks(sticks1)); // 기대 출력: 14

    // 예제 2
    int[] sticks2 = {1, 8, 3, 5};
    System.out.println("Output: " + connectSticks(sticks2)); // 기대 출력: 30

    // 예제 3
    int[] sticks3 = {5};
    System.out.println("Output: " + connectSticks(sticks3)); // 기대 출력: 0
  }

  public static int connectSticks(int[] sticks) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int stick : sticks) {
      minHeap.offer(stick);
    }

    int sum = 0;

    while (minHeap.size() > 1) {
      int min = minHeap.poll() + minHeap.poll();
      sum += min;
      minHeap.offer(min);
    }

    return sum;
  }
}
