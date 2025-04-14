package Algorithm.LeetCode.Week04;

import java.util.HashSet;
import java.util.Set;

public class Check_if_the_Sentence_Is_Pangram {

  public static void main(String[] args) {
    String sentence1 = "thequickbrownfoxjumpsoverthelazydog";
    System.out.println(checkIfPangram(sentence1)); // true

    String sentence2 = "leetcode";
    System.out.println(checkIfPangram(sentence2)); // false
  }

  public static boolean checkIfPangram(String sentence) {
    Set<Character> pangram = new HashSet<>();

    for (char c : sentence.toCharArray()) {
      pangram.add(c);
    }

    return pangram.size() == 26;
  }
}
