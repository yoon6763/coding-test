import sys

num = int(sys.stdin.readline().rstrip())

for i in range(0,num):
    a,b  = map(int,sys.stdin.readline().rstrip().split())
    print(a+b)