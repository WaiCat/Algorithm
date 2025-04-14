## 🧠 알고리즘 문제 코드 분석 - Maximum Number of Balloons

## 📌 문제 요약
- **문제 이름**: [Maximum Number of Balloons](https://leetcode.com/problems/maximum-number-of-balloons/description/)
- **문제 유형**: 해시맵, 문자열
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `text`에서 "balloon"이라는 단어를 **최대 몇 번 만들 수 있는지** 반환
  - 각 문자는 한 번만 사용할 수 있으며, `'l'`, `'o'`는 각각 2번씩 필요

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
text = "loonbalxballpoon"
```

### 출력 예시
```java
2
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁴ → O(n) 가능
- **알고리즘 선택**: 해시맵
- **이유**: 각 알파벳의 개수를 저장하고 비교하기 위해 적합
- **핵심 아이디어**:
  - "balloon"에서 필요한 문자의 수를 기준으로,
  - 입력 문자열에서 각 문자의 개수를 세고 가능한 최소 개수만큼 만들 수 있음

---

## 💻 핵심 코드 분석

```java
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
```

- **설명**:
  - 'l'과 'o'는 두 번씩 필요하므로 개수를 절반으로 나눔
  - 필요한 알파벳만 저장하고 그 중 최소값이 만들 수 있는 최대 횟수

---

## 🧪 예제 테스트

| text | 기대 출력 | 실제 출력 | 일치 여부 |
|------|--------------|--------------|------------|
| `"nlaebolko"` | `1` | `1` | ✅ |
| `"loonbalxballpoon"` | `2` | `2` | ✅ |
| `"leetcode"` | `0` | `0` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1) (최대 알파벳 26개)

---

## ✅ 최종 정리

- 문자열 내에서 특정 단어를 몇 번 만들 수 있는지를 판단하는 문제
- 필요한 알파벳의 개수를 정확히 맞춰 비교하는 것이 핵심
- 특히 'l', 'o'는 중복 필요하므로 나눗셈 주의 필요