## 🧠 알고리즘 문제 코드 분석 - Ransom Note

## 📌 문제 요약
- **문제 이름**: [Ransom Note](https://leetcode.com/problems/ransom-note/)
- **문제 유형**: 문자열, 해시맵
- **난이도**: Easy
- **요구사항 요약**:
  - `ransomNote` 문자열을 `magazine` 문자열에 있는 문자들로 만들 수 있는지 확인
  - 각 문자는 한 번만 사용할 수 있음

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
ransomNote = "aa", magazine = "aab"
```

### 출력 예시
```java
true
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁵ → O(n) 가능
- **알고리즘 선택**: HashMap
- **이유**: 각 문자의 빈도 수를 빠르게 조회 및 비교 가능
- **핵심 아이디어**:
  - 두 문자열의 각 문자 빈도를 HashMap에 저장
  - `ransomNote`의 각 문자가 `magazine`에 충분히 있는지 확인

---

## 💻 핵심 코드 분석

```java
public static boolean canConstruct(String ransomNote, String magazine) {
    HashMap<Character, Integer> mapR = new HashMap<>();
    HashMap<Character, Integer> mapM = new HashMap<>();

    for (char c : ransomNote.toCharArray()) {
        mapR.put(c, mapR.getOrDefault(c, 0) + 1);
    }
    for (char c : magazine.toCharArray()) {
        mapM.put(c, mapM.getOrDefault(c, 0) + 1);
    }

    for (char j : mapR.keySet()) {
        if (!mapM.containsKey(j)) {
            return false;
        } else if (mapR.get(j) > mapM.get(j)) {
            return false;
        }
    }

    return true;
}
```

- **설명**:
  - `mapR`: ransomNote에 필요한 문자와 개수 저장
  - `mapM`: magazine에서 제공되는 문자와 개수 저장
  - 모든 문자에 대해 개수 충분한지 검증

---

## 🧪 예제 테스트

| ransomNote | magazine | 기대 출력 |
|------------|----------|-------------|
| `"a"` | `"b"` | `false` |
| `"aa"` | `"ab"` | `false` |
| `"aa"` | `"aab"` | `true` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n + m)
- **공간복잡도**: O(1) (알파벳 26개 기준)

---

## ✅ 최종 정리

- ransomNote의 각 문자를 magazine으로부터 만들 수 있는지 확인하는 기본 문제
- HashMap 또는 배열을 이용해 문자 빈도 비교하는 방식으로 효율적 해결 가능