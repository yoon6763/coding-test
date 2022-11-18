import sys
input = sys.stdin.readline
print = sys.stdout.write
n = int(input())
grade = []
for i in range(n):
    jumsu = list(input().split())
    grade.append(jumsu)

for i in range(n):
    grade[i][1] = int(grade[i][1])
    grade[i][2] = int(grade[i][2])
    grade[i][3] = int(grade[i][3])
grade.sort(key=lambda x: (-x[1],x[2],-x[3], x[0]))

for i in range(n):
    print(grade[i][0]+"\n")
