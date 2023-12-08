import pandas as pd
import numpy as np
import time

def find_max_determinant(matrix):
    max_value = -1
    max_indexs = []
    max_rows = []

    for _ in range(20):
        find_max_index = -1
        find_max_value = max_value

        for j in range(10000):
            if j not in max_indexs:
                tmp_rows = max_rows.copy()
                tmp_rows.insert(0, matrix[j])
                arr = np.array(tmp_rows)
                print(arr)
                size = np.dot(arr, np.transpose(arr))
                det = np.sqrt(abs(np.linalg.det(size)))

                if det > find_max_value:
                    find_max_value = det
                    find_max_index = j

        if find_max_index != -1:
            max_indexs.insert(0, find_max_index)
            max_rows.insert(0, matrix[find_max_index])
            max_value = find_max_value

    return max_value

start_time = time.time()

file_path = "volume/input.csv"
csv_data = pd.read_csv(file_path)
matrix = np.transpose(np.array(csv_data))

max_determinant = find_max_determinant(matrix)

end_time = time.time()
elapsed_time = (end_time - start_time)

print("소요된 시간: {:.2f} 초".format(elapsed_time))
print("최대 값: {:.2f}".format(max_determinant))