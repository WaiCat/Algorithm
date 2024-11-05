t = int(input())

for i in range(t):
  arr = list(map(int, input().split()))

  result = (sum(arr) - max(arr) - min(arr))/8
  result = int(round(result, 0))

  print("#", (i+1), " ", result, sep="")