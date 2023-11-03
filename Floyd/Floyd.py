import sys
import time

start = time.time()

max_value = sys.maxsize

num_nodes = 10  # 그래프의 노드 수
graph = [10, 14] 
edges = [
    [0, 1, 15], 
    [1, 2, 21],
    [0, 3, 12],
    [3, 4, 4],
    [3, 5, 10],
    [4, 5, 3],
    [5, 6, 10],
    [1, 6, 7],
    [2, 7, 25],
    [6, 7, 19],
    [4, 8, 13],
    [8, 9, 15],
    [6, 9, 9],
    [7, 9, 5]
]   

# 간선 가중치를 저장할 2D 배열을 최댓값으로 초기화
edge = [[max_value] * num_nodes for _ in range(num_nodes)]

# 간선 가중치를 인접 행렬에 할당
for i in edges:
    edge[i[0]][i[1]] = i[2]
    edge[i[1]][i[0]] = i[2]

# Floyd-Warshall 알고리즘 수행
for i in range(num_nodes):
    for j in range(i, num_nodes):
        for k in range(num_nodes):
            if i != j and i != k and j != k:
                edge[i][j] = min(edge[i][j], edge[i][k] + edge[k][j])
    
                

# 상삼각행렬과 대각선 요소를 공백으로 설정
for i in range(num_nodes):
    for j in range(i + 1):
        edge[i][j] = ' '
    print(edge[i])

end = time.time()

# 걸린 시간 출력
print("소요 시간:", end - start)