package Algorithm.LeetCode.Week04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maximum_Number_of_Balloons {

  public static void main(String[] args) {
    System.out.println(maxNumberOfBalloons("nlaebolko"));         // 1
    System.out.println(maxNumberOfBalloons("loonbalxballpoon")); // 2
    System.out.println(maxNumberOfBalloons("leetcode"));          // 0
  }

  public static int maxNumberOfBalloons(String text) {
    Map<Character, Integer> map = new HashMap<>();

    Set<Character> balloonChars = Set.of('b', 'a', 'l', 'o', 'n');

    for (char c : text.toCharArray()) {
      if (balloonChars.contains(c)) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
    }

    int min = Integer.MAX_VALUE;

    min = Math.min(min, map.getOrDefault('b', 0));
    min = Math.min(min, map.getOrDefault('a', 0));
    min = Math.min(min, map.getOrDefault('l', 0) / 2);
    min = Math.min(min, map.getOrDefault('o', 0) / 2);
    min = Math.min(min, map.getOrDefault('n', 0));

    return min;
  }
}
