import os
import csv
import numpy as np
import time

def read_csv_file(file_path):
    with open(file_path, 'r', newline='', encoding='utf-8') as csvfile:
        csv_reader = csv.reader(csvfile, skipinitialspace=True)
        # 첫 번째 행을 건너뜁니다.
        next(csv_reader)
        return [row for row in csv_reader]

def calculate_determinant(combination):
    tmp = np.array(combination)
    tmp_t = np.transpose(tmp)
    return np.sqrt(abs(np.linalg.det(np.dot(tmp, tmp_t))))

def combination(i, data):
    max_determinant_value = 0
    for j in range(len(data) - i + 1):  # 수정: range 조건 변경
        combinations_result = data[j:j+i]
        det_value = calculate_determinant(combinations_result)
        max_determinant_value = max(max_determinant_value, det_value)
    return max_determinant_value

# 현재 스크립트 파일의 폴더 경로
current_script_directory = os.path.dirname(os.path.abspath(__file__))
# 파일 경로 설정
file_path = os.path.join(current_script_directory, 'input.csv')  # 수정: 경로 조인

# CSV 파일 읽기
csv_data = np.array(read_csv_file(file_path), dtype=float)
csv_data = np.transpose(csv_data)

start_time = time.time()  # 시작 시간 기록

def merge_sort(arrays, start, end):
    if start < end:
        mid = (start + end) // 2

        merge_sort(arrays, start, mid)
        merge_sort(arrays, mid + 1, end)

        merge(arrays, start, mid, end)

def merge(arrays, start, mid, end):
    left_size = mid - start + 1
    right_size = end - mid

    left_sum = [sum(arrays[start + i]) for i in range(left_size)]
    right_sum = [sum(arrays[mid + 1 + j]) for j in range(right_size)]

    i = j = 0
    k = start

    while i < left_size and j < right_size:
        if left_sum[i] <= right_sum[j]:
            arrays[k] = arrays[start + i]
            i += 1
        else:
            arrays[k] = arrays[mid + 1 + j]
            j += 1
        k += 1

    while i < left_size:
        arrays[k] = arrays[start + i]
        i += 1
        k += 1

    while j < right_size:
        arrays[k] = arrays[mid + 1 + j]
        j += 1
        k += 1

def sort_arrays_by_sum(arrays):
    merge_sort(arrays, 0, len(arrays) - 1)


# 배열의 합을 기준으로 정렬
sort_arrays_by_sum(csv_data)

# 최종 결과 계산
final_result = combination(19, csv_data)

end_time = time.time()  # 종료 시간 기록
elapsed_time = end_time - start_time  # 경과 시간 계산

print(f"코드 실행 시간: {elapsed_time} 초")
print(f"최대 행렬식 값: {final_result}")
