## 🧠 알고리즘 문제 코드 분석 - Equal Row and Column Pairs

## 📌 문제 요약
- **문제 이름**: [Equal Row and Column Pairs](https://leetcode.com/problems/equal-row-and-column-pairs/description/)
- **문제 유형**: 해시맵, 2차원 배열, 문자열 직렬화
- **난이도**: Medium
- **요구사항 요약**:
  - 주어진 `n x n` 정수형 그리드에서,
  - 어떤 행(row)과 열(column)의 값이 **완전히 동일한 경우의 쌍의 개수**를 구하라

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
grid = [
  [3, 2, 1],
  [1, 7, 6],
  [2, 7, 7]
]
```

### 출력 예시
```java
1
```

---

## 🔍 접근 방식

- **입력 크기 분석**: n ≤ 200 → O(n² log n) 가능
- **알고리즘 선택**: HashMap + 문자열 직렬화
- **이유**: 행과 열을 문자열로 바꾸고, 일치 여부를 해시맵으로 빠르게 비교 가능
- **핵심 아이디어**:
  - 각 행을 문자열로 바꾸고 Map에 빈도를 저장
  - 각 열도 문자열로 바꾼 뒤, Map에서 같은 문자열이 있는지 조회하여 카운트 증가

---

## 💻 핵심 코드 분석

```java
public static int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<String, Integer> rowMap = new HashMap<>();

    for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(grid[i][j]).append(',');
        }
        String rowStr = sb.toString();
        rowMap.put(rowStr, rowMap.getOrDefault(rowStr, 0) + 1);
    }

    int count = 0;
    for (int j = 0; j < n; j++) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(grid[i][j]).append(',');
        }
        String colStr = sb.toString();
        count += rowMap.getOrDefault(colStr, 0);
    }

    return count;
}
```

- **설명**:
  - `rowMap`: 직렬화된 각 행 문자열 → 등장 횟수 저장
  - 열도 같은 방식으로 문자열로 바꾸고 Map에서 찾기

---

## 🧪 예제 테스트

| grid | 기대 출력 |
|------|-------------|
| `[[3,2,1],[1,7,6],[2,7,7]]` | `1` |
| `[[1,2,3],[4,5,6],[7,8,9]]` | `0` |
| `[[11,1],[1,11]]` | `2` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n²)
- **공간복잡도**: O(n²) (문자열 맵 저장용)

---

## ✅ 최종 정리

- 2차원 배열을 1차원 문자열로 직렬화하여 비교하는 전형적인 응용
- 문자열 비교 대신 배열 비교로도 구현 가능하나, 문자열 방식이 직관적
- 중요한 것은 **행을 기준으로 먼저 해시맵을 구성하고**, 열은 이를 참조한다는 구조