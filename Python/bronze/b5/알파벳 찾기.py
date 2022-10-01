arr = []

for i in range(26):
    arr.append(-1)

st = list(input())

for i in range(len(st)):
    index = ord(st[i])-ord('a')
    if arr[index] == -1:
        arr[index] = i

for i in range(len(arr)):
    print(arr[i], end = ' ')