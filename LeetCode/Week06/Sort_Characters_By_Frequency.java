package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
  
  public static void main(String[] args) {
    // Example 1
    String s1 = "tree";
    System.out.println(frequencySort(s1)); // "eert" 또는 "eetr"

    // Example 2
    String s2 = "cccaaa";
    System.out.println(frequencySort(s2)); // "aaaccc" 또는 "cccaaa"

    // Example 3
    String s3 = "Aabb";
    System.out.println(frequencySort(s3)); // "bbAa" 또는 "bbaA"
  }

  public static String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    maxHeap.addAll(map.keySet());

    StringBuilder result = new StringBuilder();

    while (!maxHeap.isEmpty()) {
      char current = maxHeap.poll();
      int frequency = map.get(current);
      for (int i = 0; i < frequency; i++) {
        result.append(current);
      }
    }

    return result.toString();
  }
}
