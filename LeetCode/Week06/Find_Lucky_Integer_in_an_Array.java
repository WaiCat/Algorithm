package Algorithm.LeetCode.Week06;

import java.util.HashMap;
import java.util.Map;

public class Find_Lucky_Integer_in_an_Array {

  public static void main(String[] args) {
    // Example 1
    int[] arr1 = {2, 2, 3, 4};
    System.out.println(findLucky(arr1)); // 2

    // Example 2
    int[] arr2 = {1, 2, 2, 3, 3, 3};
    System.out.println(findLucky(arr2)); // 3

    // Example 3
    int[] arr3 = {2, 2, 2, 3, 3};
    System.out.println(findLucky(arr3)); // -1
  }

  public static int findLucky(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();

    int lucky = -1;

    for (int num : arr) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : map.keySet()) {
      if (map.get(num) == num) {
        lucky = Math.max(num, map.get(num));
      }
    }

    return lucky;
  }
}
