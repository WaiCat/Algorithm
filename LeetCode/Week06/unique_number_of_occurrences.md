## 🧠 알고리즘 문제 코드 분석 - Unique Number of Occurrences

## 📌 문제 요약
- **문제 이름**: [Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/)
- **문제 유형**: 배열, 해시맵, 해시셋
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `arr`이 주어졌을 때,
  - **각 숫자의 등장 횟수**가 모두 다르면 `true`, 중복이 있으면 `false` 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
arr = [1, 2, 2, 1, 1, 3]
```

### 출력 예시
```java
true
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 1000 → O(n) 가능
- **알고리즘 선택**: HashMap + HashSet
- **이유**: 숫자의 등장 횟수를 카운팅하고, 그 횟수가 유일한지 확인하기 위함
- **핵심 아이디어**:
  - 배열을 순회하며 숫자의 빈도수를 해시맵에 저장
  - 해시맵의 값들을 Set에 추가하며 중복 여부 확인

---

## 💻 핵심 코드 분석

```java
public static boolean uniqueOccurrences(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    for (int num : arr) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : map.values()) {
        if (set.contains(num)) {
            return false;
        }
        set.add(num);
    }

    return true;
}
```

- **설명**:
  - 첫 번째 루프: 각 숫자의 빈도를 해시맵에 저장
  - 두 번째 루프: 해시맵의 값(빈도)을 Set에 추가하며 중복 여부 확인

---

## 🧪 예제 테스트

| arr                           | 기대 출력 |
|-------------------------------|-------------|
| `[1, 2, 2, 1, 1, 3]`           | `true`      |
| `[1, 2]`                      | `false`     |
| `[-3, 0, 1, -3, 1, 1, 1, -3, 10, 0]` | `true` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (해시맵 및 해시셋 사용)

---

## ✅ 최종 정리

- 숫자의 등장 횟수가 모두 유일한지 확인하는 문제
- HashMap으로 빈도수를 구하고, HashSet으로 중복 여부를 확인하여 해결
- 등장 횟수가 유일해야 하므로 Set에 중복이 발생하면 false 반환