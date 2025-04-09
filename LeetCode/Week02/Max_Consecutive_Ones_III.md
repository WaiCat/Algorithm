## 🧠 알고리즘 문제 코드 분석 - Max Consecutive Ones III

## 📌 문제 요약
- **문제 이름**: [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/description/)
- **문제 유형**: Sliding Window, Two Pointer
- **난이도**: Medium
- **요구사항 요약**:
  - 이진 배열 `nums`와 정수 `k`가 주어짐
  - 최대 `k`개의 0을 1로 뒤집을 수 있을 때
  - **가장 긴 연속된 1의 길이**를 구하라

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [0, 0, 0, 1], k = 4
```

### 출력 예시
```java
4
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁵ → O(n) 가능
- **알고리즘 선택**: Sliding Window
- **이유**: 0의 개수가 `k`를 넘지 않도록 유지하면서 구간을 확장하고 축소하는 방식이 유효함
- **핵심 아이디어**:
  - 0의 개수가 `k` 이하인 윈도우 내 최대 길이를 찾는다
  - 새로운 0이 추가되었을 때 왼쪽에서 1을 줄여서 윈도우 유지

---

## 💻 핵심 코드 분석

```java
public static int longestOnes(int[] nums, int k) {
    int countZero = 0;
    int point = 0;

    // 초기 point 위치: 최대 k개의 0을 포함할 수 있는 윈도우 확장
    while (countZero < k) {
        if (nums[point++] == 0) {
            countZero++;
        }
        if (point == nums.length) {
            return point;
        }
    }

    int maxLen = point;
    int len = point;

    for (int i = point; i < nums.length; i++) {
        if (nums[i] == 1) {
            len++;
        } else {
            while (nums[i - len] == 1) {
                len--;
            }
        }
        maxLen = Math.max(maxLen, len);
    }

    return maxLen;
}
```

- **설명**:
  - 처음 `point`는 k개의 0을 포함한 최대 구간을 미리 계산
  - 이후 한 칸씩 확장하며 1이면 계속 증가, 0이면 왼쪽 1을 줄여 윈도우 유지
  - `maxLen`을 갱신하면서 최대 연속 1의 길이를 추적

---

## 🧪 예제 테스트

| nums | k | 기대 출력 | 실제 출력 | 일치 여부 |
|------|---|------------|------------|------------|
| `[0, 0, 0, 1]` | 4 | `4` | `4` | ✅ |
| `[1,1,1,0,0,0,1,1,1,1,0]` | 2 | `6` | `6` | ✅ |
| `[0,0,1,1,1,0,0]` | 0 | `3` | `3` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(1)

---

## ✅ 최종 정리

- 윈도우 내 0의 개수를 기준으로 범위를 확장/축소하며 최대 연속된 1의 길이 추적
- 슬라이딩 윈도우 및 투 포인터의 전형적인 활용 예시
- 초기 point 설정 로직이 독특하며 최적화에 도움이 됨