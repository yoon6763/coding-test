import math

start, end = map(int, input().split())

square = [ i * i for i in range(2, int(math.sqrt(end)) + 1)]

arr = [ True for i in range(0, end - start + 1)]

for i in range(0,len(square)):
    saveFisrt = (math.ceil(start / square[i]) * square[i]) - start
    idx = 0
    temp = saveFisrt

    while temp <= end - start:
        arr[temp] = False
        idx = idx + 1
        temp = saveFisrt + idx * square[i]


print(sum(arr))