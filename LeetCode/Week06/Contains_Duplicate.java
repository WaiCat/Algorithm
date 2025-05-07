package Algorithm.LeetCode.Week06;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 1};
    int[] nums2 = {1, 2, 3, 4};
    int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

    System.out.println("Example 1: " + containsDuplicate(nums1)); // true
    System.out.println("Example 2: " + containsDuplicate(nums2)); // false
    System.out.println("Example 3: " + containsDuplicate(nums3)); // true
  }

  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int i : nums) {
      if (set.contains(i)) {
        return true;
      } else {
        set.add(i);
      }
    }

    return false;
  }
}
