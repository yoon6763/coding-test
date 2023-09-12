def selfnum(n):
    num = []
    for i in map(int, str(n)):
        num.append(i)

    result = n + sum(num)
    return result

arr = []

for i in range(1,10000):
    arr.append(i)

for i in range(1,10000):
    temp = selfnum(i)
    if temp in arr:
        arr.remove(temp)

for i in range(len(arr)):
    print(arr[i])