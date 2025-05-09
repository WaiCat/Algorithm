## 🧠 알고리즘 문제 코드 분석 - Maximum Average Subarray I

## 📌 문제 요약
- **문제 이름**: [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/description/)
- **문제 유형**: Sliding Window
- **난이도**: Easy
- **요구사항 요약**:
  - 정수 배열 `nums`와 정수 `k`가 주어짐
  - 연속된 `k`개의 요소로 이루어진 서브배열 중 **최대 평균값**을 구하라
  - 평균은 **정수 나눗셈이 아닌 실수(Double)** 형태로 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [0, 4, 0, 3, 2], k = 1
```

### 출력 예시
```java
4.0
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 배열 길이 최대 10⁴ → O(n) 가능
- **알고리즘 선택**: Sliding Window
- **이유**: 고정된 크기의 연속된 구간의 합/평균을 구할 때 효율적으로 사용할 수 있음
- **핵심 아이디어**:
  - 처음 `k`개의 합을 먼저 구해 초기값으로 설정
  - 한 칸씩 오른쪽으로 슬라이딩하면서 새로운 합을 만들고, 최대값을 업데이트
  - 마지막에 최대 합을 `k`로 나눠 평균 반환

---

## 💻 핵심 코드 분석

```java
public static double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }
    double max = sum;

    for (int i = 0; i < nums.length - k; i++) {
        sum = sum - nums[i] + nums[i + k];
        max = Math.max(sum, max);
    }

    return max / k;
}
```

- **설명**:
  - `sum`: 현재 슬라이딩 윈도우 내 합
  - `max`: 최대 합 추적
  - 평균은 `sum / k`를 `double`로 반환

---

## 🧪 예제 테스트

| nums | k | 기대 출력 | 실제 출력 | 일치 여부 |
|------|---|------------|------------|------------|
| `[0, 4, 0, 3, 2]` | 1 | `4.0` | `4.0` | ✅ |
| `[1, 12, -5, -6, 50, 3]` | 4 | `12.75` | `12.75` | ✅ |
| `[5, 5, 5, 5, 5]` | 2 | `5.0` | `5.0` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1)

---

## ✅ 최종 정리

- 슬라이딩 윈도우 알고리즘을 이용해 고정 길이 서브배열의 최대 평균을 효율적으로 계산
- 합을 미리 구하고 한 칸씩 이동하며 더하고 빼는 방식이 핵심
- `double` 나눗셈으로 평균을 정확하게 반환해야 함