package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Unique_Number_of_Occurrences {

  public static void main(String[] args) {
    // Example 1
    int[] arr1 = {1, 2, 2, 1, 1, 3};
    System.out.println(uniqueOccurrences(arr1)); // true

    // Example 2
    int[] arr2 = {1, 2};
    System.out.println(uniqueOccurrences(arr2)); // false

    // Example 3
    int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
    System.out.println(uniqueOccurrences(arr3)); // true
  }

  public static boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : map.values()) {
      if (set.contains(num)) {
        return false;
      }
      set.add(num);
    }

    return true;
  }
}
