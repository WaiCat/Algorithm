t = int(input())

for i in range(t):
    a, b = map(int, input().split())
    count = 0
    k = b-a
    if(k < 0 or k == 1):
        count = -1
    else:
        count += k // 2

    print("#", (i+1), " ", count, sep="")