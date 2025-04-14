package Algorithm.LeetCode.Week04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Players_With_Zero_or_One_Losses {

  public static void main(String[] args) {
    int[][] matches1 = {
        {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
        {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}
    };
    System.out.println(findWinners(matches1)); // [[1, 2, 10], [4, 5, 7, 8]]

    int[][] matches2 = {
        {2, 3}, {1, 3}, {5, 4}, {6, 4}
    };
    System.out.println(findWinners(matches2)); // [[1, 2, 5, 6], []]
  }

  public static List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> loss = new HashMap<>();

    for (int[] match : matches) {
      loss.put(match[1], loss.getOrDefault(match[1], 0) + 1);
      loss.putIfAbsent(match[0], 0);
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    result.add(new ArrayList<>());
    for (int i : loss.keySet()) {
      if (loss.get(i) == 1) {
        result.get(1).add(i);
      } else if (loss.get(i) == 0) {
        result.get(0).add(i);
      }
    }
    Collections.sort(result.get(0));
    Collections.sort(result.get(1));
    return result;
  }
}
