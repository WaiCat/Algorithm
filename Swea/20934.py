t = int(input())

for i in range(t):
    s, k = input().split()
    s = list(s)
    k = int(k)

    o_index = s.index("o")
    if(k%2 == 0):
        if(k==0):
            result = o_index
        else:
            if(o_index == 1):
                result = 1
            else:
                result = 0
    else:
        if (o_index == 1):
            result = 0
        else:
            result = 1

    print("#", (i+1), " ", result, sep="")