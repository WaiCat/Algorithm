import sys

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



for k in range(num_nodes):

    distances = [max_value] * num_nodes  # 모든 노드에 대한 거리를 무한대로 초기화
    distances[k] = 0  # 시작 노드까지의 거리를 0으로 설정
    visited = [False] * num_nodes  # 방문한 노드를 추적하기 위한 목록 초기화

    def check():
        return any(not visited[i] for i in range(num_nodes))  # 방문하지 않은 노드가 있는지 확인

    def min_distance():
        min_dist = max_value
        index = -1

        for i in range(num_nodes):
            if not visited[i] and distances[i] < min_dist:
                index = i
                min_dist = distances[i]
        return min_dist, index  # 최소 거리를 가진 노드를 찾음

    while check():
        min_dist, index = min_distance()  # 최소 거리를 가진 노드를 찾음
        visited[index] = True  # 해당 노드를 방문한 것으로 표시

        for edge in edges:
            if edge[0] == index:
                distances[edge[1]] = min(distances[edge[1]], min_dist + edge[2])  # 거리를 업데이트
            if edge[1] == index:
                distances[edge[0]] = min(distances[edge[0]], min_dist + edge[2])  # 거리를 업데이트

    for i in range(k+1):
        distances[i] = ' '  # 시작 노드 이전의 노드에 대한 자리 표시자
    print(distances)  # 시작 노드에서 다른 모든 노드까지의 거리를 출력
