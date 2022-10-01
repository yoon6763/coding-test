n, tarn = map(int, input().split())
cm = []
for i in range(n):
    temp = int(input())
    cm.append(temp)

left = 1
right = max(cm)
mid = 0

while (right >= left):
    mid = (left + right) // 2

    s = 0
    for i in cm:
        s = s + i // mid
    if s >= tarn:
        left = mid + 1
    else:
        right = mid - 1

print(right)