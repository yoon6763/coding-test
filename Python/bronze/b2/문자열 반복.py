num = int(input())

for i in range(num):
    a, st = input().split()
    stlist = list(st)
    for i in stlist:
        print(i*int(a), end='')

    print()