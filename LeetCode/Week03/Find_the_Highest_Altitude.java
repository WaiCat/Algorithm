package Algorithm.LeetCode.Week03;

public class Find_the_Highest_Altitude {

  public static void main(String[] args) {
    int[] nums1 = {-5, 1, 5, 0, -7};
    int[] nums2 = {-4, -3, -2, -1, 4, 3, 2};

    System.out.println("Output 1: " + largestAltitude(nums1));
    System.out.println("Output 2: " + largestAltitude(nums2));
  }

  public static int largestAltitude(int[] gain) {
    int max = 0;
    int sum = 0;
    for (int i = 0; i < gain.length; i++) {
      sum += gain[i];
      max = Math.max(max, sum);
    }

    return max;
  }
}
