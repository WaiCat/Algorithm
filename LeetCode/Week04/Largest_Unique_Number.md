## 🧠 알고리즘 문제 코드 분석 - Largest Unique Number

## 📌 문제 요약
- **문제 이름**: [Largest Unique Number](https://leetcode.com/problems/largest-unique-number/)
- **문제 유형**: 해시맵, 정렬
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `nums`에서 **한 번만 등장한 정수 중 가장 큰 값**을 찾아 반환
  - 만약 중복 없이 등장하는 수가 없다면 `-1` 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [5,7,3,9,4,9,8,3,1]
```

### 출력 예시
```java
8
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 2000 → O(n) 가능
- **알고리즘 선택**: HashMap (빈도수 카운팅)
- **이유**: 각 수의 등장 횟수를 카운팅한 후, 1번 등장한 수 중 최대값을 선택
- **핵심 아이디어**:
  - 각 정수의 등장 횟수를 HashMap에 저장
  - 등장 횟수가 1인 수들 중 최대값을 찾음

---

## 💻 핵심 코드 분석

```java
public static int largestUniqueNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    int max = -1;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
            max = Math.max(max, entry.getKey());
        }
    }

    return max;
}
```

- **설명**:
  - `map.getOrDefault(num, 0) + 1`로 빈도수 카운팅
  - 단 한 번만 등장하는 수 중에서 `max` 갱신

---

## 🧪 예제 테스트

| nums | 기대 출력 | 실제 출력 | 일치 여부 |
|------|--------------|--------------|------------|
| `[5,7,3,9,4,9,8,3,1]` | `8` | `8` | ✅ |
| `[9,9,8,8]` | `-1` | `-1` | ✅ |
| `[1]` | `1` | `1` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (HashMap 사용)

---

## ✅ 최종 정리

- 가장 큰 고유값(1번 등장)을 찾는 문제로, 빈도수 기반 정렬 없이도 해결 가능
- HashMap으로 빈도수만 잘 저장하면 간단하게 최대값 찾기 가능
- 실무에서도 자주 쓰이는 빈도수 처리 패턴 문제