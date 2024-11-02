n = int(input())
clapnum = [3,6,9]
answer = ""

for i in range(1, n+1):
  number = ""
  clap = ""
  while(i != 0):
    j = i%10
    i //= 10
    if(j in clapnum):
      clap += "-"
    else:
      number = str(j) + number
  
  if(clap == ""):
    answer += number + " "
  else:
    answer += clap + " "

print(answer)