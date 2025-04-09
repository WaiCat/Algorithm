package Algorithm.LeetCode.Week03;

public class Get_Equal_Substrings_Within_Budget {

  public static void main(String[] args) {
    System.out.println(equalSubstring("abcd", "bcdf", 3));
    System.out.println(equalSubstring("abcd", "cdef", 3));
    System.out.println(equalSubstring("abcd", "acde", 0));
  }

  public static int equalSubstring(String s, String t, int maxCost) {
    int start = 0, cost = 0, maxLen = 0;

    int[] costs = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
    }

    for (int end = 0; end < s.length(); end++) {
      cost += costs[end];

      while (cost > maxCost) {
        cost -= costs[start];
        start++;
      }
      maxLen = Math.max(maxLen, end - start + 1);
    }

    return maxLen;
  }


}
