num = int(input())

for i in range(num-1,-1,-1):
    print(' '*i, end = '')
    print('*'*(num-i),end='')
    print()