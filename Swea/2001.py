t = int(input())

for i in range(t):
  n, m= map(int,input().split())
  arr = [list(map(int, input().split())) for _ in range(n)]
  
  max_sum = 0
  current_sum = 0
  for j in range(m):
    for k in range(m):
      current_sum += arr[j][k]
  max_sum = current_sum

  for j in range(-1, n-m):
    if(j!=-1):
      for a in range(m):
        current_sum -= arr[j][a]
        current_sum += arr[j+m][a]
      max_sum = max(current_sum , max_sum)
    bcurrent_sum = current_sum
    for k in range(0, n-m):
      for a in range(m):
        bcurrent_sum -= arr[j+1+a][k]
        bcurrent_sum += arr[j+1+a][k+m]
      max_sum = max(bcurrent_sum , max_sum)

  print("#" , (i+1), " ", max_sum,  sep="")