package Algorithm.LeetCode.Week07;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Total_Cost_to_Hire_K_Workers {

  public static void main(String[] args) {
    int[] costs1 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
    int k1 = 3;
    int candidates1 = 4;
    System.out.println("Output: " + totalCost(costs1, k1, candidates1)); // Output: 11

    int[] costs2 = {1, 2, 4, 1};
    int k2 = 3;
    int candidates2 = 3;
    System.out.println("Output: " + totalCost(costs2, k2, candidates2)); // Output: 4
  }

  public static long totalCost(int[] costs, int k, int candidates) {
    int left = candidates, right = costs.length - candidates;
    long total = 0;

    PriorityQueue<Integer> leftQ = new PriorityQueue<>();
    PriorityQueue<Integer> rightQ = new PriorityQueue<>();
    Deque<Integer> deque = new LinkedList<>();

    for (int cost : costs) {
      deque.add(cost);
    }

    for (int i = 0; i < candidates; i++) {
      if (deque.isEmpty()) {
        break;
      }
      leftQ.add(deque.removeFirst());
    }
    for (int i = 0; i < candidates; i++) {
      if (deque.isEmpty()) {
        break;
      }
      rightQ.add(deque.removeLast());
    }

    for (int i = 0; i < k; i++) {
      if (leftQ.isEmpty()) {
        total += rightQ.remove();
        continue;
      } else if (rightQ.isEmpty()) {
        total += leftQ.remove();
        continue;
      }
      if (leftQ.peek() <= rightQ.peek()) {
        total += leftQ.remove();
        if (!deque.isEmpty()) {
          leftQ.add(deque.removeFirst());
        }
      } else {
        total += rightQ.remove();
        if (!deque.isEmpty()) {
          rightQ.add(deque.removeLast());
        }
      }
    }

    return total;
  }
}
