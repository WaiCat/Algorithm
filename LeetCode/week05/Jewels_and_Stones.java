package Algorithm.LeetCode.week05;

import java.util.HashMap;
import java.util.Map;

public class Jewels_and_Stones {

  public static void main(String[] args) {
    System.out.println("Output: " + numJewelsInStones("aA", "aAAbbbb")); // Output: 3
    System.out.println("Output: " + numJewelsInStones("z", "ZZ")); // Output: 0
  }

  public static int numJewelsInStones(String jewels, String stones) {
    Map<Character, Integer> mapJ = new HashMap<>();
    Map<Character, Integer> mapS = new HashMap<>();

    for (char c : jewels.toCharArray()) {
      mapJ.put(c, mapJ.getOrDefault(c, 0) + 1);
    }

    for (char c : stones.toCharArray()) {
      mapS.put(c, mapS.getOrDefault(c, 0) + 1);
    }

    int sum = 0;
    for (char c : mapJ.keySet()) {
      if (mapS.containsKey(c)) {
        sum += mapS.get(c);
      }
    }

    return sum;
  }
}
