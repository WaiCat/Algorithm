## 🧠 알고리즘 문제 코드 분석 - Jewels and Stones

## 📌 문제 요약
- **문제 이름**: [Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)
- **문제 유형**: 문자열, 해시맵
- **난이도**: Easy
- **요구사항 요약**:
  - 문자열 `jewels`는 보석의 종류를 나타냄
  - 문자열 `stones`는 내가 가진 모든 돌을 나타냄
  - 보석에 해당하는 돌이 `stones`에 몇 개 있는지 세어 반환

---

## 📥 입력 & 출력 예시

### 입력 예시
```java
jewels = "aA", stones = "aAAbbbb"
```

### 출력 예시
```java
3
```

---

## 🔍 접근 방식

- **입력 크기 분석**: 최대 50 → O(n) 가능
- **알고리즘 선택**: 해시맵
- **이유**: 문자 빈도 수를 빠르게 조회하기 위해
- **핵심 아이디어**:
  - `stones`의 문자 빈도를 해시맵에 저장
  - `jewels`의 문자를 기준으로 `stones`에서 몇 번 나왔는지 합산

---

## 💻 핵심 코드 분석

```java
public static int numJewelsInStones(String jewels, String stones) {
    Map<Character, Integer> mapJ = new HashMap<>();
    Map<Character, Integer> mapS = new HashMap<>();

    for (char c : jewels.toCharArray()) {
        mapJ.put(c, mapJ.getOrDefault(c, 0) + 1);
    }

    for (char c : stones.toCharArray()) {
        mapS.put(c, mapS.getOrDefault(c, 0) + 1);
    }

    int sum = 0;
    for (char c : mapJ.keySet()) {
        if (mapS.containsKey(c)) {
            sum += mapS.get(c);
        }
    }

    return sum;
}
```

- **설명**:
  - `mapJ`는 보석 목록에서 사용되지만, 단순 존재 여부만 필요 → Set으로 최적화 가능
  - `mapS`는 각 돌 문자의 개수를 세기 위한 카운터
  - 결과는 보석 문자에 해당하는 돌 개수의 총합

---

## 🧪 예제 테스트

| jewels | stones | 기대 출력 |
|--------|--------|-------------|
| `"aA"` | `"aAAbbbb"` | `3` |
| `"z"` | `"ZZ"` | `0` |

---

## 📝 시간복잡도 및 공간복잡도

- **시간복잡도**: O(n + m)
- **공간복잡도**: O(n + m) (HashMap 저장용)

---

## ✅ 최종 정리

- 보석에 해당하는 돌의 개수를 세는 간단한 해시맵 활용 문제
- 보석 정보를 Set으로 처리하면 공간과 시간 모두 약간 최적화 가능