# 주어진 배열
matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]

# 각 행의 합을 계산하고 (행의 합, 해당 행)의 튜플로 구성된 리스트 생성
row_sums = [(sum(row), row) for row in matrix]

# 정렬을 직접 구현
def custom_sort(arr):
    n = len(arr)
    for i in range(n - 1):
        for j in range(0, n - i - 1):
            if arr[j][0] < arr[j + 1][0]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

# 정렬 함수 적용
custom_sort(row_sums)

# 정렬된 결과 출력
for _, row in row_sums:
    print(row)
