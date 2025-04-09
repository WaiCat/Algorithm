package Algorithm.LeetCode.Week02;

import java.util.Arrays;

public class Running_Sum_of_1d_Array {

  public static void main(String[] args) {
    int[] arr = {3, 1, 2, 10, 1};

    System.out.println(Arrays.toString(runningSum(arr)));
  }

  public static int[] runningSum(int[] nums) {
    int[] result = new int[nums.length];
    result[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      result[i] = nums[i] + result[i - 1];
    }

    return result;
  }
}
