package Algorithm.LeetCode.Week02;

public class Max_Consecutive_Ones_III {

  public static void main(String[] args) {
    int[] arr = {0, 0, 0, 1};
    int k = 4;
    System.out.println(longestOnes(arr, k));
  }

  public static int longestOnes(int[] nums, int k) {
    int countZero = 0;
    int point = 0;

    while (countZero < k) {
      if (nums[point++] == 0) {
        countZero++;
      }
      if (point == nums.length) {
        return point;
      }
    }

    int maxLen = point;
    int len = point;

    for (int i = point; i < nums.length; i++) {
      if (nums[i] == 1) {
        len++;
      } else {
        while (nums[i - len] == 1) {
          len--;
        }
      }

      maxLen = Math.max(maxLen, len);

    }

    return maxLen;
  }

}
