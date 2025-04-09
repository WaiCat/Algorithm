package Algorithm.LeetCode.Week02;

public class Maximum_Average_Subarray_I {

  public static void main(String[] args) {
    int[] arr = {0, 4, 0, 3, 2};
    int k = 1;
    System.out.println(findMaxAverage(arr, k));

  }

  public static double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; i++) {
      sum += nums[i];
    }
    double max = sum;

    for (int i = 0; i < nums.length - k; i++) {
      sum = sum - nums[i] + nums[i + k];
      max = Math.max(sum, max);
    }

    return max / k;
  }

}
