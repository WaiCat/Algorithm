t = int(input())

for i in range(t):
  s = list(input())
  e = list(input())

  reverse_bool = False
  front = 0
  back = len(e)-1

  for _ in range(len(e) - len(s)):
    
      if(reverse_bool):
        if(e[front] == "Y"):
          reverse_bool = False
        front += 1
      else:
        if(e[back] == "Y"):
          reverse_bool = True
        back -= 1

  result = e[front : (back+1)]
  if(reverse_bool):
    result.reverse()

  if(s == result):
    print("#", (i+1), " Yes", sep="")
  else:
    print("#", (i+1), " No", sep="")
