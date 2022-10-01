arr = [0 for i in range(26)]

st = list(input().upper())

for i in st:
    index = ord(i) - ord('A')
    arr[index] = arr[index] + 1

max = max(arr)
maxc = 0

for i in arr:
    if max == i:
        maxc = maxc + 1

if maxc > 1:
    print('?')
else:
    print(chr(arr.index(max)+ord('A')))
