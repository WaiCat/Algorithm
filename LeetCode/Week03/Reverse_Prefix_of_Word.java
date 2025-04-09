package Algorithm.LeetCode.Week03;

public class Reverse_Prefix_of_Word {

  public static void main(String[] args) {
    String word = "rzwuktxcjfpamlonbgyieqdvhs";
    char ch = 's';

    System.out.println(reversePrefix(word, ch));
  }

  public static String reversePrefix(String word, char ch) {
    char[] chars = word.toCharArray();

    int left = 0;
    int right = 0;
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == ch) {
        right = i;
        break;
      }
    }

    while (left < right) {
      char temp = chars[left];
      chars[left++] = chars[right];
      chars[right--] = temp;
    }

    return new String(chars);
  }
}
