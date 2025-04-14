package Algorithm.LeetCode.Week04;

import java.util.HashSet;
import java.util.Set;

public class Counting_Elements {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3};
    System.out.println("Output: " + countElements(arr1)); //  2

    int[] arr2 = {1, 1, 3, 3, 5, 5, 7, 7};
    System.out.println("Output: " + countElements(arr2)); //  0
  }

  public static int countElements(int[] arr) {
    int count = 0;
    Set<Integer> set = new HashSet<>();

    for (int i : arr) {
      set.add(i);
    }

    for (int i : arr) {
      if (set.contains(i + 1)) {
        count++;
      }
    }

    return count;
  }
}
