package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.Map;

public class Number_of_Good_Pairs {

  public static void main(String[] args) {
    // Example 1
    int[] nums1 = {1, 2, 3, 1, 1, 3};
    System.out.println(numIdenticalPairs(nums1)); // 4

    // Example 2
    int[] nums2 = {1, 1, 1, 1};
    System.out.println(numIdenticalPairs(nums2)); // 6

    // Example 3
    int[] nums3 = {1, 2, 3};
    System.out.println(numIdenticalPairs(nums3)); // 0
  }

  public static int numIdenticalPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;

    for (int num : nums) {
      if (map.containsKey(num)) {
        res += map.get(num);
      }
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    return res;
  }

}
