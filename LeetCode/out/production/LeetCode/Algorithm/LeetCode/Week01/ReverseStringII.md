## 🧠 알고리즘 문제 코드 분석 - Reverse String II

## 📌 문제 요약
- **문제 이름**: [Reverse String II](https://leetcode.com/problems/reverse-string-ii/description/)
- **문제 유형**: Two Pointer, 문자열 처리
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `s`와 정수 `k`가 주어짐.
  - 매 2k 문자마다 처음 k개 문자를 뒤집고, 나머지 k개는 그대로 유지.
  - 문자열 길이가 k보다 작으면 모두 뒤집기.
  - 문자열 길이가 2k보다 작고 k 이상이면 처음 k개만 뒤집기.

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "abcd"
k = 2
```

### 출력 예시
```java
"bacd"
```

---

## 🔍 접근 방식
- **입력 크기 분석**: 문자열 길이 최대 10⁴ → O(n) 가능
- **알고리즘 선택**: Two Pointer + 구간 처리
- **이유**:
  - 문자열을 구간 단위로 뒤집어야 하므로 투 포인터 혹은 배열 인덱스 접근 방식 적합
- **핵심 아이디어**:
  - 문자열을 `char[]`로 변환하여 in-place 방식으로 뒤집음
  - 인덱스 `i`를 `2k`씩 증가시키면서 처음 `k`만 뒤집음

---

## 💻 핵심 코드 분석

```java
public static String reverseStr(String s, int k) {
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i += (2 * k)) {
        int left;
        int right;
        if (s.length() - i >= k) {
            left = i;
            right = i + k - 1;
        } else {
            left = i;
            right = s.length() - 1;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
    return new String(chars);
}
```

- **설명**:
  - `2k` 간격으로 순회
  - 구간 길이에 따라:
    - `k` 이상: 처음 `k`개 뒤집기
    - `k` 미만: 남은 모든 문자 뒤집기
  - 투 포인터 방식으로 문자 교환

---

## 🧪 예제 테스트

| 입력 | 기대 출력 | 실제 출력 | 일치 여부 |
|------|-----------|-----------|------------|
| "abcd", 2 | "bacd" | "bacd" | ✅ |
| "abcdefg", 2 | "bacdfeg" | "bacdfeg" | ✅ |
| "a", 2 | "a" | "a" | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
  - 문자열을 한 번 순회하면서 각 구간을 뒤집기 때문
- **공간복잡도**: O(n)
  - `char[]`로 복사한 공간 사용 (Java 문자열은 불변이므로 필수)

---

## ✅ 최종 정리

- 구간 기반으로 문자열을 조작하는 문제는 `2k` 단위로 반복하는 로직이 중요
- `char[]`로 변환하여 in-place로 처리하는 것이 문자열 처리에서 효율적
- `while (left < right)`을 통해 간단하게 구간 반전을 구현할 수 있음