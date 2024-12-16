t = int(input())

for _ in range(t):
  n = int(input())
  arr = ""

  if(n%3==2):
    arr = "BA"
    for _ in range(n//3):
      arr += "BBA"
  elif(n%3==0):
    for _ in range(n//3):
      arr += "BBA"
  else:
      arr = "impossible"

  print(arr)