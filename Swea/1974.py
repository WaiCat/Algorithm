t = int(input())

def is_valid_matrix(matrix):
    expected_set = set(range(1, 10))
    
    flat_matrix_set = set()
    for row in matrix:
        flat_matrix_set.add(row)
    
    return flat_matrix_set == expected_set

def transpose(matrix):
    return [list(row) for row in zip(*matrix)]

for i in range(t):
  arr = [list(map(int, input().split())) for _ in range(9)]
  
  result = 1
  for j in range(9):
    if not is_valid_matrix(arr[j]):
      result = 0
      break

  if(result == 1):
    tarr = transpose(arr)
    for j in range(9):
      if not is_valid_matrix(tarr[j]):
        result = 0
        break

  if(result == 1):
    matrix = []
    for k in range(0, 9, 3):
        for j in range(0, 9, 3):
            block = [num for row in arr[k:k+3] for num in row[j:j+3]]
            matrix.append(block)
    for j in range(9):
      if not is_valid_matrix(matrix[j]):
        result = 0
        break
    
  print("#", (i+1), " ", result, sep="")