import random
import math

# 주어진 점들
points = [[0, 3], [7, 5], [6, 0], [4, 3], [1, 0], [5, 3], [2, 2], [4, 1]]

# 두 점 사이의 거리를 계산하는 함수
def calculate_distance(point_a, point_b):
    x1, y1 = point_a
    x2, y2 = point_b
    distance = math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)
    return distance

# 주어진 점 순서에 대한 총 거리를 계산하는 함수
def calculate_total_distance(order):
    total_distance = 0
    for i in range(len(order)):
        point_a = points[order[i]]
        point_b = points[order[(i + 1) % len(order)]]
        total_distance += calculate_distance(point_a, point_b)
    return total_distance

# 각 순서에 대한 거리 계산
def calculate_distances(orders):
    distances = [calculate_total_distance(order) for order in orders]
    return distances

# 중복된 값의 인덱스를 찾는 함수
def find_duplicate_index(arr, n):
    value = arr[n]
    try:
        duplicate_index = arr.index(value, 0, n)
        return duplicate_index
    except ValueError:
        try:
            duplicate_index = arr.index(value, n + 1)
            return duplicate_index
        except ValueError:
            return False

# 다음 인덱스를 찾는 함수
def find_next(a, change_index):
    for i in range(len(a)):
        if a[i] == a[change_index] and i != change_index:
            return i

# 순환하는 함수
def cycle(a, b):
    random_num = random.randint(0, 7)
    start_node = a[random_num]
    change_index = random_num
    while True:
        a[change_index], b[change_index] = b[change_index], a[change_index]
        if a[change_index] == start_node:
            break
        status = find_next(a, change_index)
        change_index = status
    return a, b

# 돌연변이 함수
def mutation(arr):
    random_num = random.randint(0, 7)
    a, b = random.sample(range(0, 7), 2)
    arr[random_num][a], arr[random_num][b] = arr[random_num][b], arr[random_num][a]

# 초기 생성
population = [random.sample(range(0, 8), 8) for _ in range(8)]

previous_fitness = 0
current_fitness = 1

# 최적화 반복
while not (current_fitness == previous_fitness):
    previous_fitness = current_fitness

    # 각 순서에 대한 거리 계산
    distances = calculate_distances(population)
    current_fitness = sum(distances)

    # 선택 확률에 따라 새로운 세대 생성
    population = random.choices(population, weights=distances, k=8)

    # 교차 연산 수행
    for i in range(0, 8, 2):
        population[i], population[i + 1] = cycle(population[i], population[i + 1])

    # 돌연변이 수행
    if random.random() < 0.01:
        mutation(population)

# 최적해 출력
distances = calculate_distances(population)
min_distance = min(distances)
min_index = distances.index(min_distance)
optimal_order = population[min_index] + [population[min_index][0]]
print(optimal_order, min_distance)
