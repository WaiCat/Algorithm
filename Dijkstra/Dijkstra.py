import sys
import time

start = time.time()  # 실행 시작 시간 기록

max_value = sys.maxsize  # 무한대 값으로 사용할 최대 정수값

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
    u, v, w = i
    edge[u][v] = edge[v][u] = w

# Dijkstra 알고리즘 수행
for k in range(num_nodes):
    distances = [max_value] * num_nodes # 가중치 배열 초기화
    distances[k] = 0 # 시작 노드 선정
    visited = [False] * num_nodes # 방문 노드 배열

    for _ in range(num_nodes):
        min_dist = max_value
        index = -1

        for i in range(num_nodes):  # 최소 거리를 가진 노드를 찾음
            if not visited[i] and distances[i] < min_dist:
                index = i
                min_dist = distances[i]

        visited[index] = True # 최소 노드 방문

        for i in range(num_nodes):  # 최소 노드에 연결된 노드로 가중치 갱신
            if not visited[i] and edge[index][i] != max_value:
                distances[i] = min(distances[i], min_dist + edge[index][i])

    for i in range(k + 1):
        distances[i] = ''
    print(distances)  # 시작 노드에서 다른 모든 노드까지의 거리를 출력

end = time.time() # 실행 종료 시간 기록
print("실행 시간:", (end - start)) #실행시간 출력