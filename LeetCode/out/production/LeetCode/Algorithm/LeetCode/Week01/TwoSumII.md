## 🧠 알고리즘 문제 코드 분석 - Two Sum II - Input Array Is Sorted

## 📌 문제 요약
- **문제 이름**: [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)
- **문제 유형**: Two Pointer, 이분탐색
- **난이도**: Medium
- **요구사항 요약**:
  - 정렬된 정수 배열 `numbers`가 주어짐
  - 서로 다른 두 수의 합이 `target`이 되는 인덱스(1-based)를 반환해야 함
  - 정답은 반드시 하나 존재하며, 같은 요소를 두 번 사용하지 않음

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
numbers = [2,7,11,15]
target = 9
```

### 출력 예시
```java
[1, 2]
```

---

## 🔍 접근 방식
- **입력 크기 분석**: 최대 10⁵ → O(n) 또는 O(log n) 가능
- **알고리즘 선택**: Two Pointer
- **이유**:
  - 정렬된 배열이므로 양 끝에서 시작해 합을 조절하며 탐색 가능
- **핵심 아이디어**:
  - `left`와 `right` 두 포인터로 합을 계산
  - 합이 작으면 `left++`, 크면 `right--`, 같으면 정답 반환

---

## 💻 핵심 코드 분석

```java
public static int[] twoSum(int[] numbers, int target) {
    int left = 0;
    int right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target) {
            return new int[]{left+1, right+1};
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{-1, -1};
}
```

- **설명**:
  - 정렬된 배열이기 때문에 양 끝에서부터 조건을 좁혀나가는 방식이 가능
  - `1-based index` 반환을 위해 `+1` 해줌

---

## 🧪 예제 테스트

| numbers | target | 기대 출력 | 실제 출력 | 일치 여부 |
|---------|--------|------------|------------|------------|
| `[2, 7, 11, 15]` | 9 | `[1, 2]` | `[1, 2]` | ✅ |
| `[1, 2, 3, 4, 4, 9, 56, 90]` | 8 | `[4, 5]` | `[4, 5]` | ✅ |
| `[5, 25, 75]` | 100 | `[2, 3]` | `[2, 3]` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
  - 한 번의 투 포인터 탐색으로 해결
- **공간복잡도**: O(1)
  - 추가 공간 없이 인덱스만으로 처리

---

## ✅ 최종 정리

- 정렬된 배열의 두 수의 합을 찾는 대표적인 투 포인터 문제
- 단순하지만 자주 나오는 패턴으로, 두 포인터의 이동 조건이 핵심
- 결과를 1-based 인덱스로 반환하는 점만 주의하면 됨