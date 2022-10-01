import math

layer = int(input())

for i in range(layer):
    h,w,n = map(int,input().split())
    temp = n%h
    if temp == 0:
        temp = h
    print("{0}{1:02d}".format(temp, math.ceil(n/h)))