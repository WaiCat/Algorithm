package Algorithm.LeetCode.Week03;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

  public static void main(String[] args) {
    String s = "abciiidef";
    int k = 3;
    System.out.println(maxVowels(s, k));
  }

  public static int maxVowels(String s, int k) {

    int maxCount = 0, currentCount = 0;

    for (int i = 0; i < k; i++) {
      if (isVowel(s.charAt(i))) {
        currentCount++;
      }
    }

    maxCount = currentCount;

    for (int i = k; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) {
        currentCount++;
      }
      if (isVowel(s.charAt(i - k))) {
        currentCount--;
      }
      maxCount = Math.max(maxCount, currentCount);
    }

    return maxCount;
  }

  private static boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
  }
}
