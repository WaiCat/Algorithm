t = int(input())

for i in range(t):
  sum = 0
  n = int(input())
  cost = list(map(int, input().split()))
  max = 0
  for j in cost[::-1]:
    if(j > max):
      max = j
    else:
      sum +=(max-j)

  print("#" , (i+1) ," ", sum , sep = "")