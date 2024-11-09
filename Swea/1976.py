t = int(input())

for i in range(t):
  ah, am, bh, bm = map(int, input().split())

  h = ((am + bm)//60 + ah + bh)
  m = (am + bm)%60
  if(h>12):
    h = h % 13 + 1

  print("#", (i+1), " ", h, " ", m, sep="")