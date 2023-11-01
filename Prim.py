start_vertex, num_vertices, num_edges = map(int, input().split())

edges = []  # 간선 정보를 저장하는 리스트
adjacency_list = [[] for _ in range(num_vertices)]  # 인접 리스트
minimum_spanning_tree = []

# 간선 정보 입력
for _ in range(num_edges):
    start, end, weight = map(int, input().split())
    edges.append((start, end, weight))
    adjacency_list[start].append((start, end, weight))
    adjacency_list[end].append((end, start, weight))
    
visited_vertices = [start_vertex]
sorted_edges = sorted(adjacency_list[start_vertex], key=lambda x: x[2])

while num_vertices > 1:
    next_vertex = sorted_edges[0][1]
    visited_vertices.append(next_vertex)
    num_vertices -= 1
    minimum_spanning_tree.append(sorted_edges[0])
    del sorted_edges[0]
    
    for edge in adjacency_list[next_vertex]:
        if edge[1] not in visited_vertices:
            for i, existing_edge in enumerate(sorted_edges):
                if existing_edge[1] == edge[1]:
                    if existing_edge[2] > edge[2]:
                        sorted_edges[i] = edge
                        break
            else:
                sorted_edges.append(edge)
    sorted_edges.sort(key=lambda x: x[2])

print(minimum_spanning_tree)
