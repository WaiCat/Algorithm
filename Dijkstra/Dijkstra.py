import sys

maxi = sys.maxsize

g = [10, 14]
e = [[0,1,15],
        [1,2,21],
        [0,3,12],
        [3,4,4],
        [3,5,10],
        [4,5,3],
        [5,6,10],
        [1,6,7],
        [2,7,25],
        [6,7,19],
        [4,8,13],
        [8,9,15],
        [6,9,9],
        [7,9,5]]


d = [maxi for _ in range(g[0])]
d[0] = 0

def check():
    for i in range(g[0]):
        if(not passd[i]):
            return True
    return False
    
passd = [False for _ in range(g[0])]
passd[0] = True

def minv():
    m = maxi
    index = -1
    
    for i in range(g[0]):
        if(not passd[i]):
            if(d[0] < m):
                index = i
                m = d[0]
    return m, index
            

while(check()):
    m, index = minv()
    passd[index] = True
    
    
