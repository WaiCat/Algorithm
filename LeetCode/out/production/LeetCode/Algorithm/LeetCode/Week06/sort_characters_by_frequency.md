## 🧠 알고리즘 문제 코드 분석 - Sort Characters By Frequency

## 📌 문제 요약
- **문제 이름**: [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/description/)
- **문제 유형**: 문자열, 해시맵, 우선순위 큐
- **난이도**: Medium
- **요구사항 요약**:
  - 문자열 `s`가 주어졌을 때,
  - 문자 빈도수가 높은 순으로 정렬하여 새로운 문자열로 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
s = "tree"
```

### 출력 예시
```java
"eert" 또는 "eetr"
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 5 * 10⁵ → O(n log n) 가능
- **알고리즘 선택**: HashMap + PriorityQueue (Max Heap)
- **이유**: 각 문자 빈도수를 저장하고, 빈도수를 기준으로 우선순위 큐를 사용하여 정렬
- **핵심 아이디어**:
  - 문자열을 순회하여 각 문자 빈도를 해시맵에 저장
  - 빈도수를 기준으로 정렬하는 우선순위 큐에 추가
  - 큐에서 빈도가 높은 문자부터 순서대로 꺼내어 문자열 생성

---

## 💻 핵심 코드 분석

```java
public static String frequencySort(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
    maxHeap.addAll(map.keySet());

    StringBuilder result = new StringBuilder();

    while (!maxHeap.isEmpty()) {
        char current = maxHeap.poll();
        int frequency = map.get(current);
        for (int i = 0; i < frequency; i++) {
            result.append(current);
        }
    }

    return result.toString();
}
```

- **설명**:
  - 첫 번째 루프: 각 문자의 빈도를 해시맵에 저장
  - 우선순위 큐에 빈도수를 기준으로 정렬하여 추가
  - 큐에서 문자를 꺼내면서 빈도수만큼 문자열에 추가

---

## 🧪 예제 테스트

| s       | 기대 출력     |
|--------|---------------|
| "tree" | "eert" 또는 "eetr" |
| "cccaaa" | "aaaccc" 또는 "cccaaa" |
| "Aabb" | "bbAa" 또는 "bbaA" |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n log n) (우선순위 큐 정렬)
- **공간복잡도**: O(n) (해시맵과 큐 사용)

---

## ✅ 최종 정리

- 문자열에서 빈도수가 높은 문자부터 정렬하여 출력하는 문제
- 해시맵으로 빈도수를 관리하고, 우선순위 큐로 정렬하여 효율적으로 해결
- 우선순위 큐를 사용하여 정렬의 복잡도를 줄임