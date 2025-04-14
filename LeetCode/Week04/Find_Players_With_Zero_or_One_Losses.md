## 🧠 알고리즘 문제 코드 분석 - Find Players With Zero or One Losses

## 📌 문제 요약
- **문제 이름**: [Find Players With Zero or One Losses](https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/)
- **문제 유형**: 해시맵, 정렬
- **난이도**: Medium
- **요구사항 요약**:
  - 각 match는 `[승자, 패자]` 쌍으로 주어짐
  - **한 번도 지지 않은 선수 목록**, **딱 한 번만 진 선수 목록**을 각각 정렬하여 반환하라

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
int[][] matches = {
  {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
  {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}
};
```

### 출력 예시
```java
[[1, 2, 10], [4, 5, 7, 8]]
```

---

## 🔍 접근 방식

- **입력 크기 분석**: matches 최대 10⁵ → O(n log n) 가능
- **알고리즘 선택**: HashMap + 정렬
- **이유**: 패배 횟수를 추적하고, 특정 조건을 만족하는 키만 추출해야 하기 때문
- **핵심 아이디어**:
  - 각 플레이어의 패배 횟수를 HashMap에 저장
  - 0회 패배 → 승자 목록
  - 1회 패배 → 단일 패배자 목록

---

## 💻 핵심 코드 분석

```java
public static List<List<Integer>> findWinners(int[][] matches) {
    Map<Integer, Integer> loss = new HashMap<>();

    for (int[] match : matches) {
        loss.put(match[1], loss.getOrDefault(match[1], 0) + 1);
        loss.putIfAbsent(match[0], 0);
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    result.add(new ArrayList<>());

    for (int i : loss.keySet()) {
        if (loss.get(i) == 1) {
            result.get(1).add(i);
        } else if (loss.get(i) == 0) {
            result.get(0).add(i);
        }
    }

    Collections.sort(result.get(0));
    Collections.sort(result.get(1));
    return result;
}
```

- **설명**:
  - `loss` 맵: 각 선수의 패배 횟수 저장
  - 모든 승자도 `putIfAbsent`으로 0패배로 먼저 등록
  - 조건에 따라 리스트 분기 후 정렬

---

## 🧪 예제 테스트

| matches | 기대 출력 |
|---------|--------------|
| `[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]` | `[[1,2,10],[4,5,7,8]]` |
| `[[2,3],[1,3],[5,4],[6,4]]` | `[[1,2,5,6],[]]` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n log n) (정렬 포함)
- **공간복잡도**: O(n) (HashMap 및 결과 리스트)

---

## ✅ 최종 정리

- 패배 횟수를 기준으로 선수들을 그룹핑하는 해시맵 문제
- 0패와 1패를 구분한 후 정렬하여 반환하는 로직이 핵심
- `putIfAbsent` 사용으로 불필요한 조건 체크 생략 가능