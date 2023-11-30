import math
import heapq

heap = []

points = [[0, 3], [7, 5], [6, 0], [4, 3], [1, 0], [5, 3], [2, 2], [4, 1]]

def calculate_distance(x1, y1, x2, y2):
    distance = math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    return distance

def set_visit_order(start):
    while minimum_spanning_tree is not None:
        for tree in minimum_spanning_tree:
            if(tree[0] == start):
                MST.append(tree[1])
                set_visit_order(tree[1])
                break
                
            elif(tree[1]== start):
                MST.append(tree[0])
                set_visit_order(tree[0])
                break

distances = []


for i in range(len(points)):
    for j in range(i+1, len(points)):
        distances.append((calculate_distance(points[i][0], points[i][1], points[j][0], points[j][1]), i, j))

num_vertices, num_edges = len(points), len(distances)

for i in range(len(distances)):
    heapq.heappush(heap , distances[i])

adjacency_list = [[] for _ in range(num_vertices)]
minimum_spanning_tree = []

def is_cycle(s, e, visited):
    visited.append(s)
    if e in adjacency_list[s]:
        return True
    for neighbor in adjacency_list[s]:
        if neighbor not in visited:
            if is_cycle(neighbor, e, visited):
                return True
    return False

for i in range(num_edges):
    edge = heapq.heappop(heap)
    start = edge[1]
    end = edge[2]
    visited = []
    if not is_cycle(start, end, visited):
        adjacency_list[start].append(end)
        adjacency_list[end].append(start)
        minimum_spanning_tree.append([start, end])
        if len(minimum_spanning_tree) == num_vertices - 1:
            break

MST = [0]

set_visit_order(0)

print(MST)