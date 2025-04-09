## 🧠 알고리즘 문제 코드 분석 - Find Pivot Index

## 📌 문제 요약
- **문제 이름**: [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/description/)
- **문제 유형**: 누적합 (Prefix Sum)
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `nums`에서 **왼쪽 합과 오른쪽 합이 같은 피벗 인덱스**를 찾아라
  - 피벗 인덱스는 `leftSum == rightSum`을 만족하는 인덱스
  - 존재하지 않으면 `-1`을 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [1, 7, 3, 6, 5, 6]
```

### 출력 예시
```java
3  // left = 1+7+3 = 11, right = 5+6 = 11
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁴ → O(n) 가능
- **알고리즘 선택**: 누적합
- **이유**: 전체 합에서 현재까지 합을 빼면 오른쪽 합을 쉽게 구할 수 있음
- **핵심 아이디어**:
  - 배열 전체 합 `totalSum`을 먼저 계산
  - 왼쪽 합을 순차적으로 누적하면서 `rightSum = totalSum - leftSum - nums[i]`로 비교

---

## 💻 핵심 코드 분석

```java
public static int pivotIndex(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
        totalSum += num;
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
        int rightSum = totalSum - leftSum - nums[i];
        if (leftSum == rightSum) {
            return i;
        }
        leftSum += nums[i];
    }

    return -1;
}
```

- **설명**:
  - `totalSum`을 먼저 구하고,
  - 각 인덱스마다 `rightSum = totalSum - leftSum - nums[i]`를 이용해 비교
  - 같으면 피벗 인덱스 반환

---

## 🧪 예제 테스트

| nums | 기대 출력 | 실제 출력 | 일치 여부 |
|------|-------------|--------------|------------|
| `[1, 7, 3, 6, 5, 6]` | `3` | `3` | ✅ |
| `[1, 2, 3]` | `-1` | `-1` | ✅ |
| `[2, 1, -1]` | `0` | `0` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1)

---

## ✅ 최종 정리

- 누적합을 이용하여 양쪽 합을 비교하는 효율적인 방식
- `rightSum`을 굳이 따로 계산하지 않고 `totalSum`으로 처리하여 공간 효율 향상
- 단순하지만 매우 유용한 prefix sum 사고력 훈련 문제