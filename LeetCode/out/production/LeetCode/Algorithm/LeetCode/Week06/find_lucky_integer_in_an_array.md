## 🧠 알고리즘 문제 코드 분석 - Find Lucky Integer in an Array

## 📌 문제 요약
- **문제 이름**: [Find Lucky Integer in an Array](https://leetcode.com/problems/find-lucky-integer-in-an-array/)
- **문제 유형**: 배열, 해시맵
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `arr`이 주어졌을 때,
  - **배열 내 숫자 중 등장 횟수와 숫자가 같은 값** 중 가장 큰 값을 반환
  - 없다면 -1 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
arr = [2, 2, 3, 4]
```

### 출력 예시
```java
2
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 500 → O(n) 가능
- **알고리즘 선택**: HashMap
- **이유**: 각 숫자의 빈도수를 효율적으로 저장하고, 조건을 만족하는 값 중 최대값 찾기
- **핵심 아이디어**:
  - 배열을 순회하여 숫자의 빈도수를 해시맵에 저장
  - 해시맵을 순회하며 `map.get(num) == num` 조건을 만족하는 값 중 최대값 갱신

---

## 💻 핵심 코드 분석

```java
public static int findLucky(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    int lucky = -1;

    for (int num : arr) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : map.keySet()) {
        if (map.get(num) == num) {
            lucky = Math.max(lucky, num);
        }
    }

    return lucky;
}
```

- **설명**:
  - 첫 번째 루프: 숫자의 빈도를 해시맵에 저장
  - 두 번째 루프: 빈도와 숫자가 같은 값을 찾고, 최대값을 갱신

---

## 🧪 예제 테스트

| arr                  | 기대 출력 |
|----------------------|-------------|
| `[2, 2, 3, 4]`       | `2`         |
| `[1, 2, 2, 3, 3, 3]` | `3`         |
| `[2, 2, 2, 3, 3]`    | `-1`        |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (해시맵 저장용)

---

## ✅ 최종 정리

- 배열 내에서 등장 횟수와 값이 동일한 수를 찾는 문제
- 해시맵을 이용하여 빈도수를 관리하고 조건을 만족하는 최대값을 갱신
- 입력 크기가 작으므로 O(n) 알고리즘이 적절