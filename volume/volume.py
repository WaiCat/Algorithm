import os
import csv
import numpy as np

def read_csv_file(file_path):
    data = []
    with open(file_path, 'r', newline='', encoding='utf-8') as csvfile:
        csv_reader = csv.reader(csvfile, skipinitialspace=True)
        # 첫 번째 행을 건너뜁니다.
        next(csv_reader)
        for row in csv_reader:
            data.append(row)
    return data

def transpose_matrix(matrix):
    return list(map(list, zip(*matrix)))

# 현재 스크립트 파일의 폴더 경로
current_script_directory = os.path.dirname(os.path.abspath(__file__))
# 파일 경로 설정
file_path = current_script_directory + '\\input.csv'

# CSV 파일 읽기
csv_data = read_csv_file(file_path)

max_value = []
for i in range(20):
    max_value.append(max(csv_data[i]))

hd = []

print(max_value)

for i in range(20):
    num =csv_data[i].index(max_value[i])
    tem = []
    for j in range(20):
        tem.append(csv_data[j][num])
    hd.append(tem)
    
print(hd)

hd = np.array(hd)
hd = hd.astype(float)
determinant_value = np.linalg.det(hd)

print(determinant_value)
# # 행열을 반대로 저장
# transposed_data = transpose_matrix(csv_data)

# # 결과 출력
# for row in transposed_data:
    
#     print(row)
