package Algorithm.LeetCode.Week03;

import java.util.Arrays;

public class Move_Zeroes {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void moveZeroes(int[] nums) {
    int zero = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[i];
        nums[i] = nums[zero];
        nums[zero] = temp;
        zero++;
      }
    }
  }
}
