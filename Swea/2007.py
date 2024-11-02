# t = int(input())
# l = 0

# for i in range(t):
#   arr = input()

#   li = arr[0:1]
#   l = len(li)
#   arr = arr[l:]
#   sub = ""

#   while(1):
#     index = arr.find(li)
#     if(len(arr)<=l):
#       break
#     if(index == 0):
#       sub += arr[:l]
#       arr = arr[l:]
#     else:
#       li = li + sub + arr[:index]
#       arr = arr[index:]
#       l = len(li)

#   print("#" , (i+1) ," ", len(li) , sep = "")

T = int(input())

for test_case in range(1, T + 1):
    a = list(input())
    s = 0
    answer = 0
    
    for j in range(1, 10):
        if a[0] != a[j] or a[1] != a[j +1]:
            s += 1
        else:
            break

    answer = s + 1
    print("#%d" %test_case, answer)