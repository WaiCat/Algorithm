def flatten_3x3_blocks(matrix):
    blocks = []
    # 각 3x3 블록을 추출하고 평탄화
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            # 3x3 블록을 추출하고 평탄화
            flattened_block = [num for row in matrix[i:i+3] for num in row[j:j+3]]
            blocks.append(flattened_block)
    return blocks

# 예시: 9x9 행렬
matrix = [
    [1, 2, 3, 4, 5, 6, 7, 8, 9],
    [4, 5, 6, 7, 8, 9, 1, 2, 3],
    [7, 8, 9, 1, 2, 3, 4, 5, 6],
    [9, 1, 2, 3, 4, 5, 6, 7, 8],
    [3, 4, 5, 6, 7, 8, 9, 1, 2],
    [6, 7, 8, 9, 1, 2, 3, 4, 5],
    [8, 9, 1, 2, 3, 4, 5, 6, 7],
    [2, 3, 4, 5, 6, 7, 8, 9, 1],
    [5, 6, 7, 8, 9, 1, 2, 3, 4]
]

# 3x3 블록 추출 및 평탄화
flattened_blocks = flatten_3x3_blocks(matrix)

# 결과 출력
for index, block in enumerate(flattened_blocks):
    print(f"Flattened Block {index + 1}: {block}")
