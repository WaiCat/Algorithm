## 🧠 알고리즘 문제 코드 분석 - Path Crossing

## 📌 문제 요약
- **문제 이름**: [Path Crossing](https://leetcode.com/problems/path-crossing/)
- **문제 유형**: 문자열, 해시셋
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `path`가 주어졌을 때,
  - 이동 경로가 **자기 자신과 교차**하는지 여부를 반환
  - 방향은 "N", "S", "E", "W"로 주어지며 각각 위, 아래, 오른쪽, 왼쪽 이동을 의미

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
path = "NESWW"
```

### 출력 예시
```java
true
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 10⁴ → O(n) 가능
- **알고리즘 선택**: HashSet
- **이유**: 경로를 좌표로 변환하여 Set에 저장, 중복 여부를 빠르게 확인
- **핵심 아이디어**:
  - 시작 위치를 (0,0)으로 설정
  - 경로를 따라 이동하면서 현재 좌표를 Set에 추가
  - 이미 방문한 좌표가 다시 나오면 교차로 간주하여 true 반환

---

## 💻 핵심 코드 분석

```java
public static boolean isPathCrossing(String path) {
    Set<String> visited = new HashSet<>();
    int high = 0, low = 0;
    visited.add("0,0");

    for (int i = 0; i < path.length(); i++) {
        if (path.charAt(i) == 'N') high++;
        else if (path.charAt(i) == 'S') high--;
        else if (path.charAt(i) == 'E') low++;
        else if (path.charAt(i) == 'W') low--;

        String point = high + "," + low;

        if (!visited.add(point)) {
            return true;
        }
    }
    return false;
}
```

- **설명**:
  - `visited`: 현재까지 방문한 좌표를 저장
  - 각 방향에 따라 좌표를 이동하고, 좌표를 문자열로 변환하여 Set에 추가
  - 중복된 좌표가 나타나면 교차로 판단

---

## 🧪 예제 테스트

| path  | 기대 출력 |
|------|-------------|
| `"NES"` | `false` |
| `"NESWW"` | `true` |
| `"NNSS"` | `true` |
| `"EW"` | `false` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n)
- **공간복잡도**: O(n) (방문 좌표 저장용 Set)

---

## ✅ 최종 정리

- 경로를 따라 이동하면서 방문 좌표를 Set으로 관리하여 중복 확인
- 좌표를 문자열로 변환하여 Set에 저장함으로써 간단하게 교차 여부를 판단
- Set의 add 메서드는 중복 시 false를 반환하므로 이를 이용한 효율적인 코드 작성