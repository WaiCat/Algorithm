import pandas as pd
import numpy as np
import time

start_time = time.time()

file_path = "./volume/input.csv"
input_data = pd.read_csv(file_path).values.T  

selected_indices = set()
selected_matrices = []

max_det_value = -1
max_index = -1

for iteration in range(20):
    current_max_det = max_det_value
    for j in range(10000):
        if j not in selected_indices:
            current_indices = list(selected_indices) + [j]
            current_matrix = input_data[current_indices]

            dot_value = np.dot(current_matrix, current_matrix.T)
            determinant = abs(np.linalg.det(dot_value)) ** 0.5
            
            if determinant > current_max_det:
                current_max_det = determinant
                max_index = j

    if max_index != -1:
        selected_indices.add(max_index)
        max_det_value = current_max_det

end_time = time.time()

print(f'코드 실행 시간: {end_time - start_time} 초')
print(f"최대 행렬식 값: {max_det_value}")