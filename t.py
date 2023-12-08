import pandas as pd
import numpy as np
import time

def calculate_sum(row):
    size = np.dot(row, np.transpose(row))
    det = np.sqrt(abs(np.linalg.det(size)))
    return det

def quick_sort(arrays, key_func):
    if len(arrays) <= 1:
        return arrays
    else:
        pivot = arrays[0]
        less = [x for x in arrays[1:] if key_func(x) <= key_func(pivot)]
        greater = [x for x in arrays[1:] if key_func(x) > key_func(pivot)]
        return quick_sort(less, key_func) + [pivot] + quick_sort(greater, key_func)

def sort_with_key(matrix, key_func):
    # 각 행에 대해 key_func 함수를 사용하여 계산된 키 값을 기준으로 정렬
    sorted_matrix = quick_sort(matrix, key_func)
    return np.array(sorted_matrix)

start_time = time.time()

file_path = "volume/input.csv"
csv_data = pd.read_csv(file_path)
matrix = np.transpose(np.array(csv_data))

# 키 함수를 사용하여 정렬
sorted_matrix = sort_with_key(matrix, key_func=calculate_sum)

# 정렬된 행렬을 필요에 맞게 출력하거나 사용하세요
print(sorted_matrix)

elapsed_time = time.time() - start_time
print(f"소요 시간: {elapsed_time} 초")
