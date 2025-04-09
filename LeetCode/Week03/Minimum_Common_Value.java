package Algorithm.LeetCode.Week03;

public class Minimum_Common_Value {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3};
    int[] nums2 = {2, 4};

    System.out.println(getCommon(nums2, nums1));
  }

  public static int getCommon(int[] nums1, int[] nums2) {
    int point1 = 0, point2 = 0;

    while (point1 < nums1.length && point2 < nums2.length) {
      if (nums1[point1] == nums2[point2]) {
        return nums1[point1];
      } else if (nums1[point1] < nums2[point2]) {
        point1++;
      } else {
        point2++;
      }
    }
    return -1;
  }
}
