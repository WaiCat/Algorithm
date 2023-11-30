my_list = [1, 2, 3, 4, 5]

# 중간에서 특정 조건을 만족하는 요소를 찾아 삭제
for item in my_list[:]:  # 사용자가 리스트를 변경하면서 순회하기 위해 슬라이싱 사용
    if item == 3:
        my_list.remove(item)

print(my_list[2])