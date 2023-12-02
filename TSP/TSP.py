import math
import heapq

# 초기화
heap = []
points = [[0, 3], [7, 5], [6, 0], [4, 3], [1, 0], [5, 3], [2, 2], [4, 1]]
num_vertices, num_edges = len(points), len(points) * (len(points) - 1) // 2
adjacency_list = [[] for _ in range(num_vertices)]  # 정점의 이웃 정보를 저장하는 리스트
minimum_spanning_tree = []  # 최소 신장 트리를 구성하는 간선들의 리스트

# 거리 계산 함수
def calculate_distance(a, b): # 두점사이의 거리를 계산함
    x1, x2 = a[0], b[0]
    y1, y2 = a[1], b[1]
    distance = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
    return distance

# 방문 순서 설정 함수 # 재귀함수 사용
 def set_visit_order(start): # 0에서 시작해서 다음점과 연결된 점들을 찾고 경로를 설정함
    l = len(minimum_spanning_tree)
    for _ in range(l):
        for tree in minimum_spanning_tree:
            if tree[0] == start:
                MST.append(tree[1])
                minimum_spanning_tree.remove(tree)
                set_visit_order(tree[1])
                break
            elif tree[1] == start:
                MST.append(tree[0])
                minimum_spanning_tree.remove(tree)
                set_visit_order(tree[0])
                break

# 간선의 사이클 여부 확인 함수
def is_cycle(s, e, visited):
    visited.append(s)
    if e in adjacency_list[s]:
        return True
    for neighbor in adjacency_list[s]:
        if neighbor not in visited:
            if is_cycle(neighbor, e, visited):
                return True
    return False

# 각 점사이의 거리 계산 및 heap 초기화
distances = []
for i in range(len(points)):
    for j in range(i + 1, len(points)):
        distances.append((calculate_distance(points[i], points[j]), i, j))

for i in range(len(distances)):
    heapq.heappush(heap, distances[i])

# 최소 신장 트리 생성
for i in range(num_edges):
    edge = heapq.heappop(heap)
    start, end = edge[1], edge[2]
    visited = []
    if not is_cycle(start, end, visited):
        adjacency_list[start].append(end)
        adjacency_list[end].append(start)
        minimum_spanning_tree.append([start, end])
        if len(minimum_spanning_tree) == num_vertices - 1:
            break

MST = [0]

set_visit_order(0) # 방문 순서 결정
total_distance = 0
index = 0
for i in MST: # 결정된 방문 순서에 따른 점사이의 거리 합산
    index = (index + 1) % len(MST) 
    j = MST[index]
    total_distance += calculate_distance(points[i], points[j])

print("Visit Order:", MST)
print("Total Distance:", total_distance)
