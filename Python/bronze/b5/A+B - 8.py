num = int(input())

for i in range(num):
    a,b = map(int, input().split())
    print('Case #{0}: {1} + {2} = {3}'.format(i+1,a,b,a+b))