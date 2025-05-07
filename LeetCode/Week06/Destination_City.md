## 🧠 알고리즘 문제 코드 분석 - Destination City

## 📌 문제 요약
- **문제 이름**: [Destination City](https://leetcode.com/problems/destination-city/)
- **문제 유형**: 문자열, 집합(Set)
- **난이도**: Easy
- **요구사항 요약**:
  - 경로 리스트가 주어졌을 때, 최종 목적지를 반환
  - 목적지는 **다른 경로의 출발지로 사용되지 않는 도시**

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
paths = [["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]]
```

### 출력 예시
```java
"Sao Paulo"
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 100 → O(n) 가능
- **알고리즘 선택**: HashSet
- **이유**: 출발지와 목적지를 각각 관리하여, 교집합이 없는 도시를 찾기 위함
- **핵심 아이디어**:
  - 출발 도시를 Set에 저장
  - 목적지 도시를 Set에 저장
  - 목적지 Set에서 출발 도시를 제거하여 남은 하나가 최종 목적지

---

## 💻 핵심 코드 분석

```java
public static String destCity(List<List<String>> paths) {
    Set<String> start = new HashSet<>();
    Set<String> end = new HashSet<>();

    for (List<String> path : paths) {
        start.add(path.get(0));
        end.add(path.get(1));
    }

    for (String e : end) {
        if (!start.contains(e)) {
            return e;
        }
    }

    return "";
}
```

- **설명**:
  - 출발지와 목적지를 각각 Set으로 관리
  - 목적지 Set에서 출발지에 포함되지 않는 요소를 반환

---

## 🧪 예제 테스트

| paths | 기대 출력 |
|------|-------------|
| `[["London", "New York"], ["New York", "Lima"], ["Lima", "Sao Paulo"]]` | `"Sao Paulo"` |
| `[["B", "C"], ["D", "B"], ["C", "A"]]` | `"A"` |
| `[["A", "Z"]]` | `"Z"` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (Set 사용)

---

## ✅ 최종 정리

- 출발지와 목적지의 차집합을 구하는 것이 핵심
- 목적지 Set에서 출발지 Set에 없는 요소를 반환하면 문제 해결
- Set을 이용하여 중복과 탐색을 효율적으로 처리