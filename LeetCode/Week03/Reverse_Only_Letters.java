package Algorithm.LeetCode.Week03;

public class Reverse_Only_Letters {

  public static void main(String[] args) {
    System.out.println(reverseOnlyLetters("ab-cd"));
    System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
    System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }

  public static String reverseOnlyLetters(String s) {
    char[] chars = s.toCharArray();
    int left = 0;
    int right = chars.length - 1;

    while (left < right) {
      if (!Character.isLetter(chars[left])) {
        left++;
      } else if (!Character.isLetter(chars[right])) {
        right--;
      }
      // 둘 다 영어면 교환
      else {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      }
    }

    return new String(chars);
  }


}
