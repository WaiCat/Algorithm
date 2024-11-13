t = int(input())

for i in range(t):
  n = int(input())
  arr = [[1] * n for _ in range(n)]
  s = "1"
  for j in range(1, n):
    s += "\n1 "
    for k in range(1, j):
      arr[j][k] = arr[j-1][k-1] + arr[j-1][k]
      s += str(arr[j][k]) + " "
    s += "1"

  print("#" , (i+1), sep="")
  print(s)