a = int(input())
b = int(input())

lst = list()

for i in range(a, b+1):
    lst.append(i)

for i in range(len(lst)):
    check = False
    n = 0
    for j in range(2, lst[i]):
        if lst[i] % j == 0:
            lst[i] = 0
            break;

lst = [i for i in lst if i != 0 and i != 1]

if len(lst) == 0:
    print(-1)
else:
    print(sum(lst))
    print(min(lst))