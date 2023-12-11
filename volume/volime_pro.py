import pandas as pd
import numpy as np
import time

# 실행 시간 측정을 위한 시작 시간 기록
start_time = time.time()

# 파일 경로 지정
file_path = "./volume/input.csv"
# CSV 파일을 가져와서 전치
input_data = pd.read_csv(file_path).values.T

# 이미 선택된 행의 인덱스를 저장하는 집합
selected_indices = set()

# 현재까지 선택된 행렬들을 저장하는 리스트 (사용하지 않는 부분이 있음)
selected_matrices = []

# 최대 행렬식 값과 해당 행의 인덱스 초기화
max_det_value = -1
max_index = -1

# 주어진 횟수만큼 반복
for iteration in range(20):
    # 현재 반복에서의 최대 행렬식 값을 저장하는 변수 초기화
    current_max_det = max_det_value
    
    # 모든 행 중에서 선택되지 않은 행에 대해 반복
    for j in range(10000):
        if j not in selected_indices:
            # 선택된 행 추가
            current_indices = list(selected_indices) + [j]
            
            # 현재 선택된 행들로 새로운 행렬 생성
            current_matrix = input_data[current_indices]

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
        max_det_value = current_max_det

# 실행 시간 측정을 위한 끝 시간 기록
end_time = time.time()

# 결과 출력
print(f'코드 실행 시간: {end_time - start_time} 초')
print(f"최대 행렬식 값: {max_det_value}")
