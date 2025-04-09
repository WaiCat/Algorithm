package Algorithm.LeetCode.Week02;

public class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {

  public static void main(String[] args) {
    int[] arr = {-12};

    System.out.println(minStartValue(arr));
  }

  public static int minStartValue(int[] nums) {
    int sum = nums[0];
    int min = sum;

    for (int i = 1; i < nums.length; i++) {
      min = Math.min(sum += nums[i], min);
    }

    if (min < 0) {
      return (min * -1) + 1;
    } else {
      return 1;
    }
  }
}
