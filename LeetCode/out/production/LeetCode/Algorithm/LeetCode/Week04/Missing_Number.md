## 🧠 알고리즘 문제 코드 분석 - Missing Number

## 📌 문제 요약
- **문제 이름**: [Missing Number](https://leetcode.com/problems/missing-number/description/)
- **문제 유형**: 배열, Set, 수학
- **난이도**: Easy
- **요구사항 요약**:
  - 길이 `n`의 배열 `nums`는 `[0, 1, ..., n]` 범위의 숫자 중 **하나가 빠진 형태**
  - 빠진 숫자를 찾아 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = [3, 0, 1]
```

### 출력 예시
```java
2
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁴ → O(n) 가능
- **알고리즘 선택**: Set 이용하여 빠진 값 확인
- **이유**: 존재 여부를 빠르게 확인하기 위해 HashSet 사용
- **핵심 아이디어**:
  - 0부터 n까지의 숫자 중 하나만 빠져 있으므로,
  - Set에 모두 넣고 0부터 n까지 조회하며 없는 값 반환

---

## 💻 핵심 코드 분석

```java
class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
```

- **설명**:
  - 입력 배열을 Set에 저장
  - 0부터 n까지 순회하며 누락된 숫자가 있는지 확인
  - 빠진 숫자가 발견되면 즉시 반환

---

## 🧪 예제 테스트

| nums | 기대 출력 | 실제 출력 | 일치 여부 |
|------|-------------|--------------|------------|
| `[3, 0, 1]` | `2` | `2` | ✅ |
| `[0, 1]` | `2` | `2` | ✅ |
| `[9,6,4,2,3,5,7,0,1]` | `8` | `8` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (Set 사용)

---

## ✅ 최종 정리

- 누락된 숫자 탐색에 Set을 이용한 방법은 매우 직관적이고 빠름
- 이외에도 **합계 공식** `n(n+1)/2 - sum(nums)`를 쓰는 방법도 존재 (공간 O(1))