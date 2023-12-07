import pandas as pd
import numpy as np
import time
from itertools import combinations 



def get_matrix(path):
    df = pd.read_csv(path) # Matrix Read 
    df = np.array(df).T # Matrix Transpose 
    return df

def find_max(mat):
    max_value = -1
    max_idx = list()
    max_li = list()
    for i in range(10000):
        if(len(max_idx) == 20):
            break
        find_max = -1
        find_max_value = max_value
        for j in range(10000):
            if j not in max_idx:
                tmp_li = max_li.copy()
                tmp_li.insert(0, mat[j])
                arr = np.array(tmp_li)
                size = np.dot(arr, arr.T)
                det = abs(np.linalg.det(size))
                det = det **(1/2)
                if det > find_max_value:
                    find_max_value = det 
                    find_max = j
        if find_max != -1:
            max_idx.insert(0, find_max)
            max_li.insert(0, mat[find_max])
            max_value = find_max_value
            print(max_value, max_idx)
            

    return max_value, max_idx, max_li

## 계산식
# arr = np.array(tmp_li)
# size = np.dot(arr, arr.T)
# det = abs(np.linalg.det(size))
# det = det **(1/2)

max_row = []

def calculate_determinant(combination):
    tmp = np.array(combination)
    tmp_t = np.transpose(tmp)
    return np.sqrt(abs(np.linalg.det(np.dot(tmp, tmp_t))))

if __name__ == "__main__":
    start = time.thread_time_ns()
    path = "volume/input.csv"
    mat = get_matrix(path)
    max_value, max_index, max_list = find_max(mat)
    max_list = np.array(max_list)
    for i in range(20):
        max_index = np.argmax(max_list[:, i])
        max_row.append(max_list[max_index, :])
    print(max_list)
    print(max_row)
    print(calculate_determinant(max_row))
    end = time.thread_time_ns()
    times = (end-start)/1000
    print(times)
    print(max_value / times)
    volume = 796727301049202.6
    print(max_value-volume)

