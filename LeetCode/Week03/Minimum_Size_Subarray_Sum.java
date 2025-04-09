package Algorithm.LeetCode.Week03;

public class Minimum_Size_Subarray_Sum {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int target = 11;
    System.out.println(minSubArrayLen(target, nums));
  }

  public static int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      while (sum >= target) {
        min = Math.min(min, i - left + 1);
        sum -= nums[left++];
      }
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
