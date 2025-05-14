package Algorithm.LeetCode.Week07;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Construct_String_With_Repeat_Limit {

  public static void main(String[] args) {
    // Example 1
    String s1 = "cczazcc";
    int limit1 = 3;
    String result1 = repeatLimitedString(s1, limit1);
    System.out.println("Input: s = \"cczazcc\", repeatLimit = 3");
    System.out.println("Output: " + result1); // Expected: "zzcccac"

    // Example 2
    String s2 = "aababab";
    int limit2 = 2;
    String result2 = repeatLimitedString(s2, limit2);
    System.out.println("Input: s = \"aababab\", repeatLimit = 2");
    System.out.println("Output: " + result2); // Expected: "bbabaa"
  }

  public static String repeatLimitedString(String s, int repeatLimit) {
    Map<Character, Integer> map = new HashMap<>();

    PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (char c : map.keySet()) {
      pq.add(c);
    }

    StringBuilder sb = new StringBuilder();

    while (!pq.isEmpty()) {
      char c = pq.poll();
      int repeat;
      if (map.get(c) > repeatLimit) {
        repeat = repeatLimit;
        map.put(c, map.get(c) - repeatLimit);
      } else {
        repeat = map.remove(c);
      }

      for (int i = 0; i < repeat; i++) {
        sb.append(c);
      }

      if (map.containsKey(c)) {
        if (pq.isEmpty()) {
          break;
        }
        char h = pq.poll();
        sb.append(h);
        if (map.get(h) > 1) {
          map.put(h, map.get(h) - 1);
        } else {
          map.remove(h);
        }
        pq.add(c);
        if (map.containsKey(h)) {
          pq.add(h);
        }
      }
    }

    return sb.toString();
  }
}
