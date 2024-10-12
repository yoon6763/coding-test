import sys

for _ in range(int(input())):
    a = 0
    for i in range(int(input())):
        tmp = list(map(int, input().split()))
        if max(tmp) >= 0: a += max(tmp)
    print(a)
