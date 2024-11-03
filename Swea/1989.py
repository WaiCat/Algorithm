t = int(input())

for i in range(t):
  arr = input()
  l = arr[:(len(arr)//2)]
  l = l[::-1]
  arr = arr[(len(arr)//2):]

  if(l in arr):
    print("#" , (i+1), " 1",  sep="")
  else:
    print("#" , (i+1), " 0",  sep="")