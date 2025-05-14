## 🧠 알고리즘 문제 코드 분석 - Contains Duplicate

## 📌 문제 요약
- **문제 이름**: [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/)
- **문제 유형**: 배열, 해시셋
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `nums`가 주어졌을 때, 
  - **중복된 값이 존재하면 true**, 그렇지 않으면 false를 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [1, 2, 3, 1]
```

### 출력 예시
```java
true
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁵ → O(n) 가능
- **알고리즘 선택**: HashSet
- **이유**: 중복 여부를 빠르게 확인하려면 HashSet이 적합
- **핵심 아이디어**:
  - 배열의 각 요소를 Set에 추가하면서 이미 존재하면 true 반환
  - 반복 없이 끝까지 진행하면 false 반환

---

## 💻 핵심 코드 분석

```java
public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();

    for (int i : nums) {
        if (set.contains(i)) {
            return true;
        } else {
            set.add(i);
        }
    }

    return false;
}
```

- **설명**:
  - `set.contains(i)`: 이미 있는 경우 중복으로 true 반환
  - 그렇지 않다면 Set에 추가하여 중복 여부 관리

---

## 🧪 예제 테스트

| nums | 기대 출력 |
|------|-------------|
| `[1, 2, 3, 1]` | `true` |
| `[1, 2, 3, 4]` | `false` |
| `[1, 1, 1, 3, 3, 4, 3, 2, 4, 2]` | `true` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (중복 검사용 Set 사용)

---

## ✅ 최종 정리

- 중복 여부 확인을 빠르게 처리하려면 Set 사용이 최적
- 중복 발생 시 즉시 반환하므로 효율적
- 배열을 정렬하여 인접한 원소를 비교하는 방법도 있으나 O(n log n)으로 더 느림