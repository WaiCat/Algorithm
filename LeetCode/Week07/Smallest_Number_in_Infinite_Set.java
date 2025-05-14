package Algorithm.LeetCode.Week07;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {

  private final PriorityQueue<Integer> pq = new PriorityQueue<>();
  private final Set<Integer> set = new HashSet<>();
  private int k = 1;

  public SmallestInfiniteSet() {
    pq.add(k++);
  }

  public int popSmallest() {
    pq.add(k++);
    int num = pq.poll();
    set.add(num);

    return num;
  }

  public void addBack(int num) {
    if (set.contains(num)) {
      pq.add(num);
      set.remove(num);
    }

  }
}

public class Smallest_Number_in_Infinite_Set {

  public static void main(String[] args) {
    String[] operations = {
        "SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest",
        "addBack", "popSmallest", "popSmallest", "popSmallest"
    };
    int[][] inputs = {
        {}, {2}, {}, {}, {}, {1}, {}, {}, {}
    };

    System.out.print("[");
    SmallestInfiniteSet obj = null;

    for (int i = 0; i < operations.length; i++) {
      String op = operations[i];
      switch (op) {
        case "SmallestInfiniteSet":
          obj = new SmallestInfiniteSet();
          System.out.print("null");
          break;
        case "addBack":
          obj.addBack(inputs[i][0]);
          System.out.print(", null");
          break;
        case "popSmallest":
          int res = obj.popSmallest();
          System.out.print(", " + res);
          break;
      }
    }

    System.out.println("]");
  }
}
