for i in range(10):
    n = int(input())
    buling = list(map(int, input().split()))

    result = 0
    for k in range(2, n-2):
        m = max(buling[k-1], buling[k-2], buling[k+1], buling[k+2])
        if(buling[k] > m):
            result += buling[k]-m

    print("#", (i+1), " ", result, sep="")