## 🧠 알고리즘 문제 코드 분석 - Longest Substring Without Repeating Characters

## 📌 문제 요약
- **문제 이름**: [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- **문제 유형**: 슬라이딩 윈도우, 해시맵, 문자열
- **난이도**: Medium
- **요구사항 요약**:
  - 문자열 `s`가 주어졌을 때,
  - **중복 문자가 없는 가장 긴 연속 부분 문자열의 길이**를 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "abcabcbb"
```

### 출력 예시
```java
3 // "abc"
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 5 * 10⁴ → O(n) 필요
- **알고리즘 선택**: HashMap + Sliding Window
- **이유**: 중복 여부를 실시간으로 확인하며 윈도우 조절
- **핵심 아이디어**:
  - 중복 문자가 발견되면 시작 포인터를 **중복된 문자 다음 위치로 이동**
  - 해시맵은 문자와 마지막 인덱스를 기록

---

## 💻 핵심 코드 분석

```java
public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();

    int max = 0;
    int point = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (map.containsKey(c) && map.get(c) >= point) {
            point = map.get(c) + 1;
        }

        map.put(c, i);
        max = Math.max(max, i - point + 1);
    }

    return max;
}
```

- **설명**:
  - `point`: 중복이 발생하지 않는 현재 윈도우의 시작 위치
  - `map`: 각 문자의 마지막 등장 위치 기록
  - 중복 발생 시 윈도우 시작 위치(point)를 이전 중복 문자 다음으로 이동

---

## 🧪 예제 테스트

| s | 기대 출력 |
|---|-------------|
| `"abcabcbb"` | `3` |
| `"bbbbb"` | `1` |
| `"pwwkew"` | `3` |
| `" "` | `1` |
| `"abb"` | `2` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (문자 위치 저장용 HashMap)

---

## ✅ 최종 정리

- 슬라이딩 윈도우의 대표 문제
- 중복 문자가 있는 순간, 윈도우를 중복 이후 위치로 밀어주는 전략이 핵심
- HashMap을 이용하여 중복 여부와 위치를 빠르게 탐색