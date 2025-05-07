package Algorithm.LeetCode.week05;

import java.util.HashMap;

public class Ransom_Note {

  public static void main(String[] args) {
    System.out.println(canConstruct("a", "b"));      // false
    System.out.println(canConstruct("aa", "ab"));    // false
    System.out.println(canConstruct("aa", "aab"));   // true
  }

  public static boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> mapR = new HashMap<>();
    HashMap<Character, Integer> mapM = new HashMap<>();

    for (char c : ransomNote.toCharArray()) {
      mapR.put(c, mapR.getOrDefault(c, 0) + 1);
    }
    for (char c : magazine.toCharArray()) {
      mapM.put(c, mapM.getOrDefault(c, 0) + 1);
    }

    for (char j : mapR.keySet()) {
      if (!mapM.containsKey(j)) {
        return false;
      } else if (mapR.get(j) > mapM.get(j)) {
        return false;
      }
    }

    return true;
  }
}
