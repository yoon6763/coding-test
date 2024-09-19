arr = [list(input().split()) for _ in range(10)]

for i in range(10):
    flag = True
    for j in range(1, 10):
        if arr[i][0] != arr[i][j]:
            flag = False
    if flag:
        print(1)
        exit()

for i in range(10):
    flag = True
    for j in range(1, 10):
        if arr[0][i] != arr[j][i]:
            flag = False
    if flag:
        print(1)
        exit()
print(0)