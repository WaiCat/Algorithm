package Algorithm.LeetCode.Week03;

public class Find_Pivot_Index {

  public static void main(String[] args) {
    int[] nums1 = {1, 7, 3, 6, 5, 6};
    int[] nums2 = {1, 2, 3};
    int[] nums3 = {2, 1, -1};

    System.out.println("Output 1: " + pivotIndex(nums1)); // 3
    System.out.println("Output 2: " + pivotIndex(nums2)); // -1
    System.out.println("Output 3: " + pivotIndex(nums3)); // 0
  }

  public static int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      int rightSum = totalSum - leftSum - nums[i];
      if (leftSum == rightSum) {
        return i;
      }
      leftSum += nums[i];
    }

    return -1;
  }
}
