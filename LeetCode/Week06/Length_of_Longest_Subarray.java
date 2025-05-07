package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.Map;

public class Length_of_Longest_Subarray {

  public static void main(String[] args) {
    // Example 1
    int[] nums1 = {1, 2, 3, 1, 2, 3, 1, 2};
    int k1 = 2;
    System.out.println(maxSubarrayLength(nums1, k1)); // 6

    // Example 2
    int[] nums2 = {1, 2, 1, 2, 1, 2, 1, 2};
    int k2 = 1;
    System.out.println(maxSubarrayLength(nums2, k2)); // 2

    // Example 3
    int[] nums3 = {5, 5, 5, 5, 5, 5, 5};
    int k3 = 4;
    System.out.println(maxSubarrayLength(nums3, k3)); // 4
  }

  public static int maxSubarrayLength(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int left = 0;
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
      while (map.get(nums[i]) > k) {
        map.put(nums[left], map.get(nums[left]) - 1);
        left++;
      }
      max = Math.max(max, i - left + 1);
    }

    return max;
  }
}
