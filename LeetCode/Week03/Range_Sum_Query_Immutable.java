package Algorithm.LeetCode.Week03;

public class Range_Sum_Query_Immutable {

  private final int[] prefixSum;

  public Range_Sum_Query_Immutable(int[] nums) {
    prefixSum = new int[nums.length + 1];

    for (int i = 0; i < nums.length; i++) {
      prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
  }

  public static void main(String[] args) {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    Range_Sum_Query_Immutable obj = new Range_Sum_Query_Immutable(nums);

    System.out.println(obj.sumRange(0, 2)); // 출력: 1
    System.out.println(obj.sumRange(2, 5)); // 출력: -1
    System.out.println(obj.sumRange(0, 5)); // 출력: -3
  }

  public int sumRange(int left, int right) {
    return prefixSum[right + 1] - prefixSum[left];
  }
}
