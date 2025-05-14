package Algorithm.LeetCode.Week07;

import java.util.PriorityQueue;

class SeatManager {

  private final PriorityQueue<Integer> pq;

  public SeatManager(int n) {
    pq = new PriorityQueue<>();
    for (int i = 1; i <= n; i++) {
      pq.add(i);
    }
  }

  public int reserve() {
    return pq.poll();
  }

  public void unreserve(int seatNumber) {
    pq.add(seatNumber);
  }
}

public class Seat_Reservation_Manager {

  public static void main(String[] args) {
    // 입력 시나리오
    String[] operations = {
        "SeatManager", "reserve", "reserve", "unreserve",
        "reserve", "reserve", "reserve", "reserve", "unreserve"
    };
    int[][] inputs = {
        {5}, {}, {}, {2}, {}, {}, {}, {}, {5}
    };

    // 출력 결과
    System.out.print("[");
    SeatManager manager = null;
    for (int i = 0; i < operations.length; i++) {
      String op = operations[i];

      switch (op) {
        case "SeatManager":
          manager = new SeatManager(inputs[i][0]);
          System.out.print("null");
          break;
        case "reserve":
          int reserved = manager.reserve();
          System.out.print(", " + reserved);
          break;
        case "unreserve":
          manager.unreserve(inputs[i][0]);
          System.out.print(", null");
          break;
      }
    }
    System.out.println("]");
  }
}
