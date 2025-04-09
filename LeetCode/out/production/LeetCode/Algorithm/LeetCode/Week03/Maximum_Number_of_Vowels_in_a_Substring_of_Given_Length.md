## 🧠 알고리즘 문제 코드 분석 - Maximum Number of Vowels in a Substring of Given Length

## 📌 문제 요약
- **문제 이름**: [Maximum Number of Vowels in a Substring of Given Length](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/)
- **문제 유형**: Sliding Window, 문자열
- **난이도**: Medium
- **요구사항 요약**:
  - 문자열 `s`와 정수 `k`가 주어질 때,
  - 길이가 `k`인 모든 부분 문자열 중에서 **가장 많은 모음(a, e, i, o, u)** 을 포함한 부분 문자열의 **모음 개수 최댓값**을 구하라

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "abciiidef", k = 3
```

### 출력 예시
```java
3
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁵ → O(n) 가능
- **알고리즘 선택**: Sliding Window (고정 길이)
- **이유**: 고정된 크기의 부분 문자열을 순회하며 모음 개수를 갱신해야 하기 때문
- **핵심 아이디어**:
  - 초기 구간에서 모음 개수를 세고 저장
  - 윈도우를 한 칸씩 이동하면서 추가된 문자와 제거된 문자가 모음인지 판별하여 카운트 갱신

---

## 💻 핵심 코드 분석

```java
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
```

- **설명**:
  - 처음 `k`길이의 부분 문자열 내 모음 수 세기
  - 이후 오른쪽으로 한 칸씩 이동하며 들어온 문자가 모음이면 증가, 나간 문자가 모음이면 감소
  - 현재 카운트를 기준으로 `maxCount` 업데이트

---

## 🧪 예제 테스트

| s | k | 기대 출력 | 실제 출력 | 일치 여부 |
|---|---|------------|------------|------------|
| `"abciiidef"` | 3 | 3 | 3 | ✅ |
| `"aeiou"` | 2 | 2 | 2 | ✅ |
| `"leetcode"` | 3 | 2 | 2 | ✅ |
| `"rhythms"` | 4 | 0 | 0 | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1)

---

## ✅ 최종 정리

- 슬라이딩 윈도우로 고정된 길이의 문자열 안의 모음 개수를 빠르게 추적 가능
- `aeiou` 문자열을 활용한 `indexOf()` 방식으로 모음 체크 간편화
- 윈도우가 움직일 때 모음 개수를 직접 더하고 빼는 방식으로 성능 향상