## 🧠 알고리즘 문제 코드 분석 - Reverse Words in a String III

## 📌 문제 요약
- **문제 이름**: [Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/description/)
- **문제 유형**: 문자열, 투 포인터
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `s`가 주어졌을 때, 각 단어의 알파벳 순서를 뒤집되, 단어 순서는 그대로 유지하여 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "Let's take LeetCode contest"
```

### 출력 예시
```java
"s'teL ekat edoCteeL tsetnoc"
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 5 * 10⁴ → O(n) 가능
- **알고리즘 선택**: 문자열 분할 + 투 포인터를 이용한 역순 처리
- **이유**: 단어 단위로 나누고, 각 단어의 문자만 역순으로 바꾸면 됨
- **핵심 아이디어**:
  - 공백 `" "`을 기준으로 문자열을 분할
  - 각 단어를 문자 배열로 바꾸고, 투 포인터로 문자 순서를 역전
  - `StringBuilder`를 이용해 결과 문자열을 효율적으로 생성

---

## 💻 핵심 코드 분석

```java
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
```

- **설명**:
  - `split(" ")`으로 단어 분리
  - 각 단어를 `char[]`로 바꾼 뒤 양쪽에서부터 swap하며 역순 처리
  - 공백을 유지하면서 단어를 이어붙임

---

## 🧪 예제 테스트

| 입력 | 기대 출력 | 실제 출력 | 일치 여부 |
|------|------------|------------|------------|
| `"Let's take LeetCode contest"` | `"s'teL ekat edoCteeL tsetnoc"` | `"s'teL ekat edoCteeL tsetnoc"` | ✅ |
| `"God Ding"` | `"doG gniD"` | `"doG gniD"` | ✅ |
| `"a"` | `"a"` | `"a"` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n) (전체 문자열 한 번 순회)
- **공간복잡도**: O(n) (문자 배열 및 결과 문자열)

---

## ✅ 최종 정리

- 각 단어의 문자만 역순으로 처리하고 단어의 순서는 그대로 유지하는 문제
- `StringBuilder` + `char[]` 변환 + 투 포인터 방식으로 효율적인 구현 가능
- 문자열 처리 문제에서 매우 자주 등장하는 기본 유형