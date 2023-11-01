import pandas as pd
import re

file = 'inupt_quick_sort.xlsx'

df = pd.read_excel(file, header=None)
resort = df.values

def quick_sort(arr):
    if len(arr) <= 1: #배열 길이가 1이하일 때 종료
        return arr
    else:
        pivot = arr[0]  # 피벗은 첫 번째 요소로 선택
        left = []	#pivot보다 작은 데이터 저장할 배열
        right = []  #pivot보다 작은 데이터 저장할 배열
        for x in arr[1:]:  #pivot을 제외한 배열 하나씩 x에 넣음
            if x < pivot:	#pivot보다 작으면 left 배열에 저장
                left.append(x)
            else: #pivot 보다 크면 right 배열에 저장
                right.append(x)
        return quick_sort(left) + [pivot] + quick_sort(right) #left + pivot + right 로 합쳐 새로운 배열 반환
    
        
resort = quick_sort(resort) #퀵 정렬

resort = [int(re.search(r'\[(\d+)\]', str(arr)).group(1)) for arr in resort]
#numpy형태로 저장이 되서 숫자값으로 배열을 변경

print(resort)

df= pd.DataFrame(resort) #엑셀로 저장하기 위해 DataFrame으로 변경

df.to_excel(file, index=False, header=False) #정열된 데이터 덮어쓰기