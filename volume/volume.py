import os
import csv
import numpy as np
import time

def read_csv_file(file_path):
    with open(file_path, 'r', newline='', encoding='utf-8') as csvfile:
        csv_reader = csv.reader(csvfile, skipinitialspace=True)
        # 첫 번째 행을 건너뜁니다.
        next(csv_reader)
        return [list(map(float, row)) for row in csv_reader]

def calculate_determinant(combination):
    tmp = np.array(combination)
    tmp_t = np.transpose(tmp)
    return np.sqrt(abs(np.linalg.det(np.dot(tmp, tmp_t))))

# def combination(i, data):
#     max_determinant_value = 0
#     for j in range(len(data[0]) - i + 1):  # 수정: range 조건 변경
#         combinations_result = data[j:j+i]  # 수정: 배열 슬라이싱 변경
#         det_value = calculate_determinant(combinations_result)
#         max_determinant_value = max(max_determinant_value, det_value)
#     return max_determinant_value

# 현재 스크립트 파일의 폴더 경로
current_script_directory = os.path.dirname(os.path.abspath(__file__))
# 파일 경로 설정
file_path = os.path.join(current_script_directory, 'input.csv')  # 수정: 경로 조인

# CSV 파일 읽기
csv_data = np.array(read_csv_file(file_path))
csv_data = np.transpose(csv_data)

start_time = time.time()  # 시작 시간 기록

row_sums = [(i, sum(row)) for i, row in enumerate(csv_data)]

# Implementing Bubble Sort
# n = len(row_sums)
# for i in range(n):
#     for j in range(0, n-i-1):
#         if abs(row_sums[j][1]) > abs(row_sums[j+1][1]):
#             # Swap rows
#             row_sums[j], row_sums[j+1] = row_sums[j+1], row_sums[j]

# # Create a new array sorted by the original order of rows
# sort_arrays_by_sum = [csv_data[i] for i, _ in row_sums]
# sort_arrays_by_sum = np.array(sort_arrays_by_sum)


# 배열의 합을 기준으로 정렬
# sort_arrays_by_sum(csv_data)

# 최종 결과 계산
# final_result = combination(19, csv_data)


# 최댓값을 가진 행을 추출
max_row = []
for i in range(19):
    max_index = np.argmax(csv_data[:, i])
    max_row.append(csv_data[max_index, :])

final_result = calculate_determinant(max_row)

end_time = time.time()  # 종료 시간 기록
elapsed_time = end_time - start_time  # 경과 시간 계산

print(f"코드 실행 시간: {elapsed_time} 초")
print(f"최대 행렬식 값: {final_result}")
