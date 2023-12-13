def find_duplicate_index(arr, n):
    value = arr[n]
    try:
        duplicate_index = arr.index(value, 0, n)  # n 이전 부분에서 중복 찾기
        return duplicate_index
    except ValueError:
        try:
            duplicate_index = arr.index(value, n + 1)  # n 이후 부분에서 중복 찾기
            return duplicate_index
        except ValueError:
            return False

# 예제 사용
my_list = [1, 2, 3, 4, 5, 1, 6, 1, 7]
n = 5# 예를 들어, 배열에서 2번째 값은 3입니다.

first_duplicate_index = find_duplicate_index(my_list, n)

if first_duplicate_index is not None:
    print(f"{n}번째 값과 중복된 값의 첫 번째 인덱스는 {first_duplicate_index}입니다.")
else:
    print(f"{n}번째 값에 중복된 값이 없습니다.")
