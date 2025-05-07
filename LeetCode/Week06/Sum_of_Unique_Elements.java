package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.Map;

public class Sum_of_Unique_Elements {

  public static void main(String[] args) {
    // Example 1
    int[] nums1 = {1, 2, 3, 2};
    System.out.println(sumOfUnique(nums1)); // 4

    // Example 2
    int[] nums2 = {1, 1, 1, 1, 1};
    System.out.println(sumOfUnique(nums2)); // 0

    // Example 3
    int[] nums3 = {1, 2, 3, 4, 5};
    System.out.println(sumOfUnique(nums3)); // 15
  }

  public static int sumOfUnique(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int sum = 0;

    for (int key : map.keySet()) {
      if (map.get(key) == 1) {
        sum += key;
      }
    }

    return sum;
  }
}
