## 🧠 알고리즘 문제 코드 분석 - Reverse Only Letters

## 📌 문제 요약
- **문제 이름**: [Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters/description/)
- **문제 유형**: Two Pointer, 문자열
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `s`에서 **알파벳 문자만 역순으로 배치**하고, 다른 문자는 그대로 유지한 문자열을 반환하라

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "ab-cd"
```

### 출력 예시
```java
"dc-ba"
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 100 → O(n) 가능
- **알고리즘 선택**: 투 포인터 (양쪽에서 알파벳만 찾기)
- **이유**: 앞/뒤에서 동시에 알파벳을 탐색해 효율적으로 교환 가능
- **핵심 아이디어**:
  - `left`는 왼쪽에서, `right`는 오른쪽에서 알파벳을 탐색
  - 두 문자가 모두 알파벳이면 서로 위치를 바꿈
  - 알파벳이 아닌 문자는 그대로 두고 건너뜀

---

## 💻 핵심 코드 분석

```java
public static String reverseOnlyLetters(String s) {
    char[] chars = s.toCharArray();
    int left = 0;
    int right = chars.length - 1;

    while (left < right) {
        if (!Character.isLetter(chars[left])) {
            left++;
        } else if (!Character.isLetter(chars[right])) {
            right--;
        } else {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    return new String(chars);
}
```

- **설명**:
  - `Character.isLetter(char)`를 이용해 문자가 알파벳인지 확인
  - 양 끝에서 알파벳을 찾고 swap
  - 알파벳이 아닌 문자는 건너뛰므로 자리는 유지됨

---

## 🧪 예제 테스트

| 입력 | 기대 출력 | 실제 출력 | 일치 여부 |
|------|------------|------------|------------|
| `"ab-cd"` | `"dc-ba"` | `"dc-ba"` | ✅ |
| `"a-bC-dEf-ghIj"` | `"j-Ih-gfE-dCba"` | `"j-Ih-gfE-dCba"` | ✅ |
| `"Test1ng-Leet=code-Q!"` | `"Qedo1ct-eeLg=ntse-T!"` | `"Qedo1ct-eeLg=ntse-T!"` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (char 배열 사용)

---

## ✅ 최종 정리

- 투 포인터를 활용해 알파벳만 역순으로 바꾸는 전형적인 문제
- `Character.isLetter()` 함수 사용이 핵심
- 문자열 속 특정 조건을 유지하며 처리하는 문제 유형에서 자주 출제됨