t = int(input())

for _ in range(t):
  n = int(input())
  arr = [list(map(int, input().split())) for _ in range(n)]

  transpose_num = 0
  for i in range(n, 1, -1):
    if(arr[0][i-1] == i):
      if(transpose_num % 2 != 0):
        transpose_num+=1
    else:
      if(transpose_num % 2 == 0):
        transpose_num+=1

  print(transpose_num)