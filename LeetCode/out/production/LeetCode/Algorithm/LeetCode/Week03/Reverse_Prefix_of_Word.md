## 🧠 알고리즘 문제 코드 분석 - Reverse Prefix of Word

## 📌 문제 요약
- **문제 이름**: [Reverse Prefix of Word](https://leetcode.com/problems/reverse-prefix-of-word/description/)
- **문제 유형**: 문자열, 투 포인터
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `word`와 문자 `ch`가 주어졌을 때,
  - `ch`가 처음 등장하는 인덱스를 기준으로 **해당 인덱스까지의 접두사를 뒤집은 문자열**을 반환하라
  - 만약 `ch`가 `word`에 없다면 원래 문자열을 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
word = "rzwuktxcjfpamlonbgyieqdvhs", ch = 's'
```

### 출력 예시
```java
"shvdsvqei ygbnolmapfjcxtkuwzr"
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 250 → O(n) 가능
- **알고리즘 선택**: 문자열 + 투 포인터
- **이유**: `ch` 위치를 찾아 해당 구간만 투 포인터로 reverse 처리하면 됨
- **핵심 아이디어**:
  - `char[]`로 변환해서 in-place 교환
  - 처음으로 `ch`가 나오는 인덱스를 `right`로 두고 0~right 범위 reverse

---

## 💻 핵심 코드 분석

```java
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
```

- **설명**:
  - 문자열을 배열로 변환 후 `ch`의 위치까지 양끝에서 swap
  - `ch`가 없으면 `right`는 그대로 0이라 swap 없이 그대로 반환됨

---

## 🧪 예제 테스트

| word | ch | 기대 출력 | 실제 출력 | 일치 여부 |
|------|----|------------|-------------|------------|
| `"rzwuktxcjfpamlonbgyieqdvhs"` | `'s'` | `"shvdsqei ygbnolmapfjcxtkuwzr"` | ✅ | ✅ |
| `"abcdefd"` | `'d'` | `"dcbaefd"` | `"dcbaefd"` | ✅ |
| `"xyxzxe"` | `'z'` | `"zxyxxe"` | `"zxyxxe"` | ✅ |
| `"abcd"` | `'z'` | `"abcd"` | `"abcd"` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (char 배열)

---

## ✅ 최종 정리

- 특정 문자까지의 접두사를 뒤집는 간단한 문자열 문제
- `char[]`로 바꿔서 투 포인터로 swap하면 성능 좋고 코드도 간결함
- 예외적으로 `ch`가 문자열에 없을 경우 처리도 자연스럽게 동작