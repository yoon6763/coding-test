num = int(input())

a = list
for i in range(num):
    a = list(map(int,input().split()))
    r = (a[0] - a[3]) ** 2 + (a[1] - a[4]) ** 2
    if a[0] == a[3] and a[1] == a[4] and a[2] == a[5]:    #원의 좌표 일치, r 일치
        print(-1)
    elif a[0] == a[3] and a[1] == a[4] and a[2] != a[5]:  #원의 좌표 일치, r 불일치
        print(0)
    elif r == (a[2] - a[5]) ** 2:  #내접 - 1
        print(1)
    elif r < (a[2]-a[5]) ** 2:
        print(0)
    elif r == (a[2]+a[5]) ** 2: # 외접 - 1
        print(1)
    elif r < (a[2]+a[5]) ** 2: # 외접 - 2
        print(2)
    elif r > (a[2]+a[5]) ** 2: # 외접 - 0
        print(0)