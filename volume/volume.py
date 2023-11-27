import csv

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

# 파일 경로 설정
file_path = 'C:\\Users\\Administrator\\Downloads\\University\\3학년 2학기\\Algorithm\\volune\\input.csv'

# CSV 파일 읽기
csv_data = read_csv_file(file_path)

# 행열을 반대로 저장
transposed_data = transpose_matrix(csv_data)

# 결과 출력
for row in transposed_data:
    
    print(row)
