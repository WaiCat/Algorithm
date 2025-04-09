package Algorithm.LeetCode.Week02;

import java.util.Arrays;

public class K_Radius_Subarray_Averages {

  public static void main(String[] args) {
    int[] arr = {7, 4, 3, 9, 1, 8, 5, 2, 6};
    int k = 3;

    System.out.println(Arrays.toString(getAverages(arr, k)));
  }

  public static int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n];
    Arrays.fill(res, -1);

    int windowSize = 2 * k + 1;

    if (n < windowSize) {
      return res;
    }

    long sum = 0;

    for (int i = 0; i < windowSize; i++) {
      sum += nums[i];
    }

    res[k] = (int) (sum / windowSize);

    for (int i = k + 1; i < n - k; i++) {
      sum += nums[i + k];
      sum -= nums[i - k - 1];
      res[i] = (int) (sum / windowSize);
    }

    return res;
  }
}
