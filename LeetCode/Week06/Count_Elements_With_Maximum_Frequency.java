package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.Map;

public class Count_Elements_With_Maximum_Frequency {

  public static void main(String[] args) {
    // Example 1
    int[] nums1 = {1, 2, 2, 3, 1, 4};
    System.out.println(maxFrequencyElements(nums1)); // 4

    // Example 2
    int[] nums2 = {1, 2, 3, 4, 5};
    System.out.println(maxFrequencyElements(nums2)); // 5
  }

  public static int maxFrequencyElements(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      max = Math.max(max, map.get(num));
    }

    int sum = 0;
    for (int num : map.keySet()) {
      if (map.get(num) == max) {
        sum += map.get(num);
      }
    }
    return sum;
  }
}
