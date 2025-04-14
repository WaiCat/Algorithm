package Algorithm.LeetCode.Week04;

import java.util.HashMap;
import java.util.Map;

public class Largest_Unique_Number {

  public static void main(String[] args) {
    System.out.println(largestUniqueNumber(new int[]{5, 7, 3, 9, 4, 9, 8, 3, 1})); // 8
    System.out.println(largestUniqueNumber(new int[]{9, 9, 8, 8}));               // -1
  }

  public static int largestUniqueNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int max = -1;

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        max = Math.max(max, entry.getKey());
      }
    }

    return max;
  }
}
