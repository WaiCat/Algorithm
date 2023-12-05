import os
import csv
import numpy as np
import itertools
import time

def read_csv_file(file_path):
    data = []
    with open(file_path, 'r', newline='', encoding='utf-8') as csvfile:
        csv_reader = csv.reader(csvfile, skipinitialspace=True)
        # 첫 번째 행을 건너뜁니다.
        next(csv_reader)
        for row in csv_reader:
            data.append(row)
    return data

def calculate_determinant(combination):
    tmp = np.array(combination)
    tmp_t = np.transpose(tmp)
    return np.sqrt(abs(np.linalg.det(np.dot(tmp_t, tmp))))

def combination(i,data):
    max_determinant_value = 0
    for j in range(len(data)-i):
        combinations_result = data[j:j+i]
        det_value = calculate_determinant(combinations_result)
        max_determinant_value = max(max_determinant_value, det_value)
    return max_determinant_value

# 현재 스크립트 파일의 폴더 경로
current_script_directory = os.path.dirname(os.path.abspath(__file__))
# 파일 경로 설정
file_path = current_script_directory + '\\input.csv'

# CSV 파일 읽기
csv_data = read_csv_file(file_path)

csv_data = np.array(csv_data)
csv_data = csv_data.astype(float)
csv_data = np.transpose(csv_data)

start_time = time.time()  # 시작 시간 기록

final_result = 0

for i in range(1000, 1500):
    final_result = combination(i, csv_data)

end_time = time.time()  # 종료 시간 기록
elapsed_time = end_time - start_time  # 경과 시간 계산

print(f"코드 실행 시간: {elapsed_time} 초")
print(final_result)
