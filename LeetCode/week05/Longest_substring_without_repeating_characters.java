package Algorithm.LeetCode.week05;

import java.util.HashMap;
import java.util.Map;

public class Longest_substring_without_repeating_characters {

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
    System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
    System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
    System.out.println(lengthOfLongestSubstring(" "));   // 1
    System.out.println(lengthOfLongestSubstring("abb"));   // 2
  }

  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int max = 0;
    int point = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (map.containsKey(c) && map.get(c) >= point) {
        // 중복된 문자를 발견했을 때, 윈도우 시작 위치 갱신
        point = map.get(c) + 1;
      }

      map.put(c, i); // 현재 문자 위치 갱신
      max = Math.max(max, i - point + 1); // 현재 윈도우 길이 계산
    }

    return max;
  }
}
