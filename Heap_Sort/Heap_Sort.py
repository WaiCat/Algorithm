# 파일 경로 (한글이 포함된 경우)
file_path = "C:/Users/Administrator/Downloads/University/3학년 2학기/Algorithm/Heap/input.txt"
output_file_path = "C:/Users/Administrator/Downloads/University/3학년 2학기/Algorithm/Heap/output.txt"

A = []

def BuildHeap(A):
    # 힙을 구축하기 위해 반복문 수행
    for i in range(n // 2 - 1, -1, -1):
        DownHeap(i)

def DownHeap(i):
    leftChild = 2 * i + 1
    rightChild = 2 * i + 2
    
    # 왼쪽 자식이 힙 크기 내에 있고 현재 요소보다 크다면
    if leftChild <= heapSize - 1 and A[leftChild] > A[i]:
        bigger = leftChild
    else:
        bigger = i
    
    # 오른쪽 자식이 힙 크기 내에 있고 현재 요소나 왼쪽 자식보다 크다면
    if rightChild <= heapSize - 1 and A[rightChild] > A[bigger]:
        bigger = rightChild
    
    # 현재 요소보다 큰 자식이 있을 경우 교환 수행
    if not (bigger == i):
        A[i], A[bigger] = A[bigger], A[i]
        DownHeap(bigger)


# 파일 열기
with open(file_path, 'r', encoding='utf-8') as file:
    # 파일 내용을 한 줄씩 읽어오기
    for line in file:
        # 각 줄의 앞뒤 공백 및 개행 문자 제거 후 정수로 변환하여 A에 추가
        tmp = line.strip()
        if tmp:
            A.append(int(tmp))
    
n = len(A)
heapSize = len(A)

# 힙 정렬 수행
BuildHeap(A)

for i in range(n - 1, 0, -1):
    # 배열의 첫 번째 요소와 현재 인덱스의 요소를 교환
    A[i], A[0] = A[0], A[i]
    
    # 힙 크기 감소
    heapSize = heapSize - 1
    
    # 힙 속성을 만족시키기 위해 다운힙 수행
    DownHeap(0)

# 결과를 output.txt에 쓰기
with open(output_file_path, 'w', encoding='utf-8') as output_file:
    for num in A:
        output_file.write(str(num) + '\n')

print("힙 정렬 결과는 output.txt에 저장되었습니다.")
