## 🧠 알고리즘 문제 코드 분석 - Minimum Size Subarray Sum

## 📌 문제 요약
- **문제 이름**: [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)
- **문제 유형**: Sliding Window, 투 포인터
- **난이도**: Medium
- **요구사항 요약**:
  - 정수 배열 `nums`와 정수 `target`이 주어질 때,
  - 합이 `target` 이상이 되는 **가장 짧은 연속 부분 배열의 길이**를 반환하라
  - 그런 부분 배열이 없으면 `0`을 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [1, 2, 3, 4, 5], target = 11
```

### 출력 예시
```java
3  // [3,4,5]의 합이 12
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁵ → O(n) 필요
- **알고리즘 선택**: Sliding Window (투 포인터)
- **이유**: 연속된 부분 배열의 합 조건을 만족할 때 윈도우를 최소화하는 데 적합
- **핵심 아이디어**:
  - `right` 포인터로 합을 키우고, 조건을 만족하면 `left`를 이동시켜 길이를 줄여 최솟값 갱신

---

## 💻 핵심 코드 분석

```java
public static int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int left = 0;
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        while (sum >= target) {
            min = Math.min(min, i - left + 1);
            sum -= nums[left++];
        }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
}
```

- **설명**:
  - `sum`이 `target` 이상이 되는 구간을 찾으면 그 길이를 갱신
  - 이후 `left`를 줄여가며 가능한 최소 길이를 탐색

---

## 🧪 예제 테스트

| nums | target | 기대 출력 | 실제 출력 | 일치 여부 |
|------|--------|-------------|--------------|------------|
| `[1,2,3,4,5]` | `11` | `3` | `3` | ✅ |
| `[1,1,1,1,1,1,1,1]` | `11` | `0` | `0` | ✅ |
| `[1,4,4]` | `4` | `1` | `1` | ✅ |
| `[2,3,1,2,4,3]` | `7` | `2` | `2` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1)

---

## ✅ 최종 정리

- 슬라이딩 윈도우를 활용해 조건을 만족하는 최소 길이 연속 부분 배열 탐색
- `sum`이 기준 이상이 되는 동안 `left`를 밀어주면서 구간 길이 최소화
- `min == Integer.MAX_VALUE` 체크로 조건을 만족하지 못한 경우도 처리