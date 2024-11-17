t = int(input())

for i in range(t):
    n, k = map(int, input().split())
    k=k-1

    poket = list(map(int, input().split()))
    poket.sort()

    dif_min = poket[k] - poket[0]
    for j in range(n-k):
        dif_min = min(dif_min, poket[j+k] - poket[j])

    print("#", (i+1), " ", dif_min, sep="")