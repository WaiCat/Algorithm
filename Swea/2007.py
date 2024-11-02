t = int(input())
l = 0

for i in range(t):
  arr = input()

  li = arr[0:1]
  l = len(li)
  arr = arr[l:]
  sub = ""

  while(1):
    index = arr.find(li)
    if(len(arr)<=l):
      break
    if(index == 0):
      sub += arr[:l]
      arr = arr[l:]
    else:
      li = li + sub + arr[:index]
      arr = arr[index:]
      l = len(li)

  print("#" , (i+1) ," ", len(li) , sep = "")