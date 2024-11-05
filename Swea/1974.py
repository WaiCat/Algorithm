t = int(input())

def is_valid_matrix(matrix):
    expected_set = set(range(1, 10))
    
    flat_matrix_set = set()
    for row in matrix:
        flat_matrix_set.update(row)
    
    return flat_matrix_set == expected_set

for i in range(t):
  arr = [list(map(int, input().split())) for _ in range(9)]
  
  result = 1
  for j in range(9):
    is_valid_matrix[arr[j]]
  
  if(result = 1):
    for k in range(9):
      false_list = [False] * 9
      for j in range(9):
        if(false_list[arr[j][k]]):
          result = 0
          break
        else:
          false_list[arr[j][k]] = True

  if(result = 1):
    for k in range(9):
      for j in range(9):
        false_list = [False] * 9
        if(false_list[arr[j][k]]):
          result = 0
          break
        else:
          false_list[arr[j][k]] = True
      



  print("#", (i+1), " ", result, sep="")