t = int(input())

for i in range(t):
    n = int(input())
    price = list(map(int, input().split()))

    sell_price = []

    common = []
    for k in range(n*2):
        p = price[k]
        if(p in common):
            common.remove(p)
        else:
            common.append(p//3 * 4)
            sell_price.append(p)

    print("#", (i+1), " ", " ".join(map(str, sell_price)), sep="")