## 🧠 알고리즘 문제 코드 분석 - Check if the Sentence Is Pangram

## 📌 문제 요약
- **문제 이름**: [Check if the Sentence Is Pangram](https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/)
- **문제 유형**: 문자열, Set
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `sentence`가 주어졌을 때,
  - 해당 문자열에 **알파벳 소문자 a~z가 모두 적어도 한 번씩 등장**하는지 확인
  - 조건을 만족하면 true, 그렇지 않으면 false 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
sentence = "thequickbrownfoxjumpsoverthelazydog"
```

### 출력 예시
```java
true
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 1000자 → O(n) 가능
- **알고리즘 선택**: Set 자료구조
- **이유**: 중복 없이 알파벳을 수집하고 개수로 확인할 수 있기 때문
- **핵심 아이디어**:
  - Set에 등장하는 알파벳을 추가
  - 최종적으로 Set 크기가 26이면 pangram

---

## 💻 핵심 코드 분석

```java
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> pangram = new HashSet<>();

        for (char c : sentence.toCharArray()) {
            pangram.add(c);
        }

        return pangram.size() == 26;
    }
}
```

- **설명**:
  - `sentence`를 문자 배열로 순회하며 Set에 추가
  - Set은 중복을 허용하지 않기 때문에 알파벳 개수만 세면 됨
  - 26개면 모든 알파벳이 포함되어 있다는 의미

---

## 🧪 예제 테스트

| sentence | 기대 출력 | 실제 출력 | 일치 여부 |
|----------|-------------|--------------|------------|
| `"thequickbrownfoxjumpsoverthelazydog"` | `true` | `true` | ✅ |
| `"leetcode"` | `false` | `false` | ✅ |
| `"abcdefghijklmnopqrstuvwxyz"` | `true` | `true` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1) (Set의 크기는 최대 26)

---

## ✅ 최종 정리

- Pangram 여부를 판단할 땐 Set으로 알파벳 개수를 추적하는 것이 가장 직관적
- Set의 크기가 26인지 여부만 확인하면 됨
- 혹은 배열로 boolean[26] 체크해도 동일한 결과 가능