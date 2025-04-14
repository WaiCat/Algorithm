package Algorithm.LeetCode.Week04;

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array {

  public static void main(String[] args) {
    System.out.println(findMaxLength(new int[]{0, 1}));               // 2
    System.out.println(findMaxLength(new int[]{0, 1, 0}));            // 2
    System.out.println(findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}));  // 6
  }

  public static int findMaxLength(int[] nums) {
    int maxl = 0;
    int sum = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i] == 0 ? -1 : 1;

      if (map.containsKey(sum)) {
        maxl = Math.max(maxl, i - map.get(sum));
      } else {
        map.put(sum, i);
      }
    }

    return maxl;
  }
}
