t = int(input())

def get_grade(score):
    if score == 0:
        return "A+"
    elif score == 1:
        return "A0"
    elif score == 2:
        return "A-"
    elif score == 3:
        return "B+"
    elif score == 4:
        return "B0"
    elif score == 5:
        return "B-"
    elif score == 6:
        return "C+"
    elif score == 7:
        return "C0"
    elif score == 8:
        return "C-"
    else:
        return "D0"

for i in range(t):
  n, k = map(int, input().split())
  sortn = n/10
  student =[]
  for _ in range(n):
    a, b, c = map(int, input().split())
    student.append(a*0.35 + b*0.45 + c*0.2)
  sort_student = sorted(student, reverse=True)
  result = sort_student.index(student[k-1])//sortn
  
  
  print("#", (i+1), " ", get_grade(result), sep="")
