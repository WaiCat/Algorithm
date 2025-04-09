## 🧠 알고리즘 문제 코드 분석 - Squares of a Sorted Array

## 📌 문제 요약
- **문제 이름**: [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/description/)
- **문제 유형**: Two Pointer, 정렬
- **난이도**: Easy
- **요구사항 요약**:
  - 오름차순으로 정렬된 정수 배열이 주어짐
  - 각 요소를 제곱한 후, 다시 오름차순으로 정렬된 배열을 반환해야 함

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
nums = {-7, -3, 2, 3, 11}
```

### 출력 예시
```java
[4, 9, 9, 49, 121]
```

---

## 🔍 접근 방식
- **입력 크기 분석**: 배열 길이 최대 10⁴ → O(n) 또는 O(n log n) 가능
- **알고리즘 선택**: Two Pointer
- **이유**:
  - 음수의 제곱은 양수가 되므로 절댓값이 큰 수가 양 끝에 몰려 있음
  - 양 끝에서부터 비교하면서 큰 제곱 값을 뒤에서부터 채우면 정렬 없이 구현 가능
- **핵심 아이디어**:
  - 양쪽 포인터에서 큰 제곱값을 비교하여 결과 배열에 역순으로 삽입
  - 마지막에 결과 배열을 반전시켜 정렬 형태로 만들기

---

## 💻 핵심 코드 분석

```java
public static int[] sortedSquares(int[] nums) {
    int[] res = new int[nums.length];
    int left = 0;
    int right = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
        if(nums[left] * nums[left] > nums[right] * nums[right]) {
            res[i] = nums[left] * nums[left];
            left++;
        } else {
            res[i] = nums[right] * nums[right];
            right--;
        }
    }

    left = 0;
    right = res.length - 1;
    while (left < right) {
        int temp = res[left];
        res[left++] = res[right];
        res[right--] = temp;
    }

    return res;
}
```

- **설명**:
  - `left`와 `right`에서 큰 제곱 값을 비교하여 앞에서부터 `res`에 저장
  - 제곱의 큰 값이 앞에 저장되므로, 마지막에 배열을 뒤집어서 정렬된 결과 생성

---

## 🧪 예제 테스트

| 입력 | 기대 출력 | 실제 출력 | 일치 여부 |
|------|-----------|-----------|------------|
| `{-7, -3, 2, 3, 11}` | `[4, 9, 9, 49, 121]` | `[4, 9, 9, 49, 121]` | ✅ |
| `{-4, -1, 0, 3, 10}` | `[0, 1, 9, 16, 100]` | `[0, 1, 9, 16, 100]` | ✅ |
| `{1}` | `[1]` | `[1]` | ✅ |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
  - 배열을 한 번 순회하면서 정렬된 결과 생성
- **공간복잡도**: O(n)
  - 새로운 배열 `res`를 사용

---

## ✅ 최종 정리

- 투 포인터를 이용하여 음수와 양수의 절댓값 제곱을 정렬된 형태로 빠르게 정렬 가능
- 배열 뒤집기를 사용해 앞에서 채운 배열을 뒤집음으로써 정렬된 결과 생성
- 매우 자주 출제되는 기본 투 포인터 문제