n = int(input())
find_number = int(input())

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

direction = 0
x, y = 0, 0
cnt = n * n

map = [[0] * n for _ in range(n)]

ans_x, ans_y = 0, 0

while cnt > 0:
    map[x][y] = cnt
    cnt -= 1

    nx = x + dx[direction]
    ny = y + dy[direction]

    if 0 <= nx < n and 0 <= ny < n and map[nx][ny] == 0:
        x = nx
        y = ny
    else:
        direction = (direction + 1) % 4
        x = x + dx[direction]
        y = y + dy[direction]

    if find_number == cnt:
        ans_x, ans_y = x, y

for i in range(n):
    for j in range(n):
        print(map[i][j], end=' ')
    print()

print(ans_x + 1, ans_y + 1)
