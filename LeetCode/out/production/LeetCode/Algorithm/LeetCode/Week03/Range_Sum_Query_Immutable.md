## 🧠 알고리즘 문제 코드 분석 - Range Sum Query - Immutable

## 📌 문제 요약
- **문제 이름**: [Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/description/)
- **문제 유형**: Prefix Sum, 클래스 설계
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `nums`가 주어졌을 때,
  - 주어진 `left`, `right` 범위에 대한 **합을 빠르게 반환**하는 `sumRange(left, right)` 메서드를 구현하라
  - 여러 번 호출될 수 있으므로 빠른 조회가 중요

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) → 1
sumRange(2, 5) → -1
sumRange(0, 5) → -3
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁴ → O(n) 전처리 + O(1) 쿼리 필요
- **알고리즘 선택**: 누적합(Prefix Sum)
- **이유**: 구간 합을 빠르게 조회하기 위해 누적합 배열을 미리 만들어두면 O(1)로 조회 가능
- **핵심 아이디어**:
  - `prefixSum[i] = nums[0] + ... + nums[i-1]` (0-based 누적합)
  - `sumRange(left, right) = prefixSum[right + 1] - prefixSum[left]`

---

## 💻 핵심 코드 분석

```java
public class Range_Sum_Query_Immutable {
    private final int[] prefixSum;

    public Range_Sum_Query_Immutable(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
```

- **설명**:
  - 생성자에서 누적합 배열 `prefixSum`을 초기화
  - `sumRange` 메서드에서는 단순히 구간 합 공식 적용

---

## 🧪 예제 테스트

| nums | 호출 | 기대 출력 | 실제 출력 | 일치 여부 |
|------|--------|-------------|--------------|------------|
| `[-2, 0, 3, -5, 2, -1]` | `sumRange(0, 2)` | `1` | `1` | ✅ |
| `[-2, 0, 3, -5, 2, -1]` | `sumRange(2, 5)` | `-1` | `-1` | ✅ |
| `[-2, 0, 3, -5, 2, -1]` | `sumRange(0, 5)` | `-3` | `-3` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **전처리 시간복잡도**: O(n)
- **쿼리 시간복잡도 (`sumRange`)**: O(1)
- **공간복잡도**: O(n)

---

## ✅ 최종 정리

- 구간 합 문제에서 다수의 쿼리가 주어질 경우, 누적합 배열을 미리 계산해두면 효율적
- `prefixSum[i]`는 인덱스 `i-1`까지의 합을 의미
- 전형적인 Prefix Sum을 활용한 Range Query 문제