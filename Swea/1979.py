t = int(input())

for i in range(t):
  n, k = map(int, input().split())
  arr = [list(map(int, input().split())) for _ in range(n)]

  count = 0
  for col in range(n):
    l = 0
    for row in range(n):
      if(arr[col][row] == 1):
        l += 1
      else:
        if(l==k):
          count += 1
        l = 0
    if(l==k):
      count += 1

  for col in range(n):
    l = 0
    for row in range(n):
      if(arr[row][col] == 1):
        l += 1
      else:
        if(l==k):
          count += 1
        l = 0
    if(l==k):
      count += 1

  print("#", (i+1), " ", count, sep="")