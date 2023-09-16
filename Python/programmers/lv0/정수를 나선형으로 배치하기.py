def solution(n):
    answer = [[0] * n for _ in range(n)]

    idx = 1
    direction = 0

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    x, y = 0, 0

    while idx <= n * n:
        answer[x][y] = idx

        nx = x + dx[direction]
        ny = y + dy[direction]

        if 0 <= nx < n and 0 <= ny < n and answer[nx][ny] == 0:
            x, y = nx, ny
            idx += 1
        else:
            direction = (direction + 1) % 4
            x += dx[direction]
            y += dy[direction]
            idx += 1

    return answer
