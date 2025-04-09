## 🧠 알고리즘 문제 코드 분석 - Get Equal Substrings Within Budget

## 📌 문제 요약
- **문제 이름**: [Get Equal Substrings Within Budget](https://leetcode.com/problems/get-equal-substrings-within-budget/description/)
- **문제 유형**: Sliding Window, 문자열
- **난이도**: Medium
- **요구사항 요약**:
  - 두 문자열 `s`와 `t`, 그리고 정수 `maxCost`가 주어짐
  - 각 문자 위치마다 `|s[i] - t[i]|`의 비용이 들고, 총 비용이 `maxCost` 이하인 가장 긴 연속된 서브스트링의 길이를 구하라

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "abcd", t = "bcdf", maxCost = 3
```

### 출력 예시
```java
3  // "abc" -> "bcd" 비용: 1+1+1 = 3
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁵ → O(n) 필요
- **알고리즘 선택**: Sliding Window
- **이유**: 연속된 구간에서 누적 비용을 관리하면서 최대 길이를 구하는 데 적합
- **핵심 아이디어**:
  - 각 인덱스마다 문자 차이의 절댓값을 계산하여 비용 배열 생성
  - 슬라이딩 윈도우를 사용해 누적 비용이 `maxCost`를 넘지 않도록 조절

---

## 💻 핵심 코드 분석

```java
public static int equalSubstring(String s, String t, int maxCost) {
    int start = 0, cost = 0, maxLen = 0;
    int[] costs = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
        costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
    }

    for (int end = 0; end < s.length(); end++) {
        cost += costs[end];
        while (cost > maxCost) {
            cost -= costs[start];
            start++;
        }
        maxLen = Math.max(maxLen, end - start + 1);
    }

    return maxLen;
}
```

- **설명**:
  - `costs[i]`: 각 문자 간 변환 비용
  - 슬라이딩 윈도우로 비용 누적, `maxCost` 초과 시 왼쪽에서 빼기
  - 최대 길이 갱신

---

## 🧪 예제 테스트

| s | t | maxCost | 기대 출력 | 실제 출력 | 일치 여부 |
|----|----|---------|-------------|--------------|------------|
| `"abcd"` | `"bcdf"` | 3 | 3 | 3 | ✅ |
| `"abcd"` | `"cdef"` | 3 | 1 | 1 | ✅ |
| `"abcd"` | `"acde"` | 0 | 1 | 1 | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (cost 배열)

---

## ✅ 최종 정리

- 문자 차이의 비용을 기반으로 한 고정 비용 제한 슬라이딩 윈도우 문제
- 총 비용이 `maxCost`를 넘지 않도록 하면서 윈도우 크기 최댓값을 찾는 전형적인 형태
- 문자열 처리 + 숫자 조건을 잘 결합한 문제