import pandas as pd
import numpy as np
import time

start_time = time.time()

# 파일 경로 지정
file_path = "./volume/input.csv"
# CSV 파일을 가져와서 전치
input_data = pd.read_csv(file_path).values.T  

selected_indices = set()
selected_matrices = []

max_det_value = -1
max_index = -1

# 주어진 횟수만큼 반복
for iteration in range(20):
    current_max_det = max_det_value
    for j in range(10000):
        if j not in selected_indices:
            # 선택된 행렬에 현재 행 추가
            current_matrix = selected_matrices.copy()
            current_matrix.append(input_data[j])
            current_matrix = np.array(current_matrix)
            
            # 행렬의 내적 계산
            dot_value = np.dot(current_matrix, current_matrix.T)
            # 행렬식 계산
            determinant = abs(np.linalg.det(dot_value)) ** 0.5
            
            # 최대 행렬식 값 갱신
            if determinant > current_max_det:
                current_max_det = determinant
                max_index = j

    # 선택된 행 추가 및 최대 행렬식 값 갱신
    if max_index != -1:
        selected_indices.add(max_index)
        selected_matrices.append(input_data[max_index])
        max_det_value = current_max_det

end_time = time.time()

# 결과 출력
print(f'코드 실행 시간: {end_time - start_time} 초')
print(f"최대 행렬식 값: {max_det_value}")
