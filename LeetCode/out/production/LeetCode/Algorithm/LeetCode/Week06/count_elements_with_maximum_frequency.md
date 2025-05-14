## 🧠 알고리즘 문제 코드 분석 - Count Elements With Maximum Frequency

## 📌 문제 요약
- **문제 이름**: [Count Elements With Maximum Frequency](https://leetcode.com/problems/count-elements-with-maximum-frequency/description/)
- **문제 유형**: 배열, 해시맵
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `nums`가 주어졌을 때,
  - **가장 많이 등장하는 빈도**를 가지는 숫자들의 빈도 합을 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [1, 2, 2, 3, 1, 4]
```

### 출력 예시
```java
4
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 100 → O(n) 가능
- **알고리즘 선택**: HashMap
- **이유**: 각 숫자의 빈도수를 효율적으로 저장 및 최대 빈도값 계산
- **핵심 아이디어**:
  - 배열을 순회하여 숫자의 빈도수를 해시맵에 저장
  - 최대 빈도수를 먼저 계산하고, 그 빈도수를 가지는 값들의 빈도 합을 구함

---

## 💻 핵심 코드 분석

```java
public static int maxFrequencyElements(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
        max = Math.max(max, map.get(num));
    }

    int sum = 0;
    for (int num : map.keySet()) {
        if (map.get(num) == max) {
            sum += map.get(num);
        }
    }

    return sum;
}
```

- **설명**:
  - 첫 번째 루프: 숫자의 빈도를 해시맵에 저장하면서 최대 빈도수 계산
  - 두 번째 루프: 최대 빈도수를 가지는 숫자들의 빈도 합산

---

## 🧪 예제 테스트

| nums                 | 기대 출력 |
|----------------------|-------------|
| `[1, 2, 2, 3, 1, 4]` | `4`         |
| `[1, 2, 3, 4, 5]`    | `5`         |
| `[7, 7, 7, 2, 2, 2, 3]` | `3`     |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (해시맵 저장용)

---

## ✅ 최종 정리

- 배열 내 최대 빈도수를 가지는 숫자들을 빠르게 찾기 위해 해시맵 사용
- 두 번의 순회로 최대 빈도수와 빈도 합을 구하는 간단한 문제
- 해시맵을 이용하여 등장 횟수를 관리하는 연습에 적합