num_vertices, num_edges = map(int, input().split())

adjacency_list = [[] for _ in range(num_vertices)]
minimum_spanning_tree = []

edges = []
for _ in range(num_edges):
    start, end, weight = map(int, input().split())
    edges.append((start, end, weight))

# 간선을 가중치에 따라 정렬
edges.sort(key=lambda x: x[2])

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
    start = edges[i][0]
    end = edges[i][1]
    visited = []
    if not is_cycle(start, end, visited):
        adjacency_list[start].append(end)
        adjacency_list[end].append(start)
        minimum_spanning_tree.append(edges[i])
        if len(minimum_spanning_tree) == num_vertices - 1:
            break

print(minimum_spanning_tree)
