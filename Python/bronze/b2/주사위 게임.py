n, m = map(int, input().split(" "))

map = []
for i in range(0, n):
    map.append(int(input()))

now = 0

for i in range(1, n):
    now += int(input())

    if now >= n - 1:
        print(i)
        break

    now += map[now]

    if now >= n - 1:
        print(i)
        break
