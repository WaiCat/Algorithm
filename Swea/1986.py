t = int(input())

arr = [1]

for i in range(t):
  n = int(input())
  for j in range(len(arr), n+1):
    if(j==1):
      arr.append(1)
      continue
    if(j%2 == 0):
      arr.append(arr[j-1]-j)
    else:
      arr.append(arr[j-1]+j)

  print("#", (i+1), " ", arr[n], sep="")