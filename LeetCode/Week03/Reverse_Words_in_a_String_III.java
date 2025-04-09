package Algorithm.LeetCode.Week03;

public class Reverse_Words_in_a_String_III {

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    System.out.println(reverseWords(s));
  }

  public static String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < words.length; i++) {
      char[] chars = words[i].toCharArray();

      for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
      }

      result.append(new String(chars));

      if (i < words.length - 1) {
        result.append(" ");
      }
    }

    return result.toString();
  }
}
